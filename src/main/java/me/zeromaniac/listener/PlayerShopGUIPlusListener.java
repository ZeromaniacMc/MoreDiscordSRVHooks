package me.zeromaniac.listener;

import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.PlayerShopGuiPlusEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.PlayerShopEventType;
import net.brcdev.playershopgui.PlayerShopGuiPlusApi;
import net.brcdev.playershopgui.event.CreateItemLotEvent;
import net.brcdev.playershopgui.event.ExpireItemLotEvent;
import net.brcdev.playershopgui.event.PurchaseItemLotEvent;
import net.brcdev.playershopgui.shop.Shop;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerShopGUIPlusListener implements Listener {
    MoreDiscordSRVHooks plugin;
    boolean debug;

    public PlayerShopGUIPlusListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_PLAYER_SHOP_GUI_PLUS_DEBUG.getPath());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void itemSell(CreateItemLotEvent event) {
        Debug.log("Detected PlayerShopGUIPlus Event firing, Type: " + event.getEventName(), debug);
        ProcessEvent(PlayerShopEventType.START,
                event.getShop(),
                event.getItemStack(),
                event.getQuantity(),
                event.getPrice(),
                null);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void itemSold(PurchaseItemLotEvent event) {
        Debug.log("Detected PlayerShopGUIPlus Event firing, Type: " + event.getEventName(), debug);
        if (event.isCancelled())
            return;
        ProcessEvent(PlayerShopEventType.END_SOLD,
                event.getShop(),
                event.getItemStack(),
                event.getQuantity(),
                event.getShopItem().getPrice(),
                event.getBuyer());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void itemExpired(ExpireItemLotEvent event) {
        Debug.log("Detected PlayerShopGUIPlus Event firing, Type: " + event.getEventName(), debug);
        ProcessEvent(PlayerShopEventType.END_EXPIRED,
                event.getWrappedShopElement().getShop(),
                event.getWrappedShopElement().getShopItem().getItemStack(),
                event.getWrappedShopElement().getShopItem().getItemStack().getAmount(),
                event.getWrappedShopElement().getShopItem().getPrice(),
                null);
    }

    /**
     * @param type = Enum of event type
     * @param shop = Shop
     * @param stack = Itemstack item tofrom shop
     * @param quantity = int of item quantity
     * @param price = double of price
     * @param buyer = buyer player
     */
    public void ProcessEvent(PlayerShopEventType type, Shop shop, ItemStack stack, int quantity,
            double price, OfflinePlayer buyer) {

        OfflinePlayer player = shop.getOwner();
        if (player == null) {
            return;
        }

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            AbstractEmbed embed = new PlayerShopGuiPlusEmbed(player, buyer, stack, price, quantity, type, getTime());

            embed.sendEmbed();
        });
    }

    public String getTime() {
        int configTime = PlayerShopGuiPlusApi.getPlugin().getConfig().getInt("shopItemDuration");

        String timeBuilder;
        if (configTime == -1) {
            return "Never";
        } else {
            long newTimeDays = configTime / 60 / 24;
            long newTimeHours = (configTime - (newTimeDays * 60 * 24)) / 60;
            String daysString = "days";
            String hoursString = "hours";

            if (newTimeHours != 0) {
                timeBuilder = newTimeDays + " " + daysString + " " + newTimeHours + " " + hoursString;
            } else {
                timeBuilder = newTimeDays + " " + daysString;
            }
        }
        return timeBuilder;
    }

}