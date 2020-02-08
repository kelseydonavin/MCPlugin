package me.kelseyum.statplugin.database;


import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.Connection;

public class MysqlMain extends JavaPlugin{

	private Connection connection;
	public String host, database, username, password;
	public int port;
	
	public void onEnable() {
		
	}
	
	public void mysqlSetup() {
		
	}
}
