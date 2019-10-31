package me.kelseyum.statplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kelseyum.statplugin.Main;
import me.kelseyum.statplugin.utils.Utils;

public class FlyCommand implements CommandExecutor {

	private Main plugin;

	public FlyCommand(Main plugin) {
		this.plugin = plugin;

		// Register command
		plugin.getCommand("fly").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Not a player -- so console
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			return true; // Stop code
		}

		// Player variable -- keep underneath the "null" check
		// Want to make sure we are dealing with a player past error check
		Player p = (Player) sender;

		if (p.hasPermission("custom.fly")) {
			if (p.isFlying()) {
				p.setAllowFlight(false);
				p.setFlying(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.flying_disabled")));
				return true;
			} else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.flying_enabled")));
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
		}

		return false;
	}
}
