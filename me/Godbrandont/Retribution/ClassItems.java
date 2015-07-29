package me.Godbrandont.Retribution;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Godbrandont.Retribution.BaseClasses.*;
import me.Godbrandont.Retribution.*;

public class ClassItems {
	
	// NEEDS EDITING
	
	public static void giveCreg(Player player) {
		player.getInventory().addItem(new ItemStack(Material.COAL, 1));
		player.getInventory().addItem(new ItemStack(Material.WHEAT, 1));
		player.getInventory().addItem(new ItemStack(Material.BOWL, 1));
		player.getInventory().addItem(new ItemStack(Material.BOOK, 1));
		
		if(Team.getTeam(player).getName().toString() == "Red")
		{
			player.getInventory().setHelmet(new ItemStack(Material.WOOL, 1, DyeColor.RED.getData()));
		}
		else if(Team.getTeam(player).getName().toString() == "Blue")
		{
			player.getInventory().setHelmet(new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getData()));
		}
		player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

	}
	

}
