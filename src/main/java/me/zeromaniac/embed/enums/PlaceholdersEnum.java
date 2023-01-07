package me.zeromaniac.embed.enums;

public enum PlaceholdersEnum {
    PLAYER("{player}"),
    SELLER("{seller}"),
    BIDDER("{bidder}"),
    BUYER("{buyer}"),
    VISITOR("{visitorName}"),

    QUANTITY("{quantity}"),
    ITEM("{item}"),
    STARTING_PRICE("{startingprice}"),

    BALANCE("{balance}"),
    TAX("{tax}"),
    INCOME_BEFORE_TAX("{incomeBeforeTax}"),
    INCOME_AFTER_TAX("{incomeAfterTax}"),
    SINGLETON_PRICE_BEFORE_TAX("{singleItemPriceBeforeTax}"),

    INCREMENT("{increment}"),
    AMOUNT("{amount}"),
    DURATION("{duration}"),
    ID("{id}"),
    PRICE("{price}"),
    TELEPORT_PRICE("{teleportprice}"),
    XP("{xp}"),
    TYPE_SELL_OR_BUY("{type}"),
    BOUGHT_OR_SOLD("{action}"),
    FROM_TO("{fromto}"),
    GAMEMODE("{gamemode}"),
    IS_OP("{isOp}"),
    KILLER("{killer}"),
    DEATHMSG("{deathMessage}"),
    KILLER_IS_PLAYER("{killerIsPlayer}"),
    ACHIEVEMENT("{achievementMessage}"),
    OLD_LEVEL("{oldLevel}"),
    NEW_LEVEL("{newLevel}"),



    COMMAND("{command}"),
    COMMAND_LENGTH("{commandLength}"),
    COMMAND_ARGS_AMOUNT("{argsAmount}"),


    CHEST_LOC_X("{chestLocationX}"),
    CHEST_LOC_Y("{chestLocationY}"),
    CHEST_LOC_Z("{chestLocationZ}"),
    DEATH_LOC_X("{deathLocationX}"),
    DEATH_LOC_Y("{deathLocationY}"),
    DEATH_LOC_Z("{deathLocationZ}"),
    CONTAINER_LOC_X("{containerLocationX}"),
    CONTAINER_LOC_Y("{containerLocationY}"),
    CONTAINER_LOC_Z("{containerLocationZ}"),
    LOC_X("{locationX}"),
    LOC_Y("{locationY}"),
    LOC_Z("{locationZ}"),

    UNLOCK_TIME("{unlockTime}"),
    IS_PROTECTED("{isProtected}"),
    CHEST_WORLD("{chestWorld}"),
    CONTAINER_WORLD("{containerWorld}"),
    PLAYER_WORLD("{playerWorld}"),
    WORLD_NAME("{worldname}"),
    WORLD_FROM("{worldFrom}"),
    WORLD_TO("{worldTo}"),
    RATING("{rating}"),

    EXPIRY("{expiry}"),
    ITEM_COUNT("{itemCount}"),
    WARP_NAME("{warpname}"),
    DESCRIPTION("{description}"),
    CATEGORY_NAME("{category}"),

    SIGN_LINE_1("{signLine1}"),
    SIGN_LINE_2("{signLine2}"),
    SIGN_LINE_3("{signLine3}"),
    SIGN_LINE_4("{signLine4}"),

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
    INVENTORY_IMAGE_URL("{inventoryImageUrl}"),
    CATEGORY_IMAGE_URL("{categoryImageUrl}"),
    WARP_IMAGE_URL("{warpImageUrl}");

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