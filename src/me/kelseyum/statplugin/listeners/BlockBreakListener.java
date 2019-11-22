package me.kelseyum.statplugin.listeners;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.kelseyum.statplugin.Main;

public class BlockBreakListener implements Listener {

private static Main plugin;
	
	public BlockBreakListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		JSONObject pluginStats = new JSONObject();
		pluginStats.put("Player", p.getDisplayName());
		pluginStats.put("BlockBroken", b.getType());
		
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

