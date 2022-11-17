package me.zeromaniac.listener;

import de.jeff_media.angelchest.events.AngelChestSpawnEvent;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.embed.AngelChestEmbed;
import me.zeromaniac.listener.enums.*;
import me.zeromaniac.handlers.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public class AngelChestListener implements Listener {

    MoreDiscordSRVHooks plugin;
    boolean debug;

    Map<UUID, ItemStack> playerDeathAndItemOnMainCursor;

    public AngelChestListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        this.playerDeathAndItemOnMainCursor = new HashMap<>();

        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_ANGEL_CHEST_DEBUG.getPath());
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDeathEvent(PlayerDeathEvent e) {
        playerDeathAndItemOnMainCursor.put(e.getEntity().getUniqueId(), e.getEntity().getInventory().getItemInMainHand());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void chestSpawn(AngelChestSpawnEvent event) {
        Debug.log("Detected Angel Chest Event firing, Type: AngelChestSpawnEvent" , debug);
        Location lastDeathLocation = event.getAngelChest().getPlayer().getLastDeathLocation();

        if(lastDeathLocation == null) {
            lastDeathLocation = Bukkit.getWorlds().get(0).getBlockAt(0, 0, 0).getLocation();
        }

        ProcessEvent(AngelChestEventType.SPAWN,
                event.getAngelChest().getStorageInv(),
                event.getAngelChest().getBlock().getX(),
                event.getAngelChest().getBlock().getY(),
                event.getAngelChest().getBlock().getZ(),
                event.getAngelChest().getPlayer(),
                event.getAngelChest().getExperience(),
                event.getAngelChest().getWorld().getName(),
                event.getAngelChest().getUnlockIn(),
                event.getAngelChest().isProtected(),
                playerDeathAndItemOnMainCursor.get(event.getAngelChest().getPlayer().getUniqueId()),
                event.getAngelChest().getOffhandItem(),
                event.getAngelChest().getSecondsLeft(),
                lastDeathLocation.getBlockX(),
                lastDeathLocation.getBlockY(),
                lastDeathLocation.getBlockZ(),
                event.getAngelChest().getArmorInv(),
                lastDeathLocation.getWorld().getName());
    }

    /**
     * @param type = Enum of event type
     * @param angelChestContents = Array of Itemstack for main inventory contents
     * @param chestPositionX = int of location X of the container
     * @param chestPositionY = int of location Y of the container
     * @param chestPositionZ = int of location Z of the container
     * @param player = Player who died
     * @param experience = int of experience stored
     * @param world = world of container, modified
     * @param unlockIn = int of time until chest is accessible by other players, modified
     * @param isProtected = boolean of protection state
     * @param offHandItem = Itemstack offHandItem
     * @param timeLeft = String of modified time left until container explodes
     * @param deathPositionX = int of location X of the player death
     * @param deathPositionY = int of location Y of the player death
     * @param deathPositionZ = int of location Z of the player death
     * @param armor = Array of Itemstack, 4 slots
     * @param playerDeathWorld = world of death, modified
     */
    public void ProcessEvent(AngelChestEventType type, ItemStack[] angelChestContents, int chestPositionX,
            int chestPositionY, int chestPositionZ, OfflinePlayer player, int experience, String world,
            int unlockIn, boolean isProtected, ItemStack mainHandItem, ItemStack offHandItem, int timeLeft, int deathPositionX,
            int deathPositionY, int deathPositionZ, ItemStack[] armor, String playerDeathWorld) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            AbstractEmbed embed = new AngelChestEmbed(type, player,
                    pseudoInventory(angelChestContents, armor, offHandItem), chestPositionX,
                    chestPositionY, chestPositionZ, experience, worldRegexer(world), unlockHelper(unlockIn),
                    isProtected, mainHandItem, offHandItem,
                    parseTime(timeLeft, " minutes  ", " seconds"), itemCounter(angelChestContents, armor, offHandItem),
                    deathPositionX, deathPositionY, deathPositionZ, worldRegexer(playerDeathWorld));

            embed.sendEmbed();
        });
    }

    public String itemCounter(ItemStack[] angelChestContents, ItemStack[] armor, ItemStack offHandItem) {
        int i = 0;

        i += countItemsInStack(angelChestContents);
        i += countItemsInStack(armor);

        i += offHandItem != null ? offHandItem.getAmount() : 0;

        return String.valueOf(i);
    }

    private int countItemsInStack(ItemStack[] stack) {
        int j = 0;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] != null && stack[i].getType() != Material.AIR) {
                j += stack[i].getAmount();
            }
        }
        return j;
    }

    public Inventory pseudoInventory(ItemStack[] angelChestContents, ItemStack[] armor, ItemStack offHandItem) {
        angelChestContents = makeStackSafe(angelChestContents);
        armor = makeStackSafe(armor);

        if (offHandItem == null) {
            offHandItem = new ItemStack(Material.AIR);
        }

        Inventory pseudoInventory = Bukkit.getServer().createInventory(null, 54);
        pseudoInventory.setStorageContents(angelChestContents);
        pseudoInventory.setItem(40, offHandItem);
        pseudoInventory.setItem(36, armor[0]);
        pseudoInventory.setItem(37, armor[1]);
        pseudoInventory.setItem(38, armor[2]);
        pseudoInventory.setItem(39, armor[3]);
        pseudoInventory.setContents(makeStackSafe(pseudoInventory.getContents()));
        return pseudoInventory;
    }

    public ItemStack[] makeStackSafe(ItemStack[] stack) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == null) {
                stack[i] = new ItemStack(Material.AIR);
            }
        }
        return stack;
    }

    public String worldRegexer(String world) {
        Pattern worldNameNoUnderScores = Pattern.compile("_");
        return worldNameNoUnderScores.matcher(world).replaceAll(" ");
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

    public String unlockHelper(int unlockIn) {
        String never = "Never";
        if (unlockIn == 0 || unlockIn < 0) {
            return never;
        }
        return String.valueOf(unlockIn);
    }
}
