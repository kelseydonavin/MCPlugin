package me.kelseyum.statplugin.listeners;

import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;
import org.json.simple.JSONObject;

import me.kelseyum.statplugin.Main;

public class AnimalTameListener implements Listener {

	private static Main plugin;
	
	public AnimalTameListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("unchecked")
	public void onEntityTame(EntityTameEvent e) {
		AnimalTamer p = e.getOwner(); // Player
		LivingEntity a = e.getEntity(); // Animal Tamed
		
		JSONObject pluginStats = new JSONObject();
		pluginStats.put("Player", p.getName());
		pluginStats.put("AnimalTamed", a.getType());
		
		plugin.statList.add(pluginStats);
		
		try (FileWriter file = new FileWriter("StatPluginOutput.json", true)) {
			file.write(plugin.statList.toJSONString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
