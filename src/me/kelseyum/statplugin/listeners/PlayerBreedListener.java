package me.kelseyum.statplugin.listeners;

import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;
import org.json.simple.JSONObject;

import me.kelseyum.statplugin.Main;

public class PlayerBreedListener implements Listener{
	
	private static Main plugin;
	
	public PlayerBreedListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onEntityBreedEvent(EntityBreedEvent e) {
		LivingEntity p = e.getBreeder(); // Player??
		LivingEntity b = e.getEntity();
		
		JSONObject pluginStats = new JSONObject();
		pluginStats.put("Player", p.getName());
		pluginStats.put("AnimalMated", b.getType());
		
		plugin.statList.add(pluginStats);
		
		/*
		try (FileWriter file = new FileWriter("StatPluginOutput.json", true)) {
			file.write(plugin.statList.toJSONString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}
