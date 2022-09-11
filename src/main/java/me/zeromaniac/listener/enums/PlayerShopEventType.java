package me.zeromaniac.listener.enums;


public enum PlayerShopEventType {
        START("NewSale"),
        END_EXPIRED("SaleEndExpired"),
        END_SOLD("SaleEndBought");

        final String value;

        private PlayerShopEventType(String value) {
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
