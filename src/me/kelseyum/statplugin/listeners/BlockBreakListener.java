package me.kelseyum.statplugin.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.database.SQLdatabase;

public class BlockBreakListener implements Listener {

private static Main plugin;

static ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	public BlockBreakListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		if ((b.getType() == Material.DIAMOND_ORE) || (b.getType() == Material.EMERALD_ORE)){
			//console.sendMessage("Player: " + p.getName() + ", Block Type: " + b.getType().toString());

			String sqlExecutable = "INSERT INTO " + plugin.tableName + " (player_name, player_time, player_join, player_leave, player_killed, advancement, block_type, number_blocks)"
			+ " VALUES ('" + p.getName() + "', NULL, NULL, NULL, NULL , NULL, '" + b.getType().toString() + "', 1);";
			
			SQLdatabase sql = new SQLdatabase();
			Connection con;
			con = sql.connect();
			Statement stmt;
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

