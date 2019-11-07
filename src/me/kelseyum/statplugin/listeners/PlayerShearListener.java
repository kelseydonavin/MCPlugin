package me.kelseyum.statplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

import me.kelseyum.statplugin.Main;

public class PlayerShearListener implements Listener {

	private static Main plugin;
	
	public PlayerShearListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerShearEntity(PlayerShearEntityEvent e) {
		Player p = e.getPlayer();
		Entity a = e.getEntity();
		
		// Write to whatever
	}
}
