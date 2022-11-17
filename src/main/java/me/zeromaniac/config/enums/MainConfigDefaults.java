package me.zeromaniac.config.enums;

public enum MainConfigDefaults implements EnumGeneral {
    VERSION("Version", "2.0.0"),

    IS_ANGEL_CHEST_ENABLED("Hooks.AngelChest.Enabled", true),
    IS_ANGEL_CHEST_DEBUG("Hooks.AngelChest.Debug", true),

    IS_PLAYER_SHOP_GUI_PLUS_ENABLED("Hooks.PlayerShopGUIPlus.Enabled", true),
    IS_PLAYER_SHOP_GUI_PLUS_DEBUG("Hooks.PlayerShopGUIPlus.Debug", true),

    IS_AUCTION_GUI_PLUS_DEBUG("Hooks.AuctionGUIPlus.Debug", true),
    IS_AUCTION_GUI_PLUS_ENABLED("Hooks.AuctionGUIPlus.Enabled", true),

    IS_LITEBANS_ENABLED("Hooks.LiteBans.Enabled", true),
    IS_LITEBANS_DEBUG("Hooks.LiteBans.Debug", false),
    IS_LITEBANS_IGNORE_SILENT("Hooks.LiteBans.IgnoreSilent", false),

    IS_QUICK_SHOP_ENABLED("Hooks.QuickShop.Enabled", true),
    IS_QUICK_SHOP_DEBUG("Hooks.QuickShop.Debug", false),

    IS_PLAYER_WARPS_ENABLED("Hooks.PlayerWarps.Enabled", true),
    IS_PLAYER_WARPS_DEBUG("Hooks.PlayerWarps.Debug", false),

    TIME_ZONE("Timezone", "Europe/Berlin");

    public String path;
    public Object value;

    MainConfigDefaults(String path, Object value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public Object getValue() {
        return value;
    }
}