package me.kelseyum.statplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import me.kelseyum.statplugin.Main;

public class PlayerAdvancementDoneListener implements Listener{

	private static Main plugin;

	public PlayerAdvancementDoneListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent e) {
		Player p = e.getPlayer();
		Advancement a = e.getAdvancement();
		
		// Write to JSON, API or SQL
	}
}
