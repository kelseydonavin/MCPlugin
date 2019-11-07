package me.kelseyum.statplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;

import me.kelseyum.statplugin.Main;

public class AnimalTameListener implements Listener {

	private static Main plugin;
	
	public AnimalTameListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	public void onEntityTame(EntityTameEvent e) {
		AnimalTamer p = e.getOwner(); // Player
		LivingEntity a = e.getEntity(); // Animal Tamed
		
		//Write to JSON, SQL, API
		
	}
}
