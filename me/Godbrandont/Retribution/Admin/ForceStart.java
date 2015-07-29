package me.Godbrandont.Retribution.Admin;

import me.AdityaTD.TitlesAPI.TitlesAPI;
import me.Godbrandont.Retribution.BaseClasses.StartCount;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceStart implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("forcestart")) {
			for (Player p : Bukkit.getOnlinePlayers()) { 
				TitlesAPI.sendTitle(p, 10, 40, 10, ChatColor.GOLD + "", ChatColor.RED + "[ADMIN] " + sender.getName() + ChatColor.GRAY + " has force-started the game!");
			}
			StartCount.timeUntilStart = 7;
		}
		
		
		
		return false;
	}
	

}
