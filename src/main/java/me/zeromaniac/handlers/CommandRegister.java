package me.zeromaniac.handlers;

import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.commandHandler.ReloadCommand;

public class CommandRegister {
    private final ReloadCommand reloadCommand;

    public CommandRegister(MoreDiscordSRVHooks plugin) {

        reloadCommand = new ReloadCommand(plugin);

        plugin.getCommand("mdh").setExecutor(reloadCommand);
        plugin.getCommand("mdh").setTabCompleter(reloadCommand);
    }
}
