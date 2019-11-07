package me.kelseyum.statplugin.listeners;

import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.json.simple.JSONObject;

import me.kelseyum.statplugin.Main;

public class PlayerAdvancementDoneListener implements Listener{

	private static Main plugin;

	public PlayerAdvancementDoneListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("unchecked")
	@EventHandler
	public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent e) {
		Player p = e.getPlayer();
		Advancement a = e.getAdvancement();
		
		JSONObject pluginStats = new JSONObject();
		pluginStats.put("Player", p.getName());
		pluginStats.put("AchievementDone", a.getCriteria());
		
		plugin.statList.add(pluginStats);
		
		try (FileWriter file = new FileWriter("StatPluginOutput.json", true)) {
			file.write(plugin.statList.toJSONString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
