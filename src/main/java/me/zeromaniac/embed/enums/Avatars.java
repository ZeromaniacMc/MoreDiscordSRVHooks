package me.zeromaniac.embed.enums;

import java.util.Arrays;
import java.util.List;

public enum Avatars {
    PLAYER(Arrays.asList(new AvatarImages[] { AvatarImages.PLAYER_AVATAR_URL, AvatarImages.PLAYER_BODY_URL,
            AvatarImages.PLAYER_HEAD_3D_URL })),
    EXECUTROR(Arrays.asList(new AvatarImages[] { AvatarImages.EXECUTOR_AVATAR_URL, AvatarImages.EXECUTOR_BODY_URL,
            AvatarImages.EXECUTOR_HEAD_3D_URL })),
    RECEIVER(Arrays.asList(new AvatarImages[] { AvatarImages.RECEIVER_AVATAR_URL, AvatarImages.RECEIVER_BODY_URL,
            AvatarImages.RECEIVER_HEAD_3D_URL })),
    REVOKER(Arrays.asList(new AvatarImages[] { AvatarImages.REVOKER_AVATAR_URL, AvatarImages.REVOKER_BODY_URL,
            AvatarImages.REVOKER_HEAD_3D_URL })),
    BUYER(Arrays.asList(new AvatarImages[] { AvatarImages.BUYER_AVATAR_URL, AvatarImages.BUYER_BODY_URL,
            AvatarImages.BUYER_HEAD_3D_URL })),
    BIDDER(Arrays.asList(new AvatarImages[] { AvatarImages.BIDDER_AVATAR_URL, AvatarImages.BIDDER_BODY_URL,
            AvatarImages.BIDDER_HEAD_3D_URL }));

    private List<AvatarImages> avatars;

    Avatars(List<AvatarImages> avatars) {
        this.avatars = avatars;
    }

    public List<AvatarImages> getAvatarImages() {
        return avatars;
    }
}