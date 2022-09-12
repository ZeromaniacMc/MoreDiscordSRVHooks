package me.zeromaniac.listener;

import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
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
        event.getSignLine((short) 0),
        event.getSignLine((short) 1),
        event.getSignLine((short) 2),
        event.getSignLine((short) 3),
        event.getContainer().getWorld().getName(),
        event.getContainer(),
        event.getContainer().getX(),
        event.getContainer().getY(),
        event.getContainer().getZ());
    }

    public void ProcessEvent(ChestShopEventType type, OfflinePlayer player,
        String signLine1,String signLine2, String signLine3, String signLine4, String world,
        Container container, int containerPositionX,int containerPositionY, int containerPositionZ) {


        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            AbstractEmbed embed = new ChestShopEmbed(type, player,
                signLine1, signLine2, signLine3, signLine4, worldRegexer(world), container, 
                containerPositionX, containerPositionY, containerPositionZ);

            embed.sendEmbed();
        });
    }

    public String worldRegexer(String world) {
        Pattern worldNameNoUnderScores = Pattern.compile("_");
        return worldNameNoUnderScores.matcher(world).replaceAll(" ");
    }
}
