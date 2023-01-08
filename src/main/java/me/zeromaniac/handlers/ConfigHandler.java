package me.zeromaniac.handlers;

import me.zeromaniac.config.*;

public class ConfigHandler {
    private static final String MAIN_CONFIG_NAME = "config.yml";
    private static MainConfigHandler MAIN_CONFIG;

    private static final String VANILLA_CONFIG_NAME = "vanilla.yml";
    private static VanillaConfigHandler VANILLA_CONFIG;

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

    private static final String QUICK_SHOP_CONFIG_NAME = "quickshop.yml";
    private static QuickShopConfigHandler QUICK_SHOP_CONFIG;
    public static String QUICK_SHOP_PLUGIN_NAME = "QuickShop";

    private static final String PLAYER_WARPS_CONFIG_NAME = "playerwarps.yml";
    private static PlayerWarpsConfigHandler PLAYER_WARPS_CONFIG;
    public static String PLAYER_WARPS_PLUGIN_NAME = "PlayerWarps";

    private static final String AUCTION_HOUSE_CONFIG_NAME = "auctionhouse.yml";
    private static AuctionHouseConfigHandler AUCTION_HOUSE_CONFIG;
    public static String AUCTION_HOUSE_PLUGIN_NAME = "AuctionHouse";

    private static final String ZAUCTION_HOUSE_CONFIG_NAME = "zauctionhouse.yml";
    private static ZAuctionHouseConfigHandler ZAUCTION_HOUSE_CONFIG;
    public static String ZAUCTION_HOUSE_PLUGIN_NAME = "zAuctionHouse";

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

        VANILLA_CONFIG = new VanillaConfigHandler(VANILLA_CONFIG_NAME);

        ANGEL_CHEST_CONFIG = new AngelChestConfigHandler(ANGEL_CHEST_CONFIG_NAME, 
                ANGEL_CHEST_PLUGIN_NAME );

        AUCTION_GUI_PLUS_CONFIG = new AuctionGUIPlusConfigHandler(AUCTION_GUI_PLUS_CONFIG_NAME,
                AUCTION_GUI_PLUS_PLUGIN_NAME);

        PLAYER_SHOP_GUI_PLUS_CONFIG = new PlayerShopGuiPlusConfigHandler(PLAYER_SHOP_GUI_PLUS_CONFIG_NAME,
                PLAYER_SHOP_GUI_PLUS_PLUGIN_NAME);

        LITEBANS_CONFIG = new LiteBansConfigHandler(LITEBANS_CONFIG_NAME, 
                LITE_BANS_PLUGIN_NAME);

        QUICK_SHOP_CONFIG = new QuickShopConfigHandler(QUICK_SHOP_CONFIG_NAME, 
                QUICK_SHOP_PLUGIN_NAME);

        PLAYER_WARPS_CONFIG = new PlayerWarpsConfigHandler(PLAYER_WARPS_CONFIG_NAME, 
                PLAYER_WARPS_PLUGIN_NAME);

        AUCTION_HOUSE_CONFIG = new AuctionHouseConfigHandler(AUCTION_HOUSE_CONFIG_NAME,
                AUCTION_HOUSE_PLUGIN_NAME);

        ZAUCTION_HOUSE_CONFIG = new ZAuctionHouseConfigHandler(ZAUCTION_HOUSE_CONFIG_NAME,
                ZAUCTION_HOUSE_PLUGIN_NAME);

        configsLoaded = true;
    }

    public static void reloadAllConfigs() {
        MAIN_CONFIG.reloadConfig();

        VANILLA_CONFIG.reloadConfig();

        ANGEL_CHEST_CONFIG.reloadConfig();

        AUCTION_GUI_PLUS_CONFIG.reloadConfig();

        PLAYER_SHOP_GUI_PLUS_CONFIG.reloadConfig();

        LITEBANS_CONFIG.reloadConfig();

        QUICK_SHOP_CONFIG.reloadConfig();

        PLAYER_WARPS_CONFIG.reloadConfig();

        AUCTION_HOUSE_CONFIG.reloadConfig();

        ZAUCTION_HOUSE_CONFIG.reloadConfig();
    }

    public static MainConfigHandler getMainConfig() {
        return MAIN_CONFIG;
    }

    public static VanillaConfigHandler getVanillaConfig() {
        return VANILLA_CONFIG;
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

    public static QuickShopConfigHandler getQuickShopConfig() {
        return QUICK_SHOP_CONFIG;
    }

    public static PlayerWarpsConfigHandler getPlayerWarpsConfig() {
        return PLAYER_WARPS_CONFIG;
    }

    public static AuctionHouseConfigHandler getAuctionHouseConfig() {
        return AUCTION_HOUSE_CONFIG;
    }

    public static ZAuctionHouseConfigHandler getZAuctionHouseConfig() {
        return ZAUCTION_HOUSE_CONFIG;
    }

}
