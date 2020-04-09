package me.noodles.join;

import org.bukkit.event.player.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class UpdateJoinEvent implements Listener
{
	
	public UpdateChecker checker;
	
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
    	Player p = e.getPlayer();
    	if (p.hasPermission("join.update")) {
    		if (Join.getPlugin().getConfig().getBoolean("Update.Enabled") == true){
    		this.checker = new UpdateChecker(Join.plugin);
                        if (this.checker.isConnected()) {
                            if (this.checker.hasUpdate()) {
                            	p.sendMessage(ChatColor.GRAY + "=========================");
                                p.sendMessage(ChatColor.RED + "JoinAnnouncements is outdated!");
                                p.sendMessage(ChatColor.GREEN + "Newest version: " + this.checker.getLatestVersion());
                                p.sendMessage(ChatColor.RED + "Your version: " + Join.plugin.getDescription().getVersion());
                                p.sendMessage(ChatColor.GRAY + "=========================");
                            }
                        }               
       }
    }
}
}
    