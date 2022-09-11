package me.zeromaniac.config;

import com.google.common.base.Charsets;
import me.zeromaniac.common.SystemHelper;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;

public abstract class ConfigLoader {
    public static String PLUGIN_NAME = "MoreDiscordSRVHooks";
    protected FileConfiguration config;
    protected File configFile;
    protected final File dataFolder;
    protected final String configName;
    protected final String pluginName;

    ConfigLoader(String configName, String pluginName) {
        this.pluginName = pluginName;

        this.dataFolder = Bukkit.getPluginManager().getPlugin(PLUGIN_NAME).getDataFolder();
        this.configName = configName;

        this.configFile = new File(dataFolder + "/" + configName);

        saveResource(configName, false);

        SystemHelper.consoleMessage(SystemHelper.LOADING_CONFIG + configName);
        this.config = getConfig();
    }

    ConfigLoader(String configName) {
        this.pluginName = PLUGIN_NAME;
        this.dataFolder = Bukkit.getPluginManager().getPlugin(PLUGIN_NAME).getDataFolder();
        this.configName = configName;
        this.configFile = new File(dataFolder + "/" + configName);
        saveResource(configName, false);
        SystemHelper.consoleMessage(SystemHelper.LOADING_CONFIG + configName);
        this.config = getConfig();
    }

    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }
        return config;
    }

    public void reloadConfig() {
        if (!configFile.exists()){
            saveResource(configName, false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);
        final InputStream defConfigStream = getResource(configName);
        if (defConfigStream == null) {
            return;
        }

        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        loadMyConfig();
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public abstract void loadMyConfig();
    public boolean configContainsKey(String configKey){
        if (config.contains(configKey, true)) {
            return true;
        }
        return false;
    }

    private InputStream getResource(@NotNull String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }
        try {
            URL url = this.getClass().getClassLoader().getResource(filename);
            if (url == null) {
                return null;
            }
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException ex) {
            return null;
        }
    }

    private void saveResource(@NotNull String resourcePath, boolean replace) {
        if (resourcePath == null || resourcePath.equals("")) {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }

        resourcePath = resourcePath.replace('\\', '/');
        InputStream in = getResource(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in " + PLUGIN_NAME);
        }

        File outFile = new File(dataFolder, resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');
        File outDir = new File(dataFolder, resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));

        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        try {
            if (!outFile.exists() || replace) {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } else {
                // Bukkit.getLogger().log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
                SystemHelper.consoleMessage("&bFile &3" + outFile.getName() + " &balready exists. Skipping creation.");
            }
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, ex);
        }
    }
}
