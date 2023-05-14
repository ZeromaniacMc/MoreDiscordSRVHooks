package me.zeromaniac.config;

import me.zeromaniac.common.SystemHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;

public class MainConfigHandler extends ConfigLoader {

    private String version;
    private boolean isAngleChestEnabled;
    private boolean isAuctionGUIPlusEnabled;
    private boolean isPlayerShopGUIPlusEnabled;
    private boolean isLitebansEnabled;
    private boolean isIgnoreSilentBans;
    private boolean isQuickShopEnabled;
    private boolean isPlayerWarpsEnabled;
    private boolean isVanillaEnabled;
    private boolean isAuctionHouseEnabled;
    private String timezone;

    public MainConfigHandler(String configName) {
        super(configName);
    }

    @Override
    public void loadMyConfig() {
        for (MainConfigDefaults currentConfigKey : MainConfigDefaults.values()) {
            if (!configContainsKey(currentConfigKey.getPath())) {
                SystemHelper.consoleMessage(
                SystemHelper.ERROR + currentConfigKey.getPath() + SystemHelper.IN_CONFIG + configName);
                config.addDefault(currentConfigKey.getPath(), currentConfigKey.getValue());
                SystemHelper.consoleMessage(SystemHelper.USING_DEFAULT + currentConfigKey.getValue().toString());
            }
        }

        this.version = config.getString(MainConfigDefaults.VERSION.getPath());
        this.isAngleChestEnabled = config.getBoolean(MainConfigDefaults.IS_ANGEL_CHEST_ENABLED.getPath());
        this.isAuctionGUIPlusEnabled = config.getBoolean(MainConfigDefaults.IS_AUCTION_GUI_PLUS_ENABLED.getPath());
        this.isPlayerShopGUIPlusEnabled = config.getBoolean(MainConfigDefaults.IS_PLAYER_SHOP_GUI_PLUS_ENABLED.getPath());
        this.isLitebansEnabled = config.getBoolean(MainConfigDefaults.IS_LITEBANS_ENABLED.getPath());
        this.isQuickShopEnabled = config.getBoolean(MainConfigDefaults.IS_QUICK_SHOP_ENABLED.getPath());
        this.timezone = config.getString(MainConfigDefaults.TIME_ZONE.getPath());
        this.isIgnoreSilentBans = config.getBoolean(MainConfigDefaults.IS_LITEBANS_IGNORE_SILENT.getPath());
        this.isPlayerWarpsEnabled = config.getBoolean(MainConfigDefaults.IS_PLAYER_WARPS_ENABLED.getPath());
        this.isVanillaEnabled = config.getBoolean(MainConfigDefaults.IS_VANILLA_ENABLED.getPath());
        this.isAuctionHouseEnabled = config.getBoolean(MainConfigDefaults.IS_AUCTION_HOUSE_ENABLED.getPath());
    }

    public String getVersion() {
        return this.version;
    }

    public boolean getIsAngleChestEnabled() {
        return this.isAngleChestEnabled;
    }

    public boolean getIsAuctionGUIPlusEnabled() {
        return this.isAuctionGUIPlusEnabled;
    }

    public boolean getIsPlayerShopGUIPlusEnabled() {
        return this.isPlayerShopGUIPlusEnabled;
    }

    public boolean getIsLitebansEnabled() {
        return this.isLitebansEnabled;
    }

    public boolean getIgnoreSilentBans() {
        return this.isIgnoreSilentBans;
    }

    public boolean getIsQuickShopEnabled() {
        return this.isQuickShopEnabled;
    }

    public boolean getIsPlayerWarpsEnabled() {
        return this.isPlayerWarpsEnabled;
    }

    public boolean getIsVanillaEnabled() {
        return this.isVanillaEnabled;
    }

    public boolean getIsAuctionHouseEnabled() {
        return this.isAuctionHouseEnabled;
    }

    public String getTimezone() {
        return this.timezone;
    }
}
