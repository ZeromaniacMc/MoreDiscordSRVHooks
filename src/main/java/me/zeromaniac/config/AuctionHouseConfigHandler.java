package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.AuctionHouseDefaults;

public class AuctionHouseConfigHandler  extends ConfigLoader {

    private boolean isShortenPricesEnabled;

    public AuctionHouseConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (AuctionHouseDefaults currentConfigKey : AuctionHouseDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
        this.isShortenPricesEnabled = config.getBoolean(AuctionHouseDefaults.SHORTEN_PRICES.getPath());
    }

    public boolean getIsShortenPricesEnabled() {
        return isShortenPricesEnabled;
    }
}
