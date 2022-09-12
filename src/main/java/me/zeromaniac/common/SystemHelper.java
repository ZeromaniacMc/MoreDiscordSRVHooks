package me.zeromaniac.common;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.util.logging.Level;

public class SystemHelper {

    // note: Crucial system messages

    public static void consoleMessage(String message) {
        Bukkit.getServer().getLogger().log(Level.INFO, colorizer(PLUGIN_PREFIX + message));
    }

    public static void logDebug(String message, boolean debug) {
        Debug.log(message, debug);
    }

    private static String colorizer(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void infoCommandOutputConsole() {
        String myName = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getName();
        String myVersion = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getVersion();
        String myAuthors = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getAuthors().toString();
        String myContributors = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getContributors().toString();
        String myDepends = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getDepend().toString();
        String mySoftDepends = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getSoftDepend().toString();

        SystemHelper.consoleMessage("Plugin: " + myName);
        SystemHelper.consoleMessage("Version: " + myVersion);
        SystemHelper.consoleMessage("Authors: " + myAuthors);
        SystemHelper.consoleMessage("Contributers: " + myContributors);
        SystemHelper.consoleMessage("Dependencies: " + myDepends);
        SystemHelper.consoleMessage("Available Hooks: " + mySoftDepends);
    }

    private static String PLUGIN_PREFIX = "&3[&bMoreDiscordSRVHooks&3]&r ";
    public static String PLUGIN_STARTING = "&bThank you for using MoreDiscordSRVHooks!";
    public static String PLUGIN_STARTING_CONFIGS = "&bChecking config file status...";
    public static String INVALID_COMMAND_CONSOLE = "&bInvalid command. Did you mean /mdh reload?";
    public static String PLUGIN_SHUTDOWN = "&bCommencing detonation... bye!";
    public static String CONFIGS_RELOADED = "&bConfigs successfully reloaded!";
    public static String ERROR = "&4Missing key or value for &c";
    public static String IN_CONFIG = " &4in config: &c";
    public static String USING_DEFAULT = "&4Using default value of &c";
    public static String PLUGIN_NOT_INSTALLED = " &4is not installed on your server.";

}
