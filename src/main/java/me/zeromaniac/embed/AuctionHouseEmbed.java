package me.zeromaniac.embed;

import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.ImageNames;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.AuctionEventType;

import static me.zeromaniac.common.ImageHelper.*;
import static me.zeromaniac.common.StringHelper.mapContainsValue;

public class AuctionHouseEmbed extends AbstractEmbed {

    public AuctionHouseEmbed(AuctionEventType type, .....) {
        super();
        messageType = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }

        // LOOHP HERE
        // You will find a shit load of pre made placeholders in the PlaceholdersEnum enum.
        // Use the replacer to assign values.
        // Once you are done with this, please review the config and make sure all placeholders are assigned.
        // If the data you fetch require a new placeholder, feel free to create a new one.














        // Avatar and bot images are easy copy paste jobs ;) Hint: Delete useless comments like these lol

        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(player.getName(),
                            player.getUniqueId(), avatar.getType()));
        }

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        // LOOHP HERE
        // Since auctions have a buyer, fix this to get the buyer avatars.
        if (buyer != null) {
            for (AvatarImages avatar : Avatars.BUYER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(buyer.getName(), buyer.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.BUYER.getValue(), buyer.getName());
        }

        this.afterConstructor();
    }

    // LOOHP HERE
    // This is where we handle images. Make sure you have what is needed here.
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
