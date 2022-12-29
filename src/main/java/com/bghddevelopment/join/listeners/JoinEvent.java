package com.bghddevelopment.join.listeners;

import com.bghddevelopment.join.JoinAnnouncements;
import com.bghddevelopment.join.utilities.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	@EventHandler
	public void onJoin(final PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		Color.tell(player, JoinAnnouncements.getInstance().getConfig().getStringList("Messages"));
	}
}
