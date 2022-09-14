package me.zeromaniac.listener.enums;

public enum QuickShopEventType {
    createShop("NewShopCreated"),
    purchaseSuccess("Purchase");

    final String value;

    private QuickShopEventType(String value) {
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