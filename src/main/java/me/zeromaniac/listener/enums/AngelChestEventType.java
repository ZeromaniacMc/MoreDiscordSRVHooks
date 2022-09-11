package me.zeromaniac.listener.enums;

public enum AngelChestEventType {
        SPAWN("AngelChestSpawned");

        final String value;

        private AngelChestEventType(String value) {
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
