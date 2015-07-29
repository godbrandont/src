package me.Godbrandont.Retribution.BaseClasses;


import me.Godbrandont.Retribution.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Gamerule implements Listener {
	
	public static Main plugin;
	
	private static String prefix(){
		return ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Galakords" 
				+ ChatColor.DARK_GRAY + "] ";
	}
	
	private static String onlineBC() {
		return ChatColor.DARK_GRAY + "(" + ChatColor.LIGHT_PURPLE + Bukkit.getOnlinePlayers().size() 
		+ ChatColor.DARK_GRAY + "/" + ChatColor.LIGHT_PURPLE + "12" + ChatColor.DARK_GRAY + ")";
	}
	
	//@EventHandler
	//public void onBlockBreak(BlockBreakEvent e) {
		//e.setCancelled(true); 
	//}
	
	//@EventHandler
	//public void onBlockPlace(BlockPlaceEvent e) {
	//	e.setCancelled(true);
	//}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBucketFill(PlayerBucketFillEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onLightningStrike(LightningStrikeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) { // Broadcasts when a player joins and teleports them to pregame lobby
		//TODO: give player wool blocks to pick team and scoreboard on screen showing details of game.
		//String p = e.getPlayer().getDisplayName();
		Player player = e.getPlayer();
		
		

		
		//Teleport Player to the Game Lobby
		Location gamelobby = new Location(e.getPlayer().getWorld(), 10025.5, 16, 14986.5);
		player.teleport(gamelobby);
		}
	
	
	@EventHandler // Broadcasts when a player leaves the game.
	//TODO: Change colour based on player's rank
	public void onPlayerLeave(PlayerQuitEvent e) { 
		String p = e.getPlayer().getDisplayName();
		e.setQuitMessage(prefix() + ChatColor.GRAY + p + ChatColor.YELLOW + " has quit!");
		
	}
}
