package me.noodles.join;

import me.noodles.join.listeners.UpdateJoinEvent;
import me.noodles.join.utilities.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Join extends JavaPlugin implements Listener {

	 public static Join plugin;
	    private UpdateChecker checker;
	    
	    public void onEnable() {
	        Join.plugin = this;
	        final PluginDescriptionFile VarUtilType = this.getDescription();
	        this.getLogger().info("JoinAnnouncements  V" + VarUtilType.getVersion() + " starting...");
	        this.saveDefaultConfig();
	        this.reloadConfig();
	        registerEvents((Plugin)this, new UpdateJoinEvent(this));
	        registerEvents((Plugin)this, new Events());
	        registerEvents(this, this);
	        this.getLogger().info("JoinAnnouncements  V" + VarUtilType.getVersion() + " started!");
	        this.setEnabled(true);
	        this.getLogger().info("JoinAnnouncements V" + VarUtilType.getVersion() + " checking for updates...");
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
	    
	    public static void registerEvents(final Plugin plugin, final Listener... listeners) {
	        for (final Listener listener : listeners) {
	            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	        }
	    }
	    
	    @SuppressWarnings({ "unchecked", "rawtypes"})
		public static Join getPlugin() {
	        return (Join)getPlugin((Class) Join.class);
	    }
	    
	    public static Plugin getPlugin2() {
	        return (Plugin) Join.plugin;
	    }
	}

