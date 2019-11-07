package me.kelseyum.statplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import me.kelseyum.statplugin.Main;

public class PlayerLevelChangeListener implements Listener{

	private static Main plugin;
	
	public PlayerLevelChangeListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent e) {
		Player p = e.getPlayer();
		int level = e.getNewLevel();
		
		// Write to JSON, API, or SQL
	}
}
