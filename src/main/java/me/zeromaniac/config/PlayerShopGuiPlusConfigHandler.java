package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.PlayerShopGUIPlusDefaults;

public class PlayerShopGuiPlusConfigHandler extends ConfigLoader {

    private boolean isNewSaleEmbedEnabled;

    private boolean isShortenPricesEnabled;

    public PlayerShopGuiPlusConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (PlayerShopGUIPlusDefaults currentConfigKey : PlayerShopGUIPlusDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(
                SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
        this.isNewSaleEmbedEnabled = config.getBoolean(PlayerShopGUIPlusDefaults.IS_NEW_SALE_EMBED_ENABLED.getPath());
        this.isShortenPricesEnabled = config.getBoolean(PlayerShopGUIPlusDefaults.SHORTEN_PRICES.getPath());
    }

    public boolean getIsNewAuctionEmbedEnabled() {
        return this.isNewSaleEmbedEnabled;
    }

    public boolean getIsShortenPricesEnabled() {
        return isShortenPricesEnabled;
    }
}
