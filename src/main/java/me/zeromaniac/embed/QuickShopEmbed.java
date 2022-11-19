package me.zeromaniac.embed;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
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
import me.zeromaniac.listener.enums.QuickShopEventType;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.ImageHelper.getLoreImage;
import static me.zeromaniac.common.ImageHelper.getImage;

public class QuickShopEmbed extends AbstractEmbed {

    public QuickShopEmbed(QuickShopEventType type, UUID owner, ItemStack item,
            double locationX, double locationY, double locationZ, int shoptype, double singleItemPriceBeforeTax,
            int amount, double incomeAfterTax, double tax, double incomeBeforeTax, UUID buyer, String world) {
        super();
        boolean formatPrices = ConfigHandler.getQuickShopConfig().getIsShortenPricesEnabled();
        messageType = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }

        this.player = Bukkit.getPlayer(owner);

        if (item.getItemMeta().hasDisplayName()) {
            String newName = ItemHelper.convertHexToBukkit(item.getItemMeta().getDisplayName());
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.bukkitColorYeeter(newName));
        } else {
            replacer.put(PlaceholdersEnum.ITEM.getValue(), ItemHelper.nameFormatter(item));
        }

        replacer.put(PlaceholdersEnum.AMOUNT.getValue(), String.valueOf(amount));
        replacer.put(PlaceholdersEnum.TAX.getValue(), String.valueOf(tax));
        replacer.put(PlaceholdersEnum.INCOME_AFTER_TAX.getValue(),
                ItemHelper.priceShortener(incomeAfterTax, formatPrices));
        replacer.put(PlaceholdersEnum.INCOME_BEFORE_TAX.getValue(),
                ItemHelper.priceShortener(incomeBeforeTax, formatPrices));
        replacer.put(PlaceholdersEnum.SINGLETON_PRICE_BEFORE_TAX.getValue(),
                ItemHelper.priceShortener(singleItemPriceBeforeTax, formatPrices));

        replacer.put(PlaceholdersEnum.CHEST_WORLD.getValue(), String.valueOf(world));
        replacer.put(PlaceholdersEnum.CHEST_LOC_X.getValue(), String.valueOf(locationX));
        replacer.put(PlaceholdersEnum.CHEST_LOC_Y.getValue(), String.valueOf(locationY));
        replacer.put(PlaceholdersEnum.CHEST_LOC_Z.getValue(), String.valueOf(locationZ));

        replacer.put(PlaceholdersEnum.PLAYER.getValue(), Bukkit.getOfflinePlayer(owner).getName());

        // SELLING(0)
        // BUYING(1)
        final String isSellShop = "Selling";
        final String isBuyShop = "Buying";
        if (shoptype == 0) {
            replacer.put(PlaceholdersEnum.TYPE_SELL_OR_BUY.getValue(), isSellShop);
        } else {
            replacer.put(PlaceholdersEnum.TYPE_SELL_OR_BUY.getValue(), isBuyShop);
        }

        final String actionEqualsSelling = "sold";
        final String actionEqualsBuying = "bought";
        if (shoptype == 1) {
            replacer.put(PlaceholdersEnum.BOUGHT_OR_SOLD.getValue(), actionEqualsSelling);
        } else {
            replacer.put(PlaceholdersEnum.BOUGHT_OR_SOLD.getValue(), actionEqualsBuying);
        }

        final String soldTo = "to";
        final String boughtFrom = "from";
        if (shoptype == 1) {
            replacer.put(PlaceholdersEnum.FROM_TO.getValue(), soldTo);
        } else {
            replacer.put(PlaceholdersEnum.FROM_TO.getValue(), boughtFrom);
        }

        replacer.put(PlaceholdersEnum.ITEM_IMAGE_URL.getValue(), attachmentType + ImageNames.ITEM_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.LORE_IMAGE_URL.getValue(), attachmentType + ImageNames.LORE_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.INVENTORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.INVENTORY_IMAGE.getValue());
        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(Bukkit.getOfflinePlayer(owner).getName(), owner, avatar.getType()));
        }

        if (buyer != null) {
            for (AvatarImages avatar : Avatars.BUYER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(Bukkit.getOfflinePlayer(buyer).getName(), buyer,
                                avatar.getType()));
            }
            replacer.put(PlaceholdersEnum.BUYER.getValue(), Bukkit.getOfflinePlayer(buyer).getName());
        }

        setConfigValues(messageType);

        if (mapContainsValue(textFieldsMap, ImageNames.ITEM_IMAGE.getValue())) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(owner);
                attachmentImages.add(getImage(ImageNames.ITEM_IMAGE.getValue(), getItemImage(item, imagePlayer)));
            } catch (Throwable e) {
                // empty
            }
        }

        if (mapContainsValue(textFieldsMap, ImageNames.LORE_IMAGE.getValue())) {
            attachmentImages.add(getImage(ImageNames.LORE_IMAGE.getValue(), getLoreImage(item)));
        }

    }

    @Override
    protected void initConfig() {
        config = ConfigHandler.getQuickShopConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_QUICK_SHOP_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled")
                && ConfigHandler.getMainConfig().getIsQuickShopEnabled();

        return enabled;
    }
}
