package me.kelseyum.statplugin.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.database.SQLdatabase;
import me.kelseyum.statplugin.utils.Utils;

public class PlayerDeathListener implements Listener {

	private static Main plugin;

	public PlayerDeathListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		// If the killer of the player is a player
		if (e.getEntity().getKiller() instanceof Player) {
			Player killer = e.getEntity().getKiller();
			Player p = e.getEntity();

			String sqlExecutable;
			Statement stmt = null;

			if (p != killer) {
				killer.sendMessage(Utils
						.chat(plugin.getConfig().getString("killer_message").replace("<player>", p.getDisplayName())));
				p.sendMessage(Utils.chat(
						plugin.getConfig().getString("victim_message").replace("<player>", killer.getDisplayName())));
				
				sqlExecutable = "INSERT INTO " + plugin.tableName + " (player_name, time, player_killed, advancement, block_type, number_blocks, number_trades)"
						+ " VALUES ('" + killer.getName() + "', NULL, '" + p.getName() + "', NULL, NULL, NULL, NULL);";
				
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
				
			} else {
				p.sendMessage(Utils.chat(
						plugin.getConfig().getString("suicide_message")));
			}

			return;

		} else { // Player killed by an entity
			// TODO: Add code for non pvp death messaging?
		}
	}
}
