package me.zeromaniac.embed.enums;

public enum ImageNames {
    ITEM_IMAGE("item.png"),
    LORE_IMAGE("lore.png"),
    OFFHAND_ITEM_IMAGE("item2.png"),
    OFFHAND_LORE_IMAGE("lore2.png"),
    INVENTORY_IMAGE("inventory.png"),
    SIGN_IMAGE("sign.png"),
    CATEGORY_IMAGE("cat.png"),
    WARP_IMAGE("warp.png");

    final String value;

    private ImageNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}