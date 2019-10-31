package me.kelseyum.statplugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.kelseyum.statplugin.commands.FlyCommand;
import me.kelseyum.statplugin.commands.HelloCommand;
import me.kelseyum.statplugin.listeners.JoinListeners;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		// Every time plugin loads up, it will save everything you have in the config
		saveDefaultConfig();
		
		// Register the join listener class in main
		new JoinListeners(this);

		// Register class for fly command
		new FlyCommand(this);
		
		// Register class for hello command
		new HelloCommand(this);
	}
}
