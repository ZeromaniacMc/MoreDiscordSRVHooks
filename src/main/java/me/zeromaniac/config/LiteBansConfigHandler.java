package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.LiteBansDefaults;

public class LiteBansConfigHandler extends ConfigLoader{

    private boolean isLiteBansEmbedEnabled;

    public LiteBansConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (LiteBansDefaults currentConfigKey : LiteBansDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
    }

    public boolean isLiteBansEmbedEnabled() {
        return this.isLiteBansEmbedEnabled;
    }
}
