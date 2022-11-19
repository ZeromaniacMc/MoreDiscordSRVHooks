package me.zeromaniac.embed;

import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.common.ItemHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.ImageNames;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.listener.enums.*;
import me.zeromaniac.handlers.ConfigHandler;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.ImageHelper.getLoreImage;
import static me.zeromaniac.common.ImageHelper.getImage;

public class PlayerShopGuiPlusEmbed extends AbstractEmbed {

    public PlayerShopGuiPlusEmbed(OfflinePlayer player, OfflinePlayer buyer, ItemStack stack, double price,
            int quantity, PlayerShopEventType type, String duration) {
        super();
        boolean formatPrices = ConfigHandler.getPlayerShopGuiPlusConfig().getIsShortenPricesEnabled();

        String auctionType = type.getValue();
        messageType = auctionType;

        if (!isEnabled(auctionType)) {
            return;
        }

        this.player = (Player) player;

        replacer.put(PlaceholdersEnum.DURATION.getValue(), duration);
        replacer.put(PlaceholdersEnum.PLAYER.getValue(), player.getName());
        replacer.put(PlaceholdersEnum.QUANTITY.getValue(), String.valueOf(quantity));

        if (stack.getItemMeta().hasDisplayName()) {
            String newName = ItemHelper.convertHexToBukkit(stack.getItemMeta().getDisplayName());
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.bukkitColorYeeter(newName));

        } else {
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.nameFormatter(stack));
        }

        replacer.put(PlaceholdersEnum.PRICE.getValue(), ItemHelper.priceShortener(price, formatPrices));

        replacer.put(PlaceholdersEnum.ITEM_IMAGE_URL.getValue(), attachmentType + ImageNames.ITEM_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.LORE_IMAGE_URL.getValue(), attachmentType + ImageNames.LORE_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.INVENTORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.INVENTORY_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(player.getName(), player.getUniqueId(), avatar.getType()));
        }

        if (buyer != null) {
            for (AvatarImages avatar : Avatars.BUYER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(buyer.getName(), buyer.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.BUYER.getValue(), buyer.getName());
        }

        setConfigValues(auctionType);

        if (mapContainsValue(textFieldsMap, ImageNames.ITEM_IMAGE.getValue())) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(player.getUniqueId());
                attachmentImages.add(getImage(ImageNames.ITEM_IMAGE.getValue(), getItemImage(stack, imagePlayer)));
            } catch (Throwable e) {
                // empty
            }
        }

        if (mapContainsValue(textFieldsMap, ImageNames.LORE_IMAGE.getValue())) {
            attachmentImages.add(getImage(ImageNames.LORE_IMAGE.getValue(), getLoreImage(stack)));
        }
    }

    @Override
    protected void initConfig() {
        config = ConfigHandler.getPlayerShopGuiPlusConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_PLAYER_SHOP_GUI_PLUS_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled")
                && ConfigHandler.getMainConfig().getIsPlayerShopGUIPlusEnabled();

        return enabled;
    }
}
