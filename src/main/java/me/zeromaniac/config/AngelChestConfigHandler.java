package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.AngelChestDefaults;

public class AngelChestConfigHandler extends ConfigLoader {
    private boolean isAngelChestEmbedEnabled;

    public AngelChestConfigHandler(String configName, String pluginName) {
        super(configName, pluginName);
    }

    @Override
    public void loadMyConfig() {
        for (AngelChestDefaults currentConfigKey : AngelChestDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }
    }

    public boolean isAngelChestEmbedEnabled() {
        return this.isAngelChestEmbedEnabled;
    }
}
