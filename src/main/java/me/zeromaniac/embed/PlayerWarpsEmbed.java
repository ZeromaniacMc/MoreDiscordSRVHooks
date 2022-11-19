package me.zeromaniac.embed;

import static me.zeromaniac.common.ImageHelper.getImage;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import com.olziedev.playerwarps.api.player.WPlayer;
import com.olziedev.playerwarps.api.warp.WIcon;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.common.ItemHelper;
import me.zeromaniac.common.StringHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.ImageNames;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.PlayerWarpsEventType;

public class PlayerWarpsEmbed extends AbstractEmbed {
    WPlayer wPlayer;
    ItemStack categoryitem;
    ItemStack itemStackWarpIcon;

    public PlayerWarpsEmbed(PlayerWarpsEventType type, Double cost, long id, String warpName,
            String description, WIcon warpIcon, WPlayer wPlayer, String worldname, double locX,
            double locY, double locZ, String categoryname, ItemStack categoryitem, Double teleportprice,
            double rating, Player visitor) {
        super();

        boolean formatPrices = ConfigHandler.getPlayerWarpsConfig().getIsShortenPricesEnabled();

        messageType = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }
        this.player = wPlayer.getPlayer();
        this.wPlayer = wPlayer;
        this.categoryitem =categoryitem;

        replacer.put(PlaceholdersEnum.PLAYER.getValue(), wPlayer.getName());
        replacer.put(PlaceholdersEnum.WARP_NAME.getValue(), warpName);
        replacer.put(PlaceholdersEnum.CATEGORY_NAME.getValue(), StringHelper.nameFormatter(categoryname));
        replacer.put(PlaceholdersEnum.DESCRIPTION.getValue(), ItemHelper.bukkitColorYeeter(description));

        if (visitor != null) {
            replacer.put(PlaceholdersEnum.VISITOR.getValue(), visitor.getName());
        } else {
            replacer.put(PlaceholdersEnum.VISITOR.getValue(), "");
        }

        if (cost == null || cost < 0) {
            replacer.put(PlaceholdersEnum.PRICE.getValue(), "0.0");
        } else {
            replacer.put(PlaceholdersEnum.PRICE.getValue(), ItemHelper.priceShortener(cost, formatPrices));
        }

        replacer.put(PlaceholdersEnum.ID.getValue(), String.valueOf(id));
        replacer.put(PlaceholdersEnum.WORLD_NAME.getValue(), StringHelper.nameFormatter(worldname));
        replacer.put(PlaceholdersEnum.LOC_X.getValue(), String.valueOf(Math.round(locX)));
        replacer.put(PlaceholdersEnum.LOC_Y.getValue(), String.valueOf(Math.round(locY)));
        replacer.put(PlaceholdersEnum.LOC_Z.getValue(), String.valueOf(Math.round(locZ)));

        if (teleportprice == null || teleportprice < 0) {
            replacer.put(PlaceholdersEnum.TELEPORT_PRICE.getValue(), "0.0");
        } else {
            replacer.put(PlaceholdersEnum.TELEPORT_PRICE.getValue(),
                    String.valueOf(ItemHelper.priceShortener(teleportprice, formatPrices)));
        }

        // {rating}
        replacer.put(PlaceholdersEnum.RATING.getValue(), String.valueOf(rating));

        // {playerAvatarUrl}, {playerHead3dUrl}, {playerBodyUrl}
        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(wPlayer.getName(),
                            wPlayer.getUUID(), avatar.getType()));
        }

        // {visitorAvatarUrl}, {visitorHead3dUrl}, {visitorBodyUrl}
        if (visitor != null) {
            for (AvatarImages avatar : Avatars.VISITOR.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(visitor.getName(),
                                visitor.getUniqueId(), avatar.getType()));
            }
        }

        // {botAvatarUrl}
        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());


        boolean isIconSet = false;
        try {
            itemStackWarpIcon = warpIcon.getWarpIcon();
            isIconSet = true;
        } catch (Exception e) {
            // false
        }

        // {warpImageUrl}
        if (isIconSet) {
            replacer.put(PlaceholdersEnum.WARP_IMAGE_URL.getValue(), attachmentType + ImageNames.WARP_IMAGE.getValue());
        } else {
            if (Avatars.PLAYER.getAvatarImages().size() > 1) {
                replacer.put(PlaceholdersEnum.WARP_IMAGE_URL.getValue(),
                        ImageHelper.constructAvatarUrl(wPlayer.getName(),
                                wPlayer.getUUID(), Avatars.PLAYER.getAvatarImages().get(2).getType()));
            }
        }

        // {categoryImageUrl}
        replacer.put(PlaceholdersEnum.CATEGORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.CATEGORY_IMAGE.getValue());

        this.afterConstructor();
    }
    
    @Override
    protected void handleImages() {
        // {warpImageUrl}
        if (mapContainsValue(textFieldsMap, ImageNames.WARP_IMAGE.getValue()) && itemStackWarpIcon != null) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(wPlayer.getPlayer().getUniqueId());
                attachmentImages.add(
                        getImage(ImageNames.WARP_IMAGE.getValue(), getItemImage(itemStackWarpIcon, imagePlayer)));
            } catch (Throwable e) {
                e.printStackTrace();
                // empty
            }
        }

        // {categoryImageUrl}
        if (mapContainsValue(textFieldsMap, ImageNames.CATEGORY_IMAGE.getValue()) && categoryitem != null) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(wPlayer.getPlayer().getUniqueId());
                attachmentImages
                        .add(getImage(ImageNames.CATEGORY_IMAGE.getValue(), getItemImage(categoryitem, imagePlayer)));
            } catch (Throwable e) {
                e.printStackTrace();
                // empty
            }
        }
    }

    @Override
    protected void initConfig() {
        config = ConfigHandler.getPlayerWarpsConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_PLAYER_WARPS_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled") && ConfigHandler.getMainConfig().getIsPlayerWarpsEnabled();

        return enabled;
    }

}
