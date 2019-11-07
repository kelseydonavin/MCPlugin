package me.kelseyum.statplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

import me.kelseyum.statplugin.Main;

public class PlayerBreedListener implements Listener{
	
	private static Main plugin;
	
	public PlayerBreedListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityBreedEvent(EntityBreedEvent e) {
		LivingEntity p = e.getBreeder(); // Player??
		LivingEntity b = e.getEntity();
		
		// Write to JSON, SQL, API
	}
}
