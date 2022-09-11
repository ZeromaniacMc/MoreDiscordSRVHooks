package me.zeromaniac.commandHandler;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public interface CommandHandler extends CommandExecutor, TabCompleter {
    @Override
    default boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            return executeCommandAsPlayer((Player) sender, command, label, args);
        } else {
            return executeCommandAsConsole((ConsoleCommandSender) sender, command, label, args);
        }
    }

    default boolean executeCommandAsPlayer(Player sender, Command command, String label, String[] args) {
        return true;
    }

    default boolean executeCommandAsConsole(ConsoleCommandSender sender, Command command, String label, String[] args) {
        return true;
    }

}
