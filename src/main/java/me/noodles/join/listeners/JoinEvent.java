package me.noodles.join.listeners;

import me.noodles.join.Join;
import me.noodles.join.utilities.Common;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
	private final Join plugin;

	public JoinEvent(Join plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(final PlayerJoinEvent event) {
		final Player player = event.getPlayer();

		Common.tell(player, getPlugin().getConfig().getStringList("Messages"));
	}

	private Join getPlugin() {
		return plugin;
	}

}
