package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.PlayerWarpsDefaults;

public class PlayerWarpsConfigHandler extends ConfigLoader {

    private boolean isNewWarpCreatedEmbedEnabled;
    private boolean isTeleportEmbedEnabled;
    private boolean isWarpRemodedEmbedEnabled;
    private boolean isShortenPricesEnabled;

    public PlayerWarpsConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (PlayerWarpsDefaults currentConfigKey : PlayerWarpsDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(
                SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString()); 
            }
        }
        this.isNewWarpCreatedEmbedEnabled = config.getBoolean(PlayerWarpsDefaults.NEW_WARP_CREATED_EMBED_ENABLED.getPath());
        this.isTeleportEmbedEnabled = config.getBoolean(PlayerWarpsDefaults.TELEPORT_EMBED_ENABLED.getPath());
        this.isWarpRemodedEmbedEnabled = config.getBoolean(PlayerWarpsDefaults.WARP_REMOVED_EMBED_ENABLED.getPath());
        this.isShortenPricesEnabled = config.getBoolean(PlayerWarpsDefaults.SHORTEN_PRICES.getPath());
    }




    public boolean isNewWarpCreatedEmbedEnabled() {
        return this.isNewWarpCreatedEmbedEnabled;
    }

    public boolean isTeleportEmbedEnabled() {
        return this.isTeleportEmbedEnabled;
    }

    public boolean isWarpRemodedEmbedEnabled() {
        return this.isWarpRemodedEmbedEnabled;
    }

    public boolean getIsShortenPricesEnabled() {
        return isShortenPricesEnabled;
    }
    
}
