package me.kelseyum.statplugin.ui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.kelseyum.statplugin.utils.Utils;

public class TestUI {

	public static Inventory inv;
	
	public static String inventory_name;
	
	public static int inv_rows = 4 * 9;
	
	public static void initialize() {
		
		inventory_name = Utils.chat("&6&lTest GUI");
		
		inv = Bukkit.createInventory(null, inv_rows);
	}
	
	public static Inventory GUI(Player p) {
		
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
		
		Utils.createItem(inv, "stone", 1, 1, "&cTest Item", "&7This is lore line 1", "&bSecond line", "&3Third line");
		
		toReturn.setContents(inv.getContents());
	
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		
		if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cTest Item"))) {
			p.setDisplayName(Utils.chat("&8[&6*&8] &6&1You have made a GUI"));
		}
	}
}
