package me.kelseyum.statplugin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

// import org.postgresql.Driver;

public class SQLdatabase {
	
	public static String url = "jdbc:postgresql://localhost:5432/postgres";
	// public static String host = "localhost";
	// public static String port = "5432";
	// public static String database = "Minecraft";
	public static String username = "postgres";
	public static String password = "domin0";
	public static Connection con;
	
	static ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	// Connect
	public Connection connect() {
		
		con = null;
		
		if (!isConnected()) {
			
			try {
		        Class.forName("org.postgresql.Driver");
		    } catch (ClassNotFoundException e) {
		        System.out.println("Class not found " + e);
		    }
			try {
				con = DriverManager.getConnection(url, username, password);
				console.sendMessage("Connection was established!");
				System.out.println("Connected to the PostgreSQL server successfully.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}	
		return con;
	}
	
	// Disconnect
	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();
				console.sendMessage("Connection was closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// isConnected
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	
	// getConnection
	public static Connection getConnection() {
		return con;
	}
}
