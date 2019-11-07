package me.kelseyum.statplugin;

import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.kelseyum.statplugin.commands.DayCommand;
import me.kelseyum.statplugin.commands.FlyCommand;
import me.kelseyum.statplugin.commands.HelloCommand;
import me.kelseyum.statplugin.listeners.AnimalTameListener;
import me.kelseyum.statplugin.listeners.BlockBreakListener;
import me.kelseyum.statplugin.listeners.BlockPlaceListener;
// import me.kelseyum.statplugin.commands.TestCommand;
// import me.kelseyum.statplugin.listeners.InventoryClickListener;
import me.kelseyum.statplugin.listeners.JoinListeners;
import me.kelseyum.statplugin.listeners.PlayerAdvancementDoneListener;
import me.kelseyum.statplugin.listeners.PlayerBreedListener;
import me.kelseyum.statplugin.listeners.PlayerDeathListener;
import me.kelseyum.statplugin.listeners.PlayerLevelChangeListener;
import me.kelseyum.statplugin.listeners.PlayerShearListener;
// import me.kelseyum.statplugin.ui.TestUI;

public class Main extends JavaPlugin {
	
	public JSONArray statList = new JSONArray();;

	@Override
	public void onEnable() {
		// Every time plugin loads up, it will save everything you have in the config
		saveDefaultConfig();
		
		// Register listener classes
		new JoinListeners(this);
		new PlayerDeathListener(this);
		new PlayerBreedListener(this);
		new PlayerLevelChangeListener(this);
		new PlayerAdvancementDoneListener(this);
		new AnimalTameListener(this);
		new BlockBreakListener(this);
		new BlockPlaceListener(this);
		new PlayerShearListener(this);
	
		// Register command classes
		new FlyCommand(this);
		new HelloCommand(this);
		new DayCommand(this);
	}
}
