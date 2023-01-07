package me.zeromaniac.listener;


import com.spawnchunk.auctionhouse.events.AuctionItemEvent;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.AuctionHouseEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.AuctionEventType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AuctionHouseListener implements Listener {

    private final MoreDiscordSRVHooks plugin;
    boolean debug;

    public AuctionHouseListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;
        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_AUCTION_HOUSE_DEBUG.getPath());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auction(AuctionItemEvent event) {
        Debug.log("Detected AuctionHouse Event firing, Type: " + event.getEventName(), debug);
        // LOOHP HERE - > 'NEW AUCTION'
        switch (event.getItemAction()) {
            case ITEM_LISTED -> ProcessEvent(AuctionEventType.START, event);
            case ITEM_SOLD -> ProcessEvent(AuctionEventType.END_SOLD, event);
            case ITEM_CANCELLED, ITEM_RETURNED -> ProcessEvent(AuctionEventType.END_EXPIRED, event);
        }
    }

    public void ProcessEvent(AuctionEventType type, AuctionItemEvent auction) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

                OfflinePlayer player = auction.getSeller();
                OfflinePlayer bidder = auction.getBidder();
                OfflinePlayer buyer = auction.getBuyer();

                if (player == null) {
                    return;
                }

                AbstractEmbed embed = new AuctionHouseEmbed(player, bidder, buyer, auction.getItem(),
                        auction.getPrice(), auction.getBid(), type);

                embed.sendEmbed();
        });
     }
}
