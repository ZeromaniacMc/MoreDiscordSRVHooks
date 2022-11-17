package me.zeromaniac.embed;

import org.bukkit.inventory.ItemStack;
import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import com.olziedev.playerwarps.api.player.WPlayer;
import com.olziedev.playerwarps.api.warp.WIcon;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.common.ItemHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.PlayerWarpsEventType;
import me.zeromaniac.embed.enums.ImageNames;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.ImageHelper.getImage;

public class PlayerWarpsEmbed extends AbstractEmbed {

    public PlayerWarpsEmbed(PlayerWarpsEventType type, Double cost, long id, String warpName,
            String description, WIcon warpIcon, WPlayer wPlayer, String worldname, double locX,
            double locY, double locZ, String categoryname, ItemStack categoryitem, double teleportprice,
            double rating, String teleporter) {
        super();

        boolean formatPrices = ConfigHandler.getPlayerWarpsConfig().getIsShortenPricesEnabled();

        String messageType = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }

        replacer.put(PlaceholdersEnum.PLAYER.getValue(), wPlayer.getName());
        replacer.put(PlaceholdersEnum.WARP_NAME.getValue(), warpName);
        replacer.put(PlaceholdersEnum.CATEGORY_NAME.getValue(), categoryname);
        replacer.put(PlaceholdersEnum.DESCRIPTION.getValue(), ItemHelper.bukkitColorYeeter(description));
        replacer.put(PlaceholdersEnum.TELEPORTER.getValue(), teleporter);

        if (cost != null) {
            replacer.put(PlaceholdersEnum.PRICE.getValue(), ItemHelper.priceShortener(cost, formatPrices));
        } else {
            replacer.put(PlaceholdersEnum.PRICE.getValue(), "0");
        }

        replacer.put(PlaceholdersEnum.ID.getValue(), String.valueOf(id));
        replacer.put(PlaceholdersEnum.WORLD_NAME.getValue(), worldname);
        replacer.put(PlaceholdersEnum.LOC_X.getValue(), String.valueOf(Math.round(locX)));
        replacer.put(PlaceholdersEnum.LOC_Y.getValue(), String.valueOf(Math.round(locY)));
        replacer.put(PlaceholdersEnum.LOC_Z.getValue(), String.valueOf(Math.round(locZ)));
        replacer.put(PlaceholdersEnum.PRICE.getValue(),
                String.valueOf(ItemHelper.priceShortener(teleportprice, formatPrices)));

        // {rating}
        replacer.put(PlaceholdersEnum.RATING.getValue(), String.valueOf(rating));

        // {playerAvatarUrl}, {playerHead3dUrl}, {playerBodyUrl}
        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(wPlayer.getName(),
                            wPlayer.getUUID(), avatar.getType()));
        }

        // {botAvatarUrl}
        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        setConfigValues(messageType);

        // bug: visitor images for body, head, and 3d heads!

        // {categoryImageUrl}
        // todo: Improve image setting becasuse this is confusing
        replacer.put(PlaceholdersEnum.CATEGORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.CATEGORY_IMAGE.getValue());

        // {warpImageUrl}
        replacer.put(PlaceholdersEnum.WARP_IMAGE_URL.getValue(), attachmentType + ImageNames.WARP_IMAGE.getValue());

        if (mapContainsValue(textFieldsMap, ImageNames.CATEGORY_IMAGE.getValue()) && warpIcon != null) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(wPlayer.getPlayer().getUniqueId());
                attachmentImages
                        .add(getImage(ImageNames.CATEGORY_IMAGE.getValue(),
                                getItemImage(warpIcon.getWarpIcon(), imagePlayer)));
            } catch (Throwable e) {
                // empty
            }
        }
        if (mapContainsValue(textFieldsMap, ImageNames.WARP_IMAGE.getValue()) && categoryitem != null) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(wPlayer.getPlayer().getUniqueId());
                attachmentImages
                        .add(getImage(ImageNames.WARP_IMAGE.getValue(), getItemImage(categoryitem, imagePlayer)));
            } catch (Throwable e) {
                // empty
            }
        }

        // no lore images for warps

        // no inv img for warps

        // no offhand item for warps

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
