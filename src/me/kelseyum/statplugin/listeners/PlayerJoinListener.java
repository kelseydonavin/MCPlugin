package me.kelseyum.statplugin.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.database.SQLdatabase;
import me.kelseyum.statplugin.utils.Utils;

public class PlayerJoinListener implements Listener{
	
	private Main plugin;
	
	public PlayerJoinListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	// Always start listeners with @EventHandler
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		if (!p.hasPlayedBefore()) {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("first_join_message").replace("<player>", p.getName())));
			
		} else {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", p.getName())));
		}
		
		String sqlExecutable = "INSERT INTO " + plugin.tableName + " (player_name, time, player_join, player_leave, player_killed, advancement, block_type, number_blocks, number_trades)"
				+ " VALUES ('" + p.getName() + "','" + dtf.format(now) +"', TRUE, NULL, NULL , NULL, NULL, NULL, NULL);";
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
