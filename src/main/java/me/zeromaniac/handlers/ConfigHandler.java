package me.zeromaniac.handlers;

import org.checkerframework.checker.units.qual.s;

import me.zeromaniac.config.*;

public class ConfigHandler {
    private static final String MAIN_CONFIG_NAME = "config.yml";
    private static MainConfigHandler MAIN_CONFIG;

    private static final String AUCTION_GUI_PLUS_CONFIG_NAME = "auctionguiplus.yml";
    private static AuctionGUIPlusConfigHandler AUCTION_GUI_PLUS_CONFIG;
    public static String AUCTION_GUI_PLUS_PLUGIN_NAME = "AuctionGUIPlus";

    private static final String PLAYER_SHOP_GUI_PLUS_CONFIG_NAME = "playershoguiplus.yml";
    private static PlayerShopGuiPlusConfigHandler PLAYER_SHOP_GUI_PLUS_CONFIG;
    public static String PLAYER_SHOP_GUI_PLUS_PLUGIN_NAME = "PlayerShopGUIPlus";

    private static final String ANGEL_CHEST_CONFIG_NAME = "angelchest.yml";
    private static AngelChestConfigHandler ANGEL_CHEST_CONFIG;
    public static String ANGEL_CHEST_PLUGIN_NAME = "AngelChest";

    private static final String LITEBANS_CONFIG_NAME = "litebans.yml";
    private static LiteBansConfigHandler LITEBANS_CONFIG;
    public static String LITE_BANS_PLUGIN_NAME = "LiteBans";

    private static boolean configsLoaded = false;

    static {
        loadConfigs();
    }

    public ConfigHandler() {
        // Empty
    }

    public static void loadConfigs() {
        if (configsLoaded) {
            return;
        }
        MAIN_CONFIG = new MainConfigHandler(MAIN_CONFIG_NAME);

        ANGEL_CHEST_CONFIG = new AngelChestConfigHandler(ANGEL_CHEST_CONFIG_NAME, ANGEL_CHEST_PLUGIN_NAME);

        AUCTION_GUI_PLUS_CONFIG = new AuctionGUIPlusConfigHandler(AUCTION_GUI_PLUS_CONFIG_NAME,
                AUCTION_GUI_PLUS_PLUGIN_NAME);

        PLAYER_SHOP_GUI_PLUS_CONFIG = new PlayerShopGuiPlusConfigHandler(PLAYER_SHOP_GUI_PLUS_CONFIG_NAME,
                PLAYER_SHOP_GUI_PLUS_PLUGIN_NAME);

        LITEBANS_CONFIG = new LiteBansConfigHandler(LITEBANS_CONFIG_NAME, LITE_BANS_PLUGIN_NAME);

        configsLoaded = true;
    }

    public static void reloadAllConfigs() {
        MAIN_CONFIG.reloadConfig();

        ANGEL_CHEST_CONFIG.reloadConfig();

        AUCTION_GUI_PLUS_CONFIG.reloadConfig();

        PLAYER_SHOP_GUI_PLUS_CONFIG.reloadConfig();

        LITEBANS_CONFIG.reloadConfig();
    }

    public static MainConfigHandler getMainConfig() {
        return MAIN_CONFIG;
    }

    public static AngelChestConfigHandler getAngelChestConfig() {
        return ANGEL_CHEST_CONFIG;
    }

    public static AuctionGUIPlusConfigHandler getAuctionGuiPlusConfig() {
        return AUCTION_GUI_PLUS_CONFIG;
    }

    public static PlayerShopGuiPlusConfigHandler getPlayerShopGuiPlusConfig() {
        return PLAYER_SHOP_GUI_PLUS_CONFIG;
    }

    public static LiteBansConfigHandler getLitebansConfig() {
        return LITEBANS_CONFIG;
    }

}
