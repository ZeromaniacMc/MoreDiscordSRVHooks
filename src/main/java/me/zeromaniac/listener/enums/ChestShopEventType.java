package me.zeromaniac.listener.enums;

public enum ChestShopEventType {
    CREATE("NewChestShop");

    final String value;

        private ChestShopEventType(String value) {
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
