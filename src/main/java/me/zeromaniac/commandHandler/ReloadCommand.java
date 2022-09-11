package me.zeromaniac.commandHandler;

import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.PlayerHelper;
import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.handlers.ConfigHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Arrays;
import java.util.List;

public class ReloadCommand implements CommandHandler {

    MoreDiscordSRVHooks plugin;

    public ReloadCommand(MoreDiscordSRVHooks plugin){
        this.plugin = plugin;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return Arrays.stream(new String[]{"reload", "info"}).toList();
    }

    // note: The command sender is a player, check for permissions
    @Override
    public boolean executeCommandAsPlayer(Player sender, Command command, String label, String[] args) {
        Player player = sender;
        if (args.length == 0) {
            PlayerHelper.playerMessage(player, PlayerHelper.INVALID_COMMAND_PLAYER);
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("morediscordsrvhooks.reload") || player.isOp()) {
                    ConfigHandler.reloadAllConfigs();
                    PlayerHelper.playerMessage(player, PlayerHelper.CONFIGS_RELOADED);
                } else {
                    PlayerHelper.playerMessage(player, PlayerHelper.NO_PERMISSION);
                }
            }
            if(args[0].equalsIgnoreCase("info")){
                if (player.hasPermission("morediscordsrvhooks.info") || player.isOp()) {
                    PlayerHelper.playerMessageShort(player, "&bPlugin:&r " + PlayerHelper.MY_PLUGIN_NAME);
                    PlayerHelper.playerMessageShort(player, "&bVersion:&r " +PlayerHelper.MY_PLUGIN_VERSION);
                    PlayerHelper.playerMessageShort(player, "&bAuthors:&r " + PlayerHelper.MY_PLUGIN_AUTHORS);
                    PlayerHelper.playerMessageShort(player, "&bDependencies:&r " + PlayerHelper.MY_PLUGIN_DEPENDENCIES);
                    PlayerHelper.playerMessageShort(player, "&bAvailable Hooks:&r " + PlayerHelper.MY_PLUGIN_SOFTDEPENDS);
                } else {
                    PlayerHelper.playerMessage(player, PlayerHelper.NO_PERMISSION);
                } 
                
            }
        }
        return true;
    }

    // note: The command sender is console, no permission checks necessary
    @Override
    public boolean executeCommandAsConsole(ConsoleCommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            SystemHelper.consoleMessage(SystemHelper.invalidCommandByConsole);
        } else if (args[0].equalsIgnoreCase("reload")) {
            ConfigHandler.reloadAllConfigs();
            SystemHelper.consoleMessage(SystemHelper.CONFIGS_RELOADED);
        } else if(args[0].equalsIgnoreCase("info")){
            SystemHelper.infoCommandOutputConsole();
        }
        return true;
    }
}
