package me.zeromaniac.common;

import org.bukkit.Bukkit;

public class ThirdPartyChecker {

    public static boolean isPluginInstalled(String name) {
        if (Bukkit.getServer().getPluginManager().getPlugin(name) == null) {
            SystemHelper.consoleMessage("&c" + name + SystemHelper.PLUGIN_NOT_INSTALLED);
            return false;
        }

        return true;
    }

}
