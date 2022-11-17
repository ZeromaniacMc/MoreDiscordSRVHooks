package me.zeromaniac.common;

import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import com.loohp.interactivechatdiscordsrvaddon.graphics.ImageGeneration;
import com.loohp.interactivechatdiscordsrvaddon.objectholders.ToolTipComponent;
import com.loohp.interactivechatdiscordsrvaddon.utils.DiscordItemStackUtils;
import me.zeromaniac.embed.enums.AvatarType;
import me.zeromaniac.types.Image;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.profile.PlayerProfile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

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
            stack = stack.clone();
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
        OfflineICPlayer icPlayer = ICPlayerFactory.getOfflineICPlayer(player.getUniqueId());
        if (icPlayer == null) {
            return null;
        }
        boolean rightHanded = icPlayer.isRightHanded();
        ItemStack rightHand = rightHanded ? itemInMainHand : itemInOffHand;
        ItemStack leftHand = rightHanded ? itemInOffHand : itemInMainHand;
        ItemStack helmet = inv.getItem(39);
        ItemStack chestplate = inv.getItem(38);
        ItemStack leggings = inv.getItem(37);
        ItemStack boots = inv.getItem(36);
        try {
            return ImageGeneration.getPlayerInventoryImage(inv, rightHand, leftHand, helmet, chestplate, leggings, boots, icPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Constructs an avatar url with mc-heads
     */
    public static String constructAvatarUrl(String username, UUID uuid, AvatarType imageType) {
        OfflinePlayer offlinePlayer = uuid == null ? Bukkit.getOfflinePlayer(username) : Bukkit.getOfflinePlayer(uuid);
        PlayerProfile playerProfile = offlinePlayer.getPlayerProfile();
        if (!playerProfile.isComplete()) {
            try {
                playerProfile = offlinePlayer.getPlayerProfile().update().get();
            } catch (InterruptedException | ExecutionException ignore) {
            }
        }
        URL skinUrl = playerProfile.getTextures().getSkin();
        String skinValue = skinUrl == null ? username.replaceAll("^\\*", "") : skinUrl.toString().replace("http://textures.minecraft.net/texture/", "");
        String avatarUrl;
        switch (imageType) {
            case HEAD -> avatarUrl = "https://mc-heads.net/avatar/" + skinValue + "/82";
            case HEAD_3D -> avatarUrl = "https://mc-heads.net/head/" + skinValue + "/82";
            default -> avatarUrl = "https://mc-heads.net/body/" + skinValue + "/82";
        }
        return avatarUrl;
    }
}