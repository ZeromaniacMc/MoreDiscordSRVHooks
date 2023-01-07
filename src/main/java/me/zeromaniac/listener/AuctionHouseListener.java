package me.zeromaniac.listener;


import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.AuctionEventType;
import org.bukkit.Bukkit;
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

    // We are reusing the AuctionEventType class also used by AuctionGui Hook - no point in making another.
    @EventHandler(priority = EventPriority.HIGHEST)
    public void newAuction(<LOOHP EVENT NAME> event) {
        Debug.log("Detected AuctionHouse Event firing, Type: " + event.getEventName(), debug);
        // LOOHP HERE - > 'NEW AUCTION'
    }



    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionSold(<LOOHP EVENT NAME> event) {
        Debug.log("Detected AuctionHouse Event firing, Type: " + event.getEventName(), debug);
        // LOOHP HERE - > 'AUCTION SOLD'
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void auctionExpired(<LOOHP EVENT NAME> event) {
        Debug.log("Detected AuctionHouse Event firing, Type: " + event.getEventName(), debug);
        // LOOHP HERE - > 'NEW AUCTION'
    }

    // LOOHP HERE
    public void ProcessEvent(send every info to fetch to the embed builder) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () - > {
                AbstractEmbed embed = new AuctionHouseEmbed();

                embed.sendEmbed();
        });
     }
}
