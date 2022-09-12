package me.zeromaniac;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.handlers.CommandRegister;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.handlers.ListenerManager;

import org.bukkit.plugin.java.JavaPlugin;

public final class MoreDiscordSRVHooks extends JavaPlugin {

    @Override
    public void onEnable() {

        // Letting user know we are doing stuff ;)
        SystemHelper.consoleMessage(SystemHelper.PLUGIN_STARTING_CONFIGS);

        // Initialize configs
        new ConfigHandler();

        // Register commands & listeners from listener manager
        new CommandRegister(this);
        new ListenerManager(this).registerListener();

        // Just starting
        SystemHelper.consoleMessage(SystemHelper.PLUGIN_STARTING);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SystemHelper.consoleMessage(SystemHelper.PLUGIN_SHUTDOWN);
    }
}
