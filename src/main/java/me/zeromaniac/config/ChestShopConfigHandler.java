package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.ChestShopDefaults;

public class ChestShopConfigHandler extends ConfigLoader {
    private boolean isNewShopEmbedEnabled;

    public ChestShopConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (ChestShopDefaults currentConfigKey : ChestShopDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
    }

    public boolean isNewShopEmbedEnabled() {
        return this.isNewShopEmbedEnabled;
    }
    
}
