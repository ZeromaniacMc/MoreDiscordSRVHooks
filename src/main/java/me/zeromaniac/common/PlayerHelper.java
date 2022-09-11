package me.zeromaniac.common;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerHelper {

    // note: crucial player messages

    public static String playerMessage(Player p, String message) {
        p.sendMessage(colorizer(PLUGIN_PREFIX + message));
        return message;
    }

    public static String playerMessageShort(Player p, String message) {
        p.sendMessage(colorizer(SHORT_PREFIX + message));
        return message;
    }

    private static String colorizer(String text) {
        return ChatColor.translateAlternateColorCodes('&',text);
    }

    public static String MY_PLUGIN_NAME = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getName();
    public static String MY_PLUGIN_VERSION = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getVersion();
    public static String MY_PLUGIN_AUTHORS = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getAuthors().toString();
    public static String MY_PLUGIN_CONTRIBUTORS = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getContributors().toString();
    public static String MY_PLUGIN_DEPENDENCIES = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getDepend().toString();
    public static String MY_PLUGIN_SOFTDEPENDS = Bukkit.getPluginManager().getPlugin("MoreDiscordSRVHooks").getDescription().getSoftDepend().toString();

    private static String PLUGIN_PREFIX = "&3[&bMoreDiscordSRVHooks&3]&r ";

    private static String SHORT_PREFIX = "&3[&bMDH&3]&r ";

    public static String INVALID_COMMAND_PLAYER = "&bInvalid command. Did you mean /mdh reload?";

    public static String CONFIGS_RELOADED = "&bConfigs successfully reloaded!";

    public static String NO_PERMISSION = "&bYou do not have permission to use this.";

}
