package me.zeromaniac.embed.enums;

public enum ImageNames {
    ITEM_IMAGE("item.png"),
    INVENTORY_IMAGE("inventory.png"),
    LORE_IMAGE("lore.png"),
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