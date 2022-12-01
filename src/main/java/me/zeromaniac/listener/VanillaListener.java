package me.zeromaniac.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.VanillaEmbed;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.VanillaEventType;

public class VanillaListener implements Listener {

    private final MoreDiscordSRVHooks plugin;
    private boolean debug;

    public VanillaListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_VANILLA_DEBUG.getPath());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        Debug.log("Detected Vanilla Event firing, Type: " + event.getEventName(), debug);

        if (event.getPlayer().hasPlayedBefore()) {
            ProcessEvent(VanillaEventType.JOIN, 
            event.getPlayer(),
            event.getPlayer().getInventory().getItemInMainHand(), 
            event.getPlayer().getInventory().getItemInOffHand(),
            true);
        } else {
            ProcessEvent(VanillaEventType.FIRST_JOIN, 
            event.getPlayer(),
            event.getPlayer().getInventory().getItemInMainHand(), 
            event.getPlayer().getInventory().getItemInOffHand(),
            false);
        }

    }

    private void ProcessEvent(VanillaEventType type, Player player, ItemStack mainHandItem, ItemStack offHandItem, boolean hasPlayedBefore) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            AbstractEmbed embed = new VanillaEmbed(type, player, mainHandItem, offHandItem, hasPlayedBefore);
            embed.sendEmbed();
        });
    }

}
