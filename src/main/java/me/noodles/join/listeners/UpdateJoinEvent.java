package me.noodles.join.listeners;

import me.noodles.join.Join;
import me.noodles.join.utilities.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class UpdateJoinEvent implements Listener {
    private final Join plugin;

    public UpdateJoinEvent(Join plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if (getPlugin().getConfig().getBoolean("Update.Enabled", true)) {
            if (player.hasPermission("join.update")) {
                if (getPlugin().getConfig().getBoolean("CheckForUpdates.Enabled", true)) {
                    new UpdateChecker(getPlugin(), 46673).getLatestVersion(version -> {
                        if (!getPlugin().getDescription().getVersion().equalsIgnoreCase(version)) {
                            player.sendMessage(ChatColor.GRAY + "=========================");
                            player.sendMessage(ChatColor.RED + "JoinAnnouncements is outdated!");
                            player.sendMessage(ChatColor.GREEN + "Newest version: " + version);
                            player.sendMessage(ChatColor.RED + "Your version: " + getPlugin().getDescription().getVersion());
                            player.sendMessage(ChatColor.GRAY + "=========================");
                        }
                    });
                }
            }
        }
    }

    private Join getPlugin() {
        return plugin;
    }

}
    