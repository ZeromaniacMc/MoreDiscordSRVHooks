package me.zeromaniac.common;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import com.loohp.interactivechatdiscordsrvaddon.graphics.ImageGeneration;
import com.loohp.interactivechatdiscordsrvaddon.objectholders.ToolTipComponent;
import com.loohp.interactivechatdiscordsrvaddon.utils.DiscordItemStackUtils;

import me.zeromaniac.embed.enums.AvatarType;
import me.zeromaniac.types.Image;

import java.awt.image.BufferedImage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.loohp.interactivechat.objectholders.ICPlayer;
import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;

public class ImageHelper {

    public static byte[] getImageBytes(BufferedImage image) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "PNG", os);
            return os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[] {};
        }
    }

    public static Image getImage(String imageName, BufferedImage image) {
        return new Image(imageName, getImageBytes(image));
    }

    public static BufferedImage getLoreImage(ItemStack stack) {
        try {
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName(ItemHelper.convertHexToBukkit(meta.getDisplayName()));

            if (meta.getLore() != null) {
                List<String> lore = meta.getLore();
                for (int i = 0; i < lore.size(); i++) {
                    lore.set(i, ItemHelper.convertHexToBukkit(lore.get(i)));
                }
                meta.setLore(lore);
            }

            stack.setItemMeta(meta);
            List<ToolTipComponent<?>> itemNameComponent = DiscordItemStackUtils.getToolTip(stack, null).getComponents();
            return ImageGeneration.getToolTipImage(itemNameComponent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static BufferedImage getItemImage(ItemStack stack, OfflineICPlayer player) {
        try {
            return ImageGeneration.getItemStackImage(stack, player, 128);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage getPlayerInventory(Inventory inv, OfflinePlayer player) {
        return getPlayerInventory(inv, player, new ItemStack(Material.AIR), new ItemStack(Material.AIR));
    }

    public static BufferedImage getPlayerInventory(Inventory inv, OfflinePlayer player, ItemStack itemInMainHand, ItemStack itemInOffHand) {
        try {
            OfflineICPlayer icPlayer = ICPlayerFactory.getOfflineICPlayer(player.getUniqueId());

            if(icPlayer == null) {
                return null;
            }

            if(icPlayer.getPlayer() != null) {
                icPlayer = icPlayer.getPlayer();
                icPlayer.getInventory().setContents(inv.getContents());
                icPlayer.getEquipment().setItemInMainHand(itemInMainHand);
                icPlayer.getEquipment().setItemInOffHand(itemInOffHand);
            }


            return ImageGeneration.getPlayerInventoryImage(inv, icPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Based on DiscordSRV constructAvatarUrl
     */
    public static String constructAvatarUrl(String username, UUID uuid, AvatarType imageType) {
        try {
            boolean offline = uuid == null || uuid.version() == 3;
            OfflinePlayer player = null;

            if (!StringHelper.stringEmpty(username) && offline) {
                player = Bukkit.getOfflinePlayer(username);
                uuid = player.getUniqueId();
                offline = uuid.version() == 3;
            }
            if (StringHelper.stringEmpty(username) && uuid != null) {
                // resolve uuid to player/username
                player = Bukkit.getOfflinePlayer(uuid);
                username = player.getName();
            }

            String defaultUrl;
            String offlineUrl;

            if (imageType == AvatarType.HEAD) {
                defaultUrl = "https://crafatar.com/avatars/{uuid-nodashes}.png?overlay&size={size}";
                offlineUrl = "https://cravatar.eu/helmavatar/{username}/{size}.png";
                // offlineUrl = "https://mc-heads.net/{texture}";
            } else if (imageType == AvatarType.BODY) {
                defaultUrl = "https://crafatar.com/renders/body/{uuid-nodashes}.png?overlay&scale={scale}";
                offlineUrl = "https://cravatar.eu/helmhead/{username}/{size}.png";
            } else {
                defaultUrl = "https://crafatar.com/renders/head/{uuid-nodashes}.png?overlay&scale={scale}";
                offlineUrl = "https://cravatar.eu/helmhead/{username}/{size}.png";
            }

            String avatarUrl = !offline ? defaultUrl : offlineUrl;

            if (offline && !avatarUrl.contains("{username}")) {
                boolean defaultValue = avatarUrl.equals(defaultUrl);
                if (defaultValue) {
                    // Using default value while in offline mode -> use offline url
                    avatarUrl = offlineUrl;
                }
            }

            if (username != null && (username.startsWith("*") || username.startsWith("."))) {
                // geyser adds * or . to beginning of it's usernames
                username = username.substring(1);
            }

            try {
                username = URLEncoder.encode(username, "utf8");
            } catch (UnsupportedEncodingException ignored) {
            }

            avatarUrl = avatarUrl
                    .replace("{username}", username != null ? username : "")
                    .replace("{uuid}", uuid != null ? uuid.toString() : "")
                    .replace("{uuid-nodashes}", uuid.toString().replace("-", ""))
                    .replace("{size}", "82")
                    .replace("{scale}", "5");

            return avatarUrl;
        } catch (Throwable e) {

        }
        return null;
    }
}