package me.zeromaniac.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import com.olziedev.playerwarps.api.events.PlayerWarpCreateEvent;
import com.olziedev.playerwarps.api.events.PlayerWarpRemoveEvent;
import com.olziedev.playerwarps.api.events.PlayerWarpTeleportEvent;
import com.olziedev.playerwarps.api.player.WPlayer;
import com.olziedev.playerwarps.api.warp.WIcon;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.PlayerWarpsEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.PlayerWarpsEventType;

public class PlayerWarpsListener implements Listener {
    MoreDiscordSRVHooks plugin;
    boolean debug;

    public PlayerWarpsListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_PLAYER_WARPS_DEBUG.getPath());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreate(PlayerWarpCreateEvent event) {
        Debug.log("Detected Player Warp Event firing, Type: PlayerWarpCreateEvent", debug);

        if (event.getPlayerWarp() == null)
            return;

        ProcessEvent(PlayerWarpsEventType.warpCreated,
                event.getPlayerWarp().getWarpCost(),
                event.getPlayerWarp().getID(),
                event.getPlayerWarp().getWarpName(),
                event.getPlayerWarp().getWarpDescription(true),
                event.getPlayerWarp().getWarpIcon(),
                event.getPlayerWarp().getWarpPlayer(),
                event.getPlayerWarp().getWarpLocation().getWorld(),
                event.getPlayerWarp().getWarpLocation().getX(),
                event.getPlayerWarp().getWarpLocation().getY(),
                event.getPlayerWarp().getWarpLocation().getZ(),
                event.getPlayerWarp().getWarpCategory().getName(),
                event.getPlayerWarp().getWarpCategory().getIcon(),
                event.getPlayerWarp().getWarpCategory().getTeleportPrice(),
                0,
                "");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTeleport(PlayerWarpTeleportEvent event) {
        Debug.log("Detected Player Warp Event firing, Type: PlayerWarpTeleportEvent", debug);

        ProcessEvent(PlayerWarpsEventType.onTeleport,
                event.getPlayerWarp().getWarpCost(),
                event.getPlayerWarp().getID(),
                event.getPlayerWarp().getWarpName(),
                event.getPlayerWarp().getWarpDescription(true),
                event.getPlayerWarp().getWarpIcon(),
                event.getPlayerWarp().getWarpPlayer(),
                event.getPlayerWarp().getWarpLocation().getWorld(),
                event.getPlayerWarp().getWarpLocation().getX(),
                event.getPlayerWarp().getWarpLocation().getY(),
                event.getPlayerWarp().getWarpLocation().getZ(),
                event.getPlayerWarp().getWarpCategory().getName(),
                event.getPlayerWarp().getWarpCategory().getIcon(),
                event.getPlayerWarp().getWarpCategory().getTeleportPrice(),
                event.getPlayerWarp().getWarpRate().getRateAverage(),
                event.getTeleporter().getName());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRemove(PlayerWarpRemoveEvent event) {
        Debug.log("Detected Player Warp Event firing, Type: PlayerWarpRemoveEvent", debug);

        ProcessEvent(PlayerWarpsEventType.warpDeleted,
                event.getPlayerWarp().getWarpCost(),
                event.getPlayerWarp().getID(),
                event.getPlayerWarp().getWarpName(),
                event.getPlayerWarp().getWarpDescription(true),
                event.getPlayerWarp().getWarpIcon(),
                event.getPlayerWarp().getWarpPlayer(),
                event.getPlayerWarp().getWarpLocation().getWorld(),
                event.getPlayerWarp().getWarpLocation().getX(),
                event.getPlayerWarp().getWarpLocation().getY(),
                event.getPlayerWarp().getWarpLocation().getZ(),
                event.getPlayerWarp().getWarpCategory().getName(),
                event.getPlayerWarp().getWarpCategory().getIcon(),
                event.getPlayerWarp().getWarpCategory().getTeleportPrice(),
                0,
                "");
    }

    public void ProcessEvent(PlayerWarpsEventType type, Double cost, long id, String warpName,
            String description, WIcon warpIcon, WPlayer wPlayer, String worldname, double locX,
            double locY, double locZ, String categoryname, ItemStack categoryitem, double teleportprice,
            double rating, String teleporter) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            AbstractEmbed embed = new PlayerWarpsEmbed(type, cost, id, warpName, description,
                    warpIcon, wPlayer, worldname, locX, locY, locZ,
                    categoryname, categoryitem, teleportprice, rating, teleporter);

            embed.sendEmbed();
        });

    }

}
