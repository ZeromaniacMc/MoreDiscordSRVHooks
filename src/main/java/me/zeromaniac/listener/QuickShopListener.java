package me.zeromaniac.listener;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.maxgamer.quickshop.api.event.ShopCreateEvent;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.QuickShopEmbed;
import me.zeromaniac.listener.enums.QuickShopEventType;

public class QuickShopListener implements Listener {
    MoreDiscordSRVHooks plugin;
    boolean debug;

    public QuickShopListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        // debug = ?
    }

    @EventHandler(priority = EventPriority.HIGHEST) 
    public void CREATE(ShopCreateEvent event) {
        //Debug.log
        ProcessEvent(QuickShopEventType.CREATE,
        event.getShop().getOwner(),
        event.getShop().getItem(),
        event.getShop().getLocation().getX(),
        event.getShop().getLocation().getY(),
        event.getShop().getLocation().getZ(),
        event.getShop().getShopType().toID(),
        event.getShop().getPrice());
    }

    public void ProcessEvent(QuickShopEventType type, UUID owner , ItemStack item,
        double locationX, double locationY, double locationZ, int shoptype, double price) {

            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                AbstractEmbed embed = new QuickShopEmbed(type, owner, item, locationX,
                    locationY, locationZ, shoptype, price);
                
            embed.sendEmbed();
            });
        }
}
