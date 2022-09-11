package me.zeromaniac.handlers;

import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.ThirdPartyChecker;
import me.zeromaniac.listener.AngelChestListener;
import me.zeromaniac.listener.AuctionGUIPlusListener;
import me.zeromaniac.listener.LiteBansListener;
import me.zeromaniac.listener.PlayerShopGUIPlusListener;

import org.bukkit.Bukkit;

public class ListenerManager {
    private final MoreDiscordSRVHooks plugin;

    public ListenerManager(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;
    }

    public void registerListener() {
        if (ThirdPartyChecker.isPluginInstalled("AuctionGUIPlus")) {
            Bukkit.getServer().getPluginManager().registerEvents(new AuctionGUIPlusListener(plugin), plugin);
        }
        if (ThirdPartyChecker.isPluginInstalled("PlayerShopGUIPlus")) {
            Bukkit.getServer().getPluginManager().registerEvents(new PlayerShopGUIPlusListener(plugin), plugin);
        }
        if (ThirdPartyChecker.isPluginInstalled("AngelChest")) {
            Bukkit.getServer().getPluginManager().registerEvents(new AngelChestListener(plugin), plugin);
        }
        if (ThirdPartyChecker.isPluginInstalled("LiteBans")) {
            Bukkit.getServer().getPluginManager().registerEvents(new LiteBansListener(plugin), plugin);
        }
    }
}
