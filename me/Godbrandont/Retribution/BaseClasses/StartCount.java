package me.Godbrandont.Retribution.BaseClasses;

import me.AdityaTD.TitlesAPI.TitlesAPI;
import me.Godbrandont.Retribution.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartCount extends BukkitRunnable{
	
	Main plugin;
	
	public StartCount(Main pl){
		plugin = pl;
	}
	
	public static int timeUntilStart;

	public void run() {	
		for (Player p : Bukkit.getOnlinePlayers()) {
            p.setLevel(timeUntilStart);
           
		}
		
		if (!(Game.hasStarted())) {
			LobbyScoreboard.onScoreboard();
		}
	
		
	
		if (timeUntilStart <= 0){
			if(!Game.canStart()){
				plugin.restartCountdown();
				for (Player p : Bukkit.getOnlinePlayers()) {
		            p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10, 1);
		            TitlesAPI.sendTitle(p, 2, 40, 2, ChatColor.RED + "",ChatColor.RED + "Not enough players!");
		           
				}
				return;
			}else{
			//Start the game
			Bukkit.getServer().getScheduler().cancelTask(Main.startCountdownID);
			Game.StartGame();
			}
		}
			
		
				
		if (timeUntilStart < 6 && timeUntilStart != 0){
			for (Player p : Bukkit.getOnlinePlayers()) {
	            p.playSound(p.getLocation(), Sound.LAVA_POP, 10, 1);
	            TitlesAPI.sendTitle(p, 2, 20, 2, ChatColor.RED + String.valueOf(timeUntilStart), "");
			}
			
		}

		
		timeUntilStart -= 1 ;
				
		
	}
}

	

