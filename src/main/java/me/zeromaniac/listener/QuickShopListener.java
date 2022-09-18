package me.zeromaniac.listener;

import java.util.UUID;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.maxgamer.quickshop.api.event.ShopCreateEvent;
import org.maxgamer.quickshop.api.event.ShopSuccessPurchaseEvent;
import me.zeromaniac.common.Debug;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.QuickShopEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.QuickShopEventType;

public class QuickShopListener implements Listener {
    MoreDiscordSRVHooks plugin;
    boolean debug;

    public QuickShopListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_QUICK_SHOP_DEBUG.getPath());
    }

    @EventHandler(priority = EventPriority.HIGHEST) 
    public void createShop(ShopCreateEvent event) {
        Debug.log("Detected QuickShop Event firing: ShopCreateEvent, Type: " + event.getEventName(), debug);
        ProcessEvent(QuickShopEventType.createShop,
        event.getShop().getOwner(),
        event.getShop().getItem(),
        event.getShop().getLocation().getX(),
        event.getShop().getLocation().getY(),
        event.getShop().getLocation().getZ(),
        event.getShop().getShopType().toID(),
        event.getShop().getPrice(),
        0,
        0,
        0,
        0,
        null,
        event.getShop().getLocation().getWorld().getName());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void purchaseSuccess(ShopSuccessPurchaseEvent event) {
        Debug.log("Detected QuickShop Event firing: ShopSuccessPurchaseEvent, Type: " + event.getEventName(), debug);
        ProcessEvent(QuickShopEventType.purchaseSuccess,
        event.getShop().getOwner(),
        event.getShop().getItem(),
        event.getShop().getLocation().getX(),
        event.getShop().getLocation().getY(),
        event.getShop().getLocation().getZ(),
        event.getShop().getShopType().toID(),
        event.getShop().getPrice(),
        event.getAmount(),
        event.getBalance(),
        event.getTax(),
        event.getBalanceWithoutTax(),
        event.getPurchaser(),
        event.getShop().getLocation().getWorld().getName());
    }

    /**
     * @param type = Enum of event type
     * @param owner = UUID of owner of the shop
     * @param item = Itemstack of item sold/bought in the shop
     * @param locationX = int of location X of the shop container
     * @param locationY = int of location Y of the shop container
     * @param locationZ = int of location Z of the shop container
     * @param shoptype = int from quickshop 0 for selling, 1 for buying identifier
     * @param price = double of price for shop item buying/selling
     */
    public void ProcessEvent(QuickShopEventType type, UUID owner , ItemStack item,
        double locationX, double locationY, double locationZ, int shoptype, double singleItemPriceBeforeTax, int amount,
        double incomeAfterTax, double tax, double incomeBeforeTax, UUID buyer, String world) {

            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                AbstractEmbed embed = new QuickShopEmbed(type, owner, item, locationX,
                    locationY, locationZ, shoptype, singleItemPriceBeforeTax, amount, incomeAfterTax, tax, incomeBeforeTax,
                    buyer, worldRegexer(world));
                
            embed.sendEmbed();
            });
        }

    public String worldRegexer(String world) {
        Pattern worldNameNoUnderScores = Pattern.compile("_");
        return worldNameNoUnderScores.matcher(world).replaceAll(" ");
    }
}
