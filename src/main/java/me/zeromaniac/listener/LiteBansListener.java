package me.zeromaniac.listener;

import litebans.api.Entry;
import litebans.api.Events;
import me.zeromaniac.MoreDiscordSRVHooks;
import me.zeromaniac.common.Debug;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.AbstractEmbed;
import me.zeromaniac.listener.enums.*;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.embed.LiteBansEmbed;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Listener;

import static me.zeromaniac.common.StringHelper.formatTime;
import static me.zeromaniac.common.StringHelper.boolToString;

public class LiteBansListener implements Listener {

    MoreDiscordSRVHooks plugin;

    long lastEntryEventTime = 0L;

    boolean debug;

    public LiteBansListener(MoreDiscordSRVHooks plugin) {
        this.plugin = plugin;

        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_LITEBANS_DEBUG.getPath());

        liteBansActions();
    }

    public void liteBansActions() {
        Events.get().register(new Events.Listener() {

            @Override
            public void entryAdded(Entry entry) {
                Debug.log("Detected LiteBans Event firing: entryAdded, Type: " + entry.getType(), debug);

                if (ConfigHandler.getMainConfig().getIgnoreSilentBans() && entry.isSilent()) {
                    return;
                }

                lastEntryEventTime = System.currentTimeMillis();

                OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(entry.getUuid()));
                LiteBansEventType type = LiteBansEventType.PERMANENT_BAN;

                // note: permanent ban
                if (entry.getType().equals("ban")) {
                    if (entry.isPermanent()) {
                        Debug.log("Ban event fired", debug);

                        if (entry.isIpban()) {
                            type = LiteBansEventType.PERMANENT_IP_BAN;
                        } else {
                            type = LiteBansEventType.PERMANENT_BAN;
                        }

                    } else {
                        // note: temp ban
                        Debug.log("Not permanent ban", debug);

                        if (entry.isIpban()) {
                            type = LiteBansEventType.TEMPORARY_IP_BAN;
                        } else {
                            type = LiteBansEventType.TEMPORARY_BAN;
                        }
                    }

                }

                // note: permanent mute
                if (entry.getType().equals("mute")) {
                    if (entry.isPermanent()) {
                        Debug.log("Mute event fired", debug);

                        if (entry.isIpban()) {
                            type = LiteBansEventType.PERMANENT_IP_MUTE;
                        } else {
                            type = LiteBansEventType.PERMANENT_MUTE;
                        }
                    } else {
                        // note: temp mute
                        Debug.log("Temp mute event fired", debug);

                        if (entry.isIpban()) {
                            type = LiteBansEventType.TEMPORARY_IP_MUTE;
                        } else {
                            type = LiteBansEventType.TEMPORARY_MUTE;
                        }
                    }

                }

                // note: kick
                if (entry.getType().equals("kick")) {
                    Debug.log("Kick event fired", debug);

                    type = LiteBansEventType.KICK;
                }

                // note: warn
                if (entry.getType().equals("warn")) {
                    Debug.log("Warn event fired", debug);

                    type = LiteBansEventType.WARN;
                }

                String playerName = player.getName() != null ? player.getName() : entry.getUuid();

                ProcessEvent(type,
                        entry.getId(), entry.getUuid(), playerName, entry.getIp(), entry.getReason(),
                        entry.getExecutorUUID(), entry.getExecutorName(), entry.getDateStart(), entry.getDateEnd(),
                        entry.getDurationString(), boolToString(entry.isSilent()), entry.getRemovedByUUID(),
                        entry.getRemovedByName(), entry.getRemovalReason(), entry.getServerOrigin(),
                        entry.getServerScope());

            }

            @Override
            public void entryRemoved(Entry entry) {
                final long currentTime = System.currentTimeMillis();
                Debug.log("Detected LiteBans Event firing: entryRemoved, Type: " + entry.getType(), debug);

                if (ConfigHandler.getMainConfig().getIgnoreSilentBans() && entry.isSilent()) {
                    return;
                }

                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    if (currentTime - lastEntryEventTime <= 10) {
                        return;
                    }

                    LiteBansEventType type = LiteBansEventType.UNBAN;
                    OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(entry.getUuid()));

                    if (entry.getType().equals("ban")) {
                        type = LiteBansEventType.UNBAN;
                    }

                    // note: unmute
                    if (entry.getType().equals("mute")) {
                        type = LiteBansEventType.UNMUTE;
                    }

                    // note: unwarn
                    if (entry.getType().equals("warn")) {
                        type = LiteBansEventType.UNWARN;
                    }

                    String playerName = player.getName() != null ? player.getName() : entry.getUuid();

                    ProcessEvent(type,
                            entry.getId(), entry.getUuid(), playerName, entry.getIp(), entry.getReason(),
                            entry.getExecutorUUID(), entry.getExecutorName(), entry.getDateStart(), entry.getDateEnd(),
                            entry.getDurationString(), boolToString(entry.isSilent()), entry.getRemovedByUUID(),
                            entry.getRemovedByName(), entry.getRemovalReason(), entry.getServerOrigin(),
                            entry.getServerScope());
                }, 1L);
            }
        });
    }

    public void ProcessEvent(LiteBansEventType type, long punishmentID, String receiverUUID, String receiverName,
            String receiverIP,
            String punishReason, String executorUUID, String executorName, long dateStart, long dateEnd,
            String duration,
            String silent,
            String revokerUUID, String revokerName, String revokeReason, String originServer, String effectScope) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            AbstractEmbed embed = new LiteBansEmbed(type, punishmentID, receiverUUID, receiverName, receiverIP,
                    punishReason, executorUUID, executorName, formatTime(dateStart, ""),
                    formatTime(dateEnd, duration), duration,
                    silent, revokerUUID, revokerName, revokeReason, originServer, effectScope);

            embed.sendEmbed();
        });
    }

}
