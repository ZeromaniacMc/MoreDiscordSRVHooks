package me.zeromaniac.listener;

import fr.maxlego08.zauctionhouse.api.AuctionItem;
import fr.maxlego08.zauctionhouse.api.event.events.AuctionItemExpireEvent;
import fr.maxlego08.zauctionhouse.api.event.events.AuctionPostBuyEvent;
import fr.maxlego08.zauctionhouse.api.event.events.AuctionSellEvent;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.ZAuctionHouseEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.AuctionEventType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import javax.annotation.Nullable;
import java.util.UUID;

public class ZAuctionHouseListener implements Listener {

    private final MoreDiscordSRVHooks plugin;
    boolean debug;

    public ZAuctionHouseListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;
        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_ZAUCTION_HOUSE_ENABLED.getPath());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionStart(AuctionSellEvent event) {
        Debug.log("Detected ZAuctionHouse Event firing, Type: " + event.getEventName(), debug);
        if (event.isCancelled())
            return;
        ProcessEvent(AuctionEventType.START, event.getAuctionItem(), event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionBid(AuctionPostBuyEvent event) {
        Debug.log("Detected ZAuctionHouse Event firing, Type: " + event.getEventName(), debug);
        if (event.isCancelled())
            return;
        ProcessEvent(AuctionEventType.BID, event.getAuctionItem(), event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionEnd(AuctionItemExpireEvent event) {
        Debug.log("Detected ZAuctionHouse Event firing, Type: " + event.getEventName(), debug);
        if (event.getAuctionItem().getBuyer() != null) {
            ProcessEvent(AuctionEventType.END_SOLD, event.getAuctionItem(), null);
        } else {
            ProcessEvent(AuctionEventType.END_EXPIRED, event.getAuctionItem(), null);
        }
    }

    private void ProcessEvent(AuctionEventType type, AuctionItem auction, @Nullable Player player) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            OfflinePlayer seller = auction.getSeller();
            OfflinePlayer buyer = auction.getBuyer();

            UUID id = auction.getUniqueId();

            long timeLeft = ((auction.getExpireAt() - System.currentTimeMillis()) / 1000);

            AbstractEmbed embed = new ZAuctionHouseEmbed(player, seller, buyer, auction.getItemStack(), id,
                    parseTime(timeLeft, " minutes ", " seconds"), Math.round(auction.getPrice()),
                    type);

            embed.sendEmbed();
        });
    }

    public String parseTime(long timeLeft, String minutesString, String secondsString) {
        long minutes = timeLeft / 60;
        long seconds = timeLeft % 60;
        String secPart = "";

        if (seconds != 0) {
            secPart = seconds + secondsString;
        }

        return minutes + minutesString + secPart;
    }
}