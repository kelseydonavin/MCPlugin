package me.kelseyum.statplugin.listeners;

import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.json.simple.JSONObject;

import me.kelseyum.statplugin.Main;

public class BlockPlaceListener implements Listener {

	private static Main plugin;
	
	public BlockPlaceListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		JSONObject pluginStats = new JSONObject();
		pluginStats.put("Player", p.getDisplayName());
		pluginStats.put("BlockPlaced", b.getType());
		
		plugin.statList.add(pluginStats);
		
		try (FileWriter file = new FileWriter("StatPluginOutput.json", true)) {
			file.write(plugin.statList.toJSONString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
