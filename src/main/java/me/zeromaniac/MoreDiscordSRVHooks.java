package me.zeromaniac;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.handlers.CommandRegister;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.handlers.ListenerManager;

import org.bukkit.plugin.java.JavaPlugin;

public final class MoreDiscordSRVHooks extends JavaPlugin {

    @Override
    public void onEnable() {
        // Initialize configs
        new ConfigHandler();

        // Register commands
        new CommandRegister(this);

        new ListenerManager(this).registerListener();

        // Just starting
        SystemHelper.consoleMessage(SystemHelper.PLUGIN_STARTING);
        SystemHelper.consoleMessage(SystemHelper.PLUGIN_STARTING_FUN);

        // Version/plugin checks

        SystemHelper.consoleMessage(SystemHelper.COMMENCING_PLUGIN_CHECK);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SystemHelper.consoleMessage(SystemHelper.PLUGIN_SHUTDOWN);
    }
}
