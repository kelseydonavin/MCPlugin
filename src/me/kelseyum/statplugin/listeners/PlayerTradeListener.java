package me.kelseyum.statplugin.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.TradeSelectEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.database.SQLdatabase;

public class PlayerTradeListener implements Listener {

private static Main plugin;
static ConsoleCommandSender console = Bukkit.getConsoleSender();

	
	public PlayerTradeListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onTradeSelectEvent(TradeSelectEvent e) {
		String p = e.getMerchant().getTrader().getName();
		
		if (e.getMerchant().isTrading() == true) {
			console.sendMessage("Traded");
			String sqlExecutable = "INSERT INTO " + plugin.tableName + " (player_name, time, player_killed, advancement, block_type, number_blocks, number_trades)"
					+ " VALUES ('" + p + "', NULL, NULL , NULL, NULL, NULL, 1);";
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
