package me.noodles.join;

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
	        registerEvents((Plugin)this, new UpdateJoinEvent());
	        registerEvents((Plugin)this, new Events());
	        registerEvents(this, this);
	        this.getLogger().info("JoinAnnouncements  V" + VarUtilType.getVersion() + " started!");
	        this.setEnabled(true);
	        this.getLogger().info("JoinAnnouncements V" + VarUtilType.getVersion() + " checking for updates...");
	        this.checker = new UpdateChecker(this);
	        if (this.checker.isConnected()) {
	            if (this.checker.hasUpdate()) {
	                getServer().getConsoleSender().sendMessage("------------------------");
	                getServer().getConsoleSender().sendMessage("JoinAnnouncements is outdated!");
	                getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
	                getServer().getConsoleSender().sendMessage("Your version: " + Join.plugin.getDescription().getVersion());
	                getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/46673");
	                getServer().getConsoleSender().sendMessage("------------------------");
	            }
	            else {
	                getServer().getConsoleSender().sendMessage("------------------------");
	                getServer().getConsoleSender().sendMessage("JoinAnnouncements  is up to date!");
	                getServer().getConsoleSender().sendMessage("------------------------");            }
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

