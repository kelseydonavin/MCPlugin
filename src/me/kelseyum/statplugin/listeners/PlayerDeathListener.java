package me.kelseyum.statplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.utils.Utils;

public class PlayerDeathListener implements Listener {

	private static Main plugin;

	public PlayerDeathListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		// If the killer of the player is a player
		if (e.getEntity().getKiller() instanceof Player) {
			Player killer = e.getEntity().getKiller();
			Player p = e.getEntity();

			if (p != killer) {
				killer.sendMessage(Utils
						.chat(plugin.getConfig().getString("killer_message").replace("<player>", p.getDisplayName())));
				p.sendMessage(Utils.chat(
						plugin.getConfig().getString("victim_message").replace("<player>", killer.getDisplayName())));
			} else {
				p.sendMessage(Utils.chat(
						plugin.getConfig().getString("suicide_message")));
			}

			return;

		} else { // Player killed by an entity
			// TODO: Add code for non pvp death messaging?
		}
	}
}
