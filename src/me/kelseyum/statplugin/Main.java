package me.kelseyum.statplugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;

import me.kelseyum.statplugin.database.SQLdatabase;
import me.kelseyum.statplugin.listeners.BlockBreakListener;
import me.kelseyum.statplugin.listeners.PlayerAdvancementDoneListener;
// import me.kelseyum.statplugin.ui.TestUI;
import me.kelseyum.statplugin.listeners.PlayerDeathListener;

public class Main extends JavaPlugin {

	public JSONArray statList = new JSONArray();
	public Connection con;
	public String tableName; 
	public Statement stmt;

	@Override
	public void onEnable() {
		// Every time plugin loads up, it will save everything you have in the config
		saveDefaultConfig();
		
		SQLdatabase sql = new SQLdatabase();
		Connection con;
		con = sql.connect();
				
		tableName = "friday";
		String sqlExecutable = "CREATE TABLE IF NOT EXISTS " + tableName + 
		"(Time TEXT,"
		+ "Player_Name TEXT NOT NULL, "
		+ "Player_Killed TEXT,"
		+ "Advancement TEXT,"
		+ "Block_Type TEXT,"
		+ "Number_Blocks INT,"
		+ "Number_Trades INT);";
		
		stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.executeUpdate(sqlExecutable);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// new DatasbaseSetup(this);

		// Register listener classes
		// new JoinListeners(this);
		new PlayerDeathListener(this);
		// new PlayerBreedListener(this);
		// new PlayerLevelChangeListener(this);
		new PlayerAdvancementDoneListener(this);
		// new AnimalTameListener(this);
		new BlockBreakListener(this);
		// new BlockPlaceListener(this);
		// new PlayerShearListener(this);

		// Register command classes
		// new FlyCommand(this);
		// new HelloCommand(this);
		// new DayCommand(this);
	}

	// add onDisable
}
