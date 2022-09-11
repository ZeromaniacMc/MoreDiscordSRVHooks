package me.zeromaniac.embed.enums;

public enum PlaceholdersEnum {
    PLAYER("{player}"),
    BIDDER("{bidder}"),
    BUYER("{buyer}"),
    
    QUANTITY("{quantity}"),
    ITEM("{item}"),
    STARTING_PRICE("{startingprice}"),
    INCREMENT("{increment}"),
    AMOUNT("{amount}"),
    DURATION("{duration}"),
    ID("{id}"),
    PRICE("{price}"),
    XP("{xp}"),

    CHEST_LOC_X("{chestLocationX}"),
    CHEST_LOC_Y("{chestLocationY}"),
    CHEST_LOC_Z("{chestLocationZ}"),
    DEATH_LOC_X("{deathLocationX}"),
    DEATH_LOC_Y("{deathLocationY}"),
    DEATH_LOC_Z("{deathLocationZ}"),
    
    UNLOCK_TIME("{unlockTime}"),
    IS_PROTECTED("{isProtected}"),
    CHEST_WORLD("{chestWorld}"),
    PLAYER_WORLD("{playerWorld}"),
    EXPIRY("{expiry}"),
    ITEM_COUNT("{itemCount}"),
    
    RECEIVER_IP("{receiverIP}"),
    RECEIVER_UUID("{receiverUUID}"),
    RECEIVER_NAME("{receiverName}"),
    EXECUTOR_UUID("{executorUUID}"),
    EXECUTOR_NAME("{executorName}"),
    REVOKER_UUID("{revokerUUID}"),
    REVOKER_NAME("{revokerName}"),
    REVOKE_REASON("{revokeReason}"),
    DATE_START("{dateStart}"),
    DATE_END("{dateEnd}"),
    SILENT("{silent}"),
    ORIGIN_SERVER("{originServer}"),
    EFFECT_SCOPE("{effectScope}"),
    PUNISH_REASON("{punishReason}"),

    OFFHAND_ITEM_URL("{offHandItemUrl}"),
    OFFHAND_ITEM_LORE_URL("{offHandItemLoreImageUrl}"),
    BOT_AVATAR_URL("{botAvatarUrl}"),
    ITEM_IMAGE_URL("{itemImageUrl}"),
    LORE_IMAGE_URL("{loreImageUrl}"),
    INVENTORY_IMAGE_URL("{inventoryImageUrl}");

    final String value;

    private PlaceholdersEnum(String value) {
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