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

public class AuctionHouseEmbed extends AbstractEmbed {
    ItemStack stack;

    public AuctionHouseEmbed(OfflinePlayer player, OfflinePlayer bidder, OfflinePlayer buyer, ItemStack stack,
                               double price, double amount, AuctionEventType type) {
        super();
        boolean formatPrices = ConfigHandler.getAuctionGuiPlusConfig().getIsShortenPricesEnabled();

        String auctionType = type.getValue();
        messageType = auctionType;

        if (!isEnabled(auctionType)) {
            return;
        }

        this.stack = stack;

        this.player = (Player) player;

        replacer.put(PlaceholdersEnum.PLAYER.getValue(), player.getName());
        replacer.put(PlaceholdersEnum.QUANTITY.getValue(), String.valueOf(stack.getAmount()));

        if (stack.getItemMeta().hasDisplayName()) {
            String newName = ItemHelper.convertHexToBukkit(stack.getItemMeta().getDisplayName());
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.bukkitColorYeeter(newName));

        } else {
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.nameFormatter(stack));
        }

        replacer.put(PlaceholdersEnum.AMOUNT.getValue(), String.valueOf(amount));

        replacer.put(PlaceholdersEnum.PRICE.getValue(), (ItemHelper.priceShortener(price, formatPrices)));

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());
        replacer.put(PlaceholdersEnum.ITEM_IMAGE_URL.getValue(), attachmentType + ImageNames.ITEM_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.LORE_IMAGE_URL.getValue(), attachmentType + ImageNames.LORE_IMAGE.getValue());

        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(player.getName(), player.getUniqueId(), avatar.getType()));
        }

        if (bidder != null) {
            for (AvatarImages avatar : Avatars.BIDDER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(bidder.getName(), bidder.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.BIDDER.getValue(), bidder.getName());
        }
        if (buyer != null) {
            for (AvatarImages avatar : Avatars.BUYER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(buyer.getName(), buyer.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.BUYER.getValue(), buyer.getName());
        }

        this.afterConstructor();
    }


    @Override
    protected void handleImages() {

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
        config = ConfigHandler.getAuctionHouseConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_AUCTION_HOUSE_ENABLED.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled")
                && ConfigHandler.getMainConfig().getIsAuctionHouseEnabled();

        return enabled;
    }
}
