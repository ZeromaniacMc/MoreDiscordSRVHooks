package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.ZAuctionHouseDefaults;

public class ZAuctionHouseConfigHandler extends ConfigLoader {

    private boolean isNewAuctionEmbedEnabled;

    private boolean isShortenPricesEnabled;

    public ZAuctionHouseConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (ZAuctionHouseDefaults currentConfigKey : ZAuctionHouseDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
        this.isNewAuctionEmbedEnabled = config.getBoolean(ZAuctionHouseDefaults.IS_NEW_AUCTION_EMBED_ENABLED.getPath());
        this.isShortenPricesEnabled = config.getBoolean(ZAuctionHouseDefaults.SHORTEN_PRICES.getPath());
    }

    public boolean getIsNewAuctionEmbedEnabled() {
        return this.isNewAuctionEmbedEnabled;
    }


    public boolean getIsShortenPricesEnabled() {
        return this.isShortenPricesEnabled;
    }
}
