package me.zeromaniac.embed.enums;

public enum AvatarImages {
    PLAYER_AVATAR_URL("{playerAvatarUrl}", AvatarType.HEAD),
    EXECUTOR_AVATAR_URL("{executorAvatarUrl}", AvatarType.HEAD),
    RECEIVER_AVATAR_URL("{receiverAvatarUrl}", AvatarType.HEAD),
    REVOKER_AVATAR_URL("{revokerAvatarUrl}", AvatarType.HEAD),
    BUYER_AVATAR_URL("{buyerAvatarUrl}", AvatarType.HEAD),
    BIDDER_AVATAR_URL("{bidderAvatarUrl}", AvatarType.HEAD),

    PLAYER_HEAD_3D_URL("{playerHead3dUrl}", AvatarType.HEAD_3D),
    EXECUTOR_HEAD_3D_URL("{executorHead3dUrl}", AvatarType.HEAD_3D),
    RECEIVER_HEAD_3D_URL("{receiverHead3dUrl}", AvatarType.HEAD_3D),
    REVOKER_HEAD_3D_URL("{revokerHead3dUrl}", AvatarType.HEAD_3D),
    BUYER_HEAD_3D_URL("{buyerHead3dUrl}", AvatarType.HEAD_3D),
    BIDDER_HEAD_3D_URL("{bidderHead3dUrl}", AvatarType.HEAD_3D),

    PLAYER_BODY_URL("{playerBodyUrl}", AvatarType.BODY),
    EXECUTOR_BODY_URL("{executorBodyUrl}", AvatarType.BODY),
    RECEIVER_BODY_URL("{receiverBodyUrl}", AvatarType.BODY),
    REVOKER_BODY_URL("{revokerBodyUrl}", AvatarType.BODY),
    BUYER_BODY_URL("{buyerBodyUrl}", AvatarType.BODY),
    BIDDER_BODY_URL("{bidderBodyUrl}", AvatarType.BODY);

    final String value;
    final AvatarType type;

    private AvatarImages(String value, AvatarType type) {
        this.value = value;
        this.type = type;
    }

    public AvatarType getType() {
        return this.type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}