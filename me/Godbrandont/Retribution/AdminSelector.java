package me.Godbrandont.Retribution;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminSelector implements Listener {
	
	public static void menu(Player player) {
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "Ability Selector");
		
		ItemStack item = new ItemStack(Material.BOWL);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.GREEN + "Flame Explosion");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY +"Explosion of fire.");
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
		inv.setItem(0, item);
		
		ItemStack item1 = new ItemStack(Material.WHEAT);
		ItemMeta item1Meta = item1.getItemMeta();
		item1Meta.setDisplayName(ChatColor.GREEN + "Hasted Advance");
		List<String> lore1 = new ArrayList<String>();
		lore1.add(ChatColor.GRAY +"Dash past your enemies.");
		item1Meta.setLore(lore1);
		item1.setItemMeta(item1Meta);
		inv.setItem(1, item1);

		ItemStack item2 = new ItemStack(Material.COAL);
		ItemMeta item2Meta = item2.getItemMeta();
		item2Meta.setDisplayName(ChatColor.GREEN + "Hook Thing");
		List<String> lore2 = new ArrayList<String>();
		lore2.add(ChatColor.GRAY +"Pull your enemies towards you.");
		item2Meta.setLore(lore2);
		item2.setItemMeta(item2Meta);
		inv.setItem(2, item2);
		
		ItemStack item3 = new ItemStack(Material.BOOK);
		ItemMeta item3Meta = item3.getItemMeta();
		item3Meta.setDisplayName(ChatColor.GREEN + "Get Fucking Wrecked m8");
		List<String> lore3 = new ArrayList<String>();
		lore3.add(ChatColor.GRAY +"Blast your enemy in the air.");
		item3Meta.setLore(lore3);
		item3.setItemMeta(item3Meta);
		inv.setItem(3, item3);
		
		ItemStack item4 = new ItemStack(Material.THIN_GLASS);
		ItemMeta item4Meta = item4.getItemMeta();
		item4Meta.setDisplayName(ChatColor.RED + "Coming Soon");
		item4.setItemMeta(item4Meta);
		inv.setItem(4, item4);
		inv.setItem(5, item4);
		inv.setItem(6, item4);
		inv.setItem(7, item4);
		inv.setItem(8, item4);
		inv.setItem(9, item4);
		inv.setItem(10, item4);
		inv.setItem(11, item4);
		inv.setItem(12, item4);
		inv.setItem(13, item4);
		inv.setItem(14, item4);
		inv.setItem(15, item4);
		
		
		player.openInventory(inv);
	
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Ability Selector")){

		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
			return;
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.stripColor("Flame Explosion"))) {
			player.getInventory().addItem(new ItemStack (Material.BOWL));
			player.closeInventory();
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.stripColor("Hasted Advance"))) {
			player.getInventory().addItem(new ItemStack (Material.WHEAT));
			player.closeInventory();
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.stripColor("Hook Thing"))) {
			player.getInventory().addItem(new ItemStack (Material.COAL));
			player.closeInventory();
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.stripColor("Get Fucking Wrecked m8"))) {
			player.getInventory().addItem(new ItemStack (Material.BOOK));
			player.closeInventory();
		}
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack is = e.getItem();
		
		if(a == Action.PHYSICAL || is == null || is.getType() == Material.AIR) {
			return;
		}
		if (is.getType() == Material.APPLE) {
			menu(e.getPlayer());
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		//e.getPlayer().getInventory().addItem(new ItemStack(Material.APPLE));
	}
}
