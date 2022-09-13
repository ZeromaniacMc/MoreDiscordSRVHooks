package me.zeromaniac.Adapters;

import java.util.UUID;

import org.bukkit.inventory.EntityEquipment;

import com.loohp.interactivechat.objectholders.OfflineICPlayer;

public class OfflineICPlayerAdapter extends OfflineICPlayer {

    private OfflineICPlayer player;

    public OfflineICPlayerAdapter(OfflineICPlayer player) {
        super(player.getUniqueId());
        this.player = player;
    }

    public void setEquipment(EntityEquipment remoteEquipment) {
        this.remoteEquipment = remoteEquipment;
    }
}
