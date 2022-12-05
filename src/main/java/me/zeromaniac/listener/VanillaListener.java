package me.zeromaniac.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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
                    true,
                    event.getPlayer().getGameMode(),
                    event.getPlayer().isOp(),
                    null,
                    "",
                    false,
                    null,
                    0,
                    0);
        } else {
            ProcessEvent(VanillaEventType.FIRST_JOIN,
                    event.getPlayer(),
                    event.getPlayer().getInventory().getItemInMainHand(),
                    event.getPlayer().getInventory().getItemInOffHand(),
                    false,
                    event.getPlayer().getGameMode(),
                    event.getPlayer().isOp(),
                    null,
                    "",
                    false,
                    null,
                    0,
                    0);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeave(PlayerQuitEvent event) {
        Debug.log("Detected Vanilla Event firing, Type: " + event.getEventName(), debug);
        ProcessEvent(VanillaEventType.LEAVE,
                event.getPlayer(),
                event.getPlayer().getInventory().getItemInMainHand(),
                event.getPlayer().getInventory().getItemInOffHand(),
                true,
                event.getPlayer().getGameMode(),
                event.getPlayer().isOp(),
                null,
                "",
                false,
                null,
                0,
                0);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(PlayerDeathEvent event) {
        Debug.log("Detected Vanilla Event firing, Type: " + event.getEventName(), debug);

        if (event.getEntity() instanceof Player) {
            
            String deathCauseString = event.getDeathMessage();
            // damage by entity
            Player player = (Player) event.getEntity();
            EntityDamageEvent deathCause = player.getLastDamageCause();

            if (deathCause.getCause() == DamageCause.ENTITY_ATTACK) {
                Entity entity = deathCause.getEntity();
                if (entity instanceof Player) {
                    Player killerPlayer = (Player) entity;
                    // player was killed by killerPlayer, do whatever
                    ProcessEvent(VanillaEventType.DEATH, 
                    player, 
                    player.getInventory().getItemInMainHand(), 
                    player.getInventory().getItemInOffHand(), 
                    true, 
                    player.getGameMode(), 
                    player.isOp(), 
                    killerPlayer,
                    deathCauseString,
                    true,
                    null,
                    0,
                    0);
                }
                else {
                    if (entity instanceof Monster == false) {
                        return;
                    }

                    Monster monster = (Monster) entity;
                    ProcessEvent(VanillaEventType.DEATH, 
                    player, 
                    player.getInventory().getItemInMainHand(), 
                    player.getInventory().getItemInOffHand(), 
                    true, 
                    player.getGameMode(), 
                    player.isOp(), 
                    monster,
                    deathCauseString,
                    false,
                    null,
                    0,
                    0);
                    // player was killed by killerMob, do whatever
                }
            } else {
                // environmental
                ProcessEvent(VanillaEventType.DEATH, 
                    player, 
                    player.getInventory().getItemInMainHand(), 
                    player.getInventory().getItemInOffHand(), 
                    true, 
                    player.getGameMode(), 
                    player.isOp(), 
                    null,
                    deathCauseString,
                    false,
                    null,
                    0,
                    0);
            }
        } else {
            // damaged thing is not player
        }
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {

        Debug.log("Detected Vanilla Event firing, Type: " + event.getEventName(), debug);
        ProcessEvent(VanillaEventType.COMMAND, 
        event.getPlayer(), 
        event.getPlayer().getInventory().getItemInMainHand(), 
        event.getPlayer().getInventory().getItemInOffHand(),
        true,
        event.getPlayer().getGameMode(), 
        event.getPlayer().isOp(), 
        null, 
        "",
        false,
        event.getMessage(),
        0,
        0);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLevelChange(PlayerLevelChangeEvent event) {
        Debug.log("Detected Vanilla Event firing, Type: " + event.getEventName(), debug);
        ProcessEvent(VanillaEventType.LEVELUP, 
        event.getPlayer(), 
        event.getPlayer().getInventory().getItemInMainHand(), 
        event.getPlayer().getInventory().getItemInOffHand(), 
        true, 
        event.getPlayer().getGameMode(), 
        event.getPlayer().isOp(), 
        null, 
        "", 
        false,
        null,
        event.getOldLevel(),
        event.getNewLevel());
    }

    private void ProcessEvent(VanillaEventType type, Player player, ItemStack mainHandItem, ItemStack offHandItem,
            boolean hasPlayedBefore, GameMode gameMode,
            boolean isOp, Entity killer, String deathMessage, boolean killerIsPlayer, String command, int oldLevel, int newLevel) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            AbstractEmbed embed = new VanillaEmbed(type, player, mainHandItem, offHandItem, hasPlayedBefore, gameMode,
                    isOp, killer, deathMessage, killerIsPlayer, command, oldLevel, newLevel);
            embed.sendEmbed();
        });
    }

}
