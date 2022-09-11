package me.zeromaniac.listener;

import org.bukkit.Bukkit;
import org.bukkit.block.Container;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import com.Acrobot.ChestShop.Events.ShopCreatedEvent;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.ChestShopEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.ChestShopEventType;
import me.zeromaniac.common.Debug;

public class ChestShopListener implements Listener{
    
    MoreDiscordSRVHooks plugin;
    boolean debug;

    public ChestShopListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_CHEST_SHOP_DEBUG_ENABLED.getPath());

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void shopCreate(ShopCreatedEvent event) {
        Debug.log("Detected Chest Shop Event firing, Type: ShopCreatedEvent" , debug);
        ProcessEvent(ChestShopEventType.CREATE,
        event.getPlayer(),
        event.getSign(),
        event.getSignLine((short) 0),
        event.getSignLine((short) 1),
        event.getSignLine((short) 2),
        event.getSignLine((short) 3),
        event.getContainer(),
        event.getContainer().getX(),
        event.getContainer().getY(),
        event.getContainer().getZ());
    }

    public void ProcessEvent(ChestShopEventType type, Player owner, Sign sign, String signLine1,
            String signLine2, String signLine3, String signLine4, Container container, int containerPositionX,
            int containerPositionY, int containerPositionZ) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            AbstractEmbed embed = new ChestShopEmbed(type, owner, sign, signLine1, signLine2, signLine3, signLine4,
                container, containerPositionX, containerPositionY, containerPositionZ);

            embed.sendEmbed();
        });
    }
}
