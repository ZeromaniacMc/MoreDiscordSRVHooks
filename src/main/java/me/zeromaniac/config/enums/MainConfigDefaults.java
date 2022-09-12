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

    IS_CHEST_SHOP_ENABLED("Hooks.ChestShop.Enabled", true),
    IS_CHEST_SHOP_DEBUG_ENABLED("Hooks.ChestShop.Debug", false),

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