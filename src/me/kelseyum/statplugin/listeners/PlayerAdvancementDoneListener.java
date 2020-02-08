package me.kelseyum.statplugin.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.database.SQLdatabase;

public class PlayerAdvancementDoneListener implements Listener{

	private static Main plugin;
	
	static ConsoleCommandSender console = Bukkit.getConsoleSender();

	public PlayerAdvancementDoneListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("unchecked")
	@EventHandler
	public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent e) {
		Player p = e.getPlayer();
		Advancement a = e.getAdvancement();
		String advanc = a.getKey().getKey();
		String sqlExecutable;
		Statement stmt = null;
		
		// Enter end portal
		if (advanc.indexOf("story") != -1) {
			if (advanc.indexOf("enter_the_end") != -1) {
				// console.sendMessage("Player: " + p.getName() + ", Advancement: " + advanc.replace("story/", ""));
				sqlExecutable = "INSERT INTO " + plugin.tableName + " (player_name, time, player_killed, advancement, block_type, number_blocks, number_trades)"
						+ " VALUES ('" + p.getName() + "', NULL, NULL, '" + advanc.replace("story/", "") + "', NULL, NULL, NULL);";
				
				SQLdatabase sql = new SQLdatabase();
				Connection con;
				con = sql.connect();
				stmt = null;
				
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					stmt.executeUpdate(sqlExecutable);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		}
		// Kill dragon
		if (advanc.indexOf("end") != -1) {
			if (advanc.indexOf("kill_dragon") != -1) {
				// console.sendMessage("Player: " + p.getName() + ", Advancement: " + advanc.replace("end/", ""));
				sqlExecutable = "INSERT INTO " + plugin.tableName + " (player_name, time, player_killed, advancement, block_type, number_blocks, number_trades)"
						+ " VALUES ('" + p.getName() + "', NULL, NULL, '" + advanc.replace("story/", "") + "', NULL, NULL, NULL);";
				
				SQLdatabase sql = new SQLdatabase();
				Connection con;
				con = sql.connect();
				stmt = null;
				
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					stmt.executeUpdate(sqlExecutable);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
}
