package me.kelseyum.statplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.utils.Utils;

public class HelloCommand implements CommandExecutor {
	
	private Main plugin;
	
	public HelloCommand(Main plugin) {
		this.plugin = plugin;
		
		// Register command
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players may execute this command!");
			return true; // Code stops at return true
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("hello.use")) {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("hello_message")));
			return true;
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
		}
		
		return false;
	}
}
