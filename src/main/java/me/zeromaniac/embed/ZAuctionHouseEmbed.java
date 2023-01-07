package me.zeromaniac.embed;

import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.common.ItemHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.ImageNames;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.AuctionEventType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

import static me.zeromaniac.common.ImageHelper.getImage;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.ImageHelper.getLoreImage;
import static me.zeromaniac.common.StringHelper.mapContainsValue;

public class ZAuctionHouseEmbed extends AbstractEmbed {

    OfflinePlayer seller;
    ItemStack stack;

    public ZAuctionHouseEmbed(Player player, OfflinePlayer seller, OfflinePlayer buyer, ItemStack stack, UUID id, String duration,
                              double price, AuctionEventType type) {
        super();
        boolean formatPrices = ConfigHandler.getAuctionGuiPlusConfig().getIsShortenPricesEnabled();

        String auctionType = type.getValue();
        messageType = auctionType;

        if (!isEnabled(auctionType)) {
            return;
        }

        this.stack = stack;

        this.seller = seller;
        this.player = player;

        replacer.put(PlaceholdersEnum.QUANTITY.getValue(), String.valueOf(stack.getAmount()));

        if (stack.getItemMeta().hasDisplayName()) {
            String newName = ItemHelper.convertHexToBukkit(stack.getItemMeta().getDisplayName());
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.bukkitColorYeeter(newName));

        } else {
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.nameFormatter(stack));
        }
        
        replacer.put(PlaceholdersEnum.DURATION.getValue(), duration);
        
        replacer.put(PlaceholdersEnum.PRICE.getValue(), (ItemHelper.priceShortener(price, formatPrices)));

        replacer.put(PlaceholdersEnum.ID.getValue(), String.valueOf(id));

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());
        replacer.put(PlaceholdersEnum.ITEM_IMAGE_URL.getValue(), attachmentType + ImageNames.ITEM_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.LORE_IMAGE_URL.getValue(), attachmentType + ImageNames.LORE_IMAGE.getValue());

        if (player != null) {
            for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(player.getName(), player.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.PLAYER.getValue(), player.getName());
        }

        if (seller != null) {
            for (AvatarImages avatar : Avatars.SELLER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(seller.getName(), seller.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.SELLER.getValue(), seller.getName());
        }
        if (buyer != null) {
            for (AvatarImages avatar : Avatars.BIDDER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(buyer.getName(), buyer.getUniqueId(), avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.BIDDER.getValue(), buyer.getName());
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
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(seller.getUniqueId());
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
        config = ConfigHandler.getAuctionGuiPlusConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_ZAUCTION_HOUSE_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled")
                && ConfigHandler.getMainConfig().getIsZAuctionHouseEnabled();

        return enabled;
    }
}
