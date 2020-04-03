package me.noodles.join;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

	String Line0;
	String Line1;
	String Line2;
	String Line3;
	String Line4;
	String Line5;
	String Line6;
	String Line7;
	String Line8;

	
	
	 public Events() {
	        this.Line0 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line0"));
	        this.Line1 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line1"));
	        this.Line2 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line2"));
	        this.Line3 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line3"));
	        this.Line4 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line4"));
	        this.Line5 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line5"));
	        this.Line6 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line6"));
	        this.Line7 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line7"));
	        this.Line8 = ChatColor.translateAlternateColorCodes('&', Join.getPlugin().getConfig().getString("Messages.Line8"));

	 } 
	
	  @EventHandler
	    public void PlayerJoin(PlayerJoinEvent e) {
	    Player p = e.getPlayer();
	    p.sendMessage(String.valueOf(this.Line0));
	    p.sendMessage(String.valueOf(this.Line1));
	    p.sendMessage(String.valueOf(this.Line2));
	    p.sendMessage(String.valueOf(this.Line3));
	    p.sendMessage(String.valueOf(this.Line4));
	    p.sendMessage(String.valueOf(this.Line5));
	    p.sendMessage(String.valueOf(this.Line6));
	    p.sendMessage(String.valueOf(this.Line7));
	    p.sendMessage(String.valueOf(this.Line8));
	  }
	
}
