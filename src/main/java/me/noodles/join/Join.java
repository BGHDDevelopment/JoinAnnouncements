package me.noodles.join;

import me.noodles.join.commands.JoinCommand;
import me.noodles.join.listeners.JoinEvent;
import me.noodles.join.listeners.UpdateJoinEvent;
import me.noodles.join.utilities.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Join extends JavaPlugin {

    public void onEnable() {
        final String version = this.getDescription().getVersion();

        this.getLogger().info(String.format("JoinAnnouncements v%s starting ...", version));

        this.saveDefaultConfig();
        this.reloadConfig();

        this.getLogger().info(String.format("JoinAnnouncements v%s loading commands ...", version));

        this.registerCommand("join", new JoinCommand(this));

        this.getLogger().info(String.format("JoinAnnouncements v%s loading events ...", version));

        this.registerEvents(this, new UpdateJoinEvent(this), new JoinEvent(this));

        this.getLogger().info(String.format("JoinAnnouncements v%s started ...", version));

        if (getConfig().getBoolean("CheckForUpdates.Enabled", true)) {
            new UpdateChecker(this, 46673).getLatestVersion(remoteVersion -> {
                getLogger().info("Checking for Updates ...");

                if (getDescription().getVersion().equalsIgnoreCase(remoteVersion)) {
                    getLogger().info("No new version available");
                } else {
                    getLogger().warning(String.format("Newest version: %s is out! You are running version: %s", remoteVersion, getDescription().getVersion()));
                    getLogger().warning("Please Update Here: http://www.spigotmc.org/resources/46673");
                }
            });
        }
    }

    private void registerEvents(final Plugin plugin, final Listener... listeners) {
        for (final Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    private void registerCommand(final String command, final CommandExecutor executor) {
        this.getCommand(command).setExecutor(executor);
    }

}
