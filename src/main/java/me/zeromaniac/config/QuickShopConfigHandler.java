package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.QuickShopDefaults;

public class QuickShopConfigHandler extends ConfigLoader {

    private boolean isNewShopCreatedEmbedEnabled;

    private boolean isShortenPricesEnabled;


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
        this.isShortenPricesEnabled = config.getBoolean(QuickShopDefaults.SHORTEN_PRICES.getPath());
    }

    public boolean getIsNewShopCreatedEmbedEnabled() {
        return this.isNewShopCreatedEmbedEnabled;
    }

    public boolean getIsShortenPricesEnabled() {
        return isShortenPricesEnabled;
    }

}
