package me.kelseyum.statplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.utils.Utils;

public class DayCommand implements CommandExecutor {
	
	private Main plugin;

	public DayCommand(Main plugin) {
		this.plugin = plugin;

		// Register command
		plugin.getCommand("day").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		// Not a player -- so console
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			return true; // Stop code
		}

		// Player variable -- keep underneath the "null" check
		// Want to make sure we are dealing with a player past error check
		Player p = (Player) sender;
		
		if (p.hasPermission("custom_day")) {
			p.getLocation().getWorld().setTime(1000);
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("day_message").replace("<player>", p.getName())));
		}

		return false;
	}
}
