package me.zeromaniac.listener;

import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.AuctionGuiPlusEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.AuctionEventType;
import net.brcdev.auctiongui.AuctionGuiPlusApi;
import net.brcdev.auctiongui.auction.Auction;
import net.brcdev.auctiongui.auction.AuctionManager;
import net.brcdev.auctiongui.auction.Bid;
import net.brcdev.auctiongui.event.AuctionBidEvent;
import net.brcdev.auctiongui.event.AuctionEndEvent;
import net.brcdev.auctiongui.event.AuctionPreStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import javax.annotation.Nullable;

public class AuctionGUIPlusListener implements Listener {
    private final AuctionManager manager;
    private final MoreDiscordSRVHooks plugin;
    private int auctionCache = -1;
    boolean debug;

    public AuctionGUIPlusListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;
        this.manager = AuctionGuiPlusApi.getAuctionManager();
        initializeAuctionsCache();
        
        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_AUCTION_GUI_PLUS_DEBUG.getPath());
    }

    private void initializeAuctionsCache() {
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            if (manager.getAllAuctions() != null) {
                auctionCache = manager.getAllAuctions().size();
            } else {
                auctionCache = 0;
            }
        }, 1L);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionStart(AuctionPreStartEvent event) {
        Debug.log("Detected AuctionGUIPlus Event firing, Type: " + event.getEventName(), debug);
        if (event.isCancelled())
            return;
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            if (auctionCache == manager.getAllAuctions().size()) {
                return;
            }
            auctionCache = manager.getAllAuctions().size();
            ProcessEvent(AuctionEventType.START, event.getAuction(), null);
        }, 5L);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionBid(AuctionBidEvent event) {
        Debug.log("Detected AuctionGUIPlus Event firing, Type: " + event.getEventName(), debug);
        if (event.isCancelled())
            return;
        Bid bid = new Bid(event.getPlayer().getUniqueId(), event.getPlayer().getName(), event.getBid(),
                System.currentTimeMillis());
        ProcessEvent(AuctionEventType.BID, event.getAuction(), bid);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionEnd(AuctionEndEvent event) {
        Debug.log("Detected AuctionGUIPlus Event firing, Type: " + event.getEventName(), debug);
        if (event.getAuction().getHighestBid() != null) {
            ProcessEvent(AuctionEventType.END_SOLD, event.getAuction(), null);
        } else if (event.getAuction().getHighestBid() == null) {
            ProcessEvent(AuctionEventType.END_NO_BIDS, event.getAuction(), null);
        } else {
            ProcessEvent(AuctionEventType.END_NO_BIDS, event.getAuction(), null);
        }
    }

    private void ProcessEvent(AuctionEventType type, Auction auction, @Nullable Bid bid) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            OfflinePlayer player = auction.getOwner();
            OfflinePlayer bidder = null;
            OfflinePlayer buyer = null;
            double amount = 0;

            if (player == null) {
                return;
            }
            if (AuctionEventType.BID == type && bid != null) {
                bidder = bid.getBidder();
                amount = bid.getAmount();
            }
            if (auction.getHighestBid() != null) {
                buyer = auction.getHighestBid().getBidder();
            }

            int id = auction.getId();
            if (id == 0) {
                id = manager.getAllAuctions().size() + 1;
            }

            long timeLeft = ((auction.getEndTimestamp() - System.currentTimeMillis()) / 1000);

            AbstractEmbed embed = new AuctionGuiPlusEmbed(player, bidder, buyer, auction.getItemStack(), id,
                    parseTime(timeLeft, " minutes ", " seconds"), Math.round(auction.getCurrentPrice()),
                    Math.round(auction.getStartingPrice()), Math.round(auction.getIncrement()), Math.round(amount),
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