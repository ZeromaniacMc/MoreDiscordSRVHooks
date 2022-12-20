package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.QuickShopDefaults;

public class QuickShopConfigHandler extends ConfigLoader {

    private boolean isNewShopCreatedEmbedEnabled;
    private boolean isPurchaseEmbedEnabled;
    private boolean isShortenPricesEnabled;
    private String typeBuyingString;
    private String typeSellingString;
    private String actionBoughtString;
    private String actionSoldString;
    private String directionToString;
    private String directionFromString;


    public QuickShopConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (QuickShopDefaults currentConfigKey : QuickShopDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(
                SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
        this.isNewShopCreatedEmbedEnabled = config.getBoolean(QuickShopDefaults.IS_NEW_SHOP_CREATED_EMBED_ENABLED.getPath());
        this.isNewShopCreatedEmbedEnabled = config.getBoolean(QuickShopDefaults.IS_PURCHASE_EMBED_ENABLED.getPath());
        this.isShortenPricesEnabled = config.getBoolean(QuickShopDefaults.SHORTEN_PRICES.getPath());
        this.typeBuyingString = config.getString(QuickShopDefaults.TYPE_BUYING.getPath());
        this.typeSellingString = config.getString(QuickShopDefaults.TYPE_SELLING.getPath());
        this.actionBoughtString = config.getString(QuickShopDefaults.ACTION_BOUGHT.getPath());
        this.actionSoldString = config.getString(QuickShopDefaults.ACTION_SOLD.getPath());
        this.directionToString = config.getString(QuickShopDefaults.DIRECTION_TO.getPath());
        this.directionFromString = config.getString(QuickShopDefaults.DIRECTION_FROM.getPath());
    }

    public boolean getIsNewShopCreatedEmbedEnabled() {
        return this.isNewShopCreatedEmbedEnabled;
    }

    public boolean getIsPurchaseEmbedEnabled() {
        return this.isPurchaseEmbedEnabled;
    }

    public boolean getIsShortenPricesEnabled() {
        return isShortenPricesEnabled;
    }

    public String getTypeBuyingString() {
        return typeBuyingString;
    }

    public String getTypeSellingString() {
        return typeSellingString;
    }

    public String getActionBoughtString() {
        return actionBoughtString;
    }

    public String getActionSoldString() {
        return actionSoldString;
    }

    public String getDirectionToString() {
        return directionToString;
    }

    public String getDirectionFromString() {
        return directionFromString;
    }

}
