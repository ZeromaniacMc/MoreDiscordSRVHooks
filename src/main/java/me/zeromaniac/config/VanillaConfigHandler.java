package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.VanillaDefaults;

public class VanillaConfigHandler extends ConfigLoader{

    private boolean isPlayerJoinEmbedEnabled;

    public VanillaConfigHandler(String configName) {
        super(configName);
    }

    @Override
    public void loadMyConfig() {
        for (VanillaDefaults currentConfigKey : VanillaDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
        this.isPlayerJoinEmbedEnabled = config.getBoolean(VanillaDefaults.IS_PLAYER_JOIN_EMBED_ENABLED.getPath());
    }

    public boolean isPlayerJoinEmbedEnabled() {
        return this.isPlayerJoinEmbedEnabled;
    }
}
