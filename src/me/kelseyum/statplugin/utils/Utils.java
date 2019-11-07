package me.kelseyum.statplugin.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {

	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static ItemStack createItem(Inventory inv, String material, int amount, int invSlot, String displayName, String... loreString) {
		
		ItemStack item;
		List<String> lore = new ArrayList();
		
		// Create item stack
		item = new ItemStack(Material.getMaterial(material), amount);
		
		// Item meta is meta data that stores the lore, display name, etc
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat(displayName));
		
		for (String s: loreString) {
			lore.add(Utils.chat(s));
		}
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		// Set new item in inventory slot
		inv.setItem(invSlot - 1,  item);
		
		return item;
	}
	/*
	public static ItemStack createItemByte(Inventory inv, String material, int byteId, int amount, int invSlot, String displayName, String... loreString) {
		
		ItemStack item;
		List<String> lore = new ArrayList();
		
		// Create item stack
		// Deprecated item = new ItemStack(Material.getMaterial(material), amount, (short) byteId);
		
		// Item meta is meta data that stores the lore, display name, etc
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Utils.chat(displayName));
		
		for (String s: loreString) {
			lore.add(Utils.chat(s));
		}
		
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		// Set new item in inventory slot
		inv.setItem(invSlot,  item);
		
		return item;
	}*/
}
