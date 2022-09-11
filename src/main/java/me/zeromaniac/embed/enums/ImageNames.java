package me.zeromaniac.embed.enums;

public enum ImageNames {
    ITEM_IMAGE("item.png"),
    INVENTORY_IMAGE("inventory.png"),
    LORE_IMAGE("lore.png");

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