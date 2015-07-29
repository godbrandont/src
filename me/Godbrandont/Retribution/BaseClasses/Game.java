package me.Godbrandont.Retribution.BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

import me.AdityaTD.TitlesAPI.TitlesAPI;
import me.Godbrandont.Retribution.ClassItems;
import me.Godbrandont.Retribution.LocationManager;
import me.Godbrandont.Retribution.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Game implements Listener{
	
	private static boolean canStart = false;
	private static boolean hasStarted = false;
	public static Location redSpawn = new Location(Bukkit.getWorld("world"), 10039.5, 4, 15009.5, -45, 0);
	public static Location blueSpawn = new Location(Bukkit.getWorld("world"), 10030.5, 4, 15009.5, 180, 0);
	
	static Main plugin; 
	
	static String url = "Removed for security purposes";
	static String user = "root";
	static String pass = "Removed for security purposes";
	
	public Game(Main pl){
		plugin = pl;
	}
	
	private static String prefix(){
		return ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Retribution" 
				+ ChatColor.DARK_GRAY + "] " + ChatColor.AQUA;
	}
	
	
	public static void StartGame(){
		//Start the Game
		hasStarted = true;
		//plugin.stopCountdown();
		//Bukkit.getServer().getScheduler().cancelTask(Main.startCountdownID);
		new Team("Red", new Location(Bukkit.getWorld("world"), 10039.5, 4, 15009.5));
		new Team("Blue", new Location(Bukkit.getWorld("world"), 10030.5, 4, 15009.5));	
			
		int i = 0;
		for(Player player : Bukkit.getOnlinePlayers()){
			if(i >= Team.getAllTeams().size())
				i = 0;
			Team.getAllTeams().get(i).add(player); // Assign team to player				
			LocationManager.teleportToGame(player, Team.getTeam(player));
			player.sendMessage(prefix() + ChatColor.GOLD + "You are on the " + Team.getTeam(player).getName().toString() + " team.");
			player.setMaxHealth(40);
			
			if(Team.getTeam(player).getName().toString() == "Red"){
				player.setDisplayName(ChatColor.RED + "[RED] " + player.getName() + ":" + ChatColor.WHITE);
		        TitlesAPI.sendTitle(player, 2, 40, 2, ChatColor.GREEN + "Game has started!",ChatColor.GREEN + "You are on the " + ChatColor.RED + "RED" + " team!");
				player.setPlayerListName(ChatColor.RED + player.getName());
				player.teleport(redSpawn);
				ClassItems.giveCreg(player);
			}
			
			else if(Team.getTeam(player).getName().toString() == "Blue"){
				player.setDisplayName(ChatColor.BLUE + "[BLUE] " + player.getName() + ":" + ChatColor.WHITE);
		        TitlesAPI.sendTitle(player, 2, 40, 2, ChatColor.GREEN + "Game has started!",ChatColor.GREEN + "You are on the " + ChatColor.BLUE + "BLUE" + " team!");
				player.setPlayerListName(ChatColor.BLUE + player.getName());
				player.teleport(blueSpawn);
				ClassItems.giveCreg(player);
			}
			i++;
			
			UUID name = player.getUniqueId();
			

			
			try {
				Connection conn = DriverManager.getConnection(url,user,pass);
				Statement stmt = conn.createStatement();
				String checker = "SELECT class FROM gal_class WHERE UUID='"+name.toString()+"'";
				ResultSet rs = stmt.executeQuery(checker);

				if (rs.next()) {
					String classname = rs.getString("class");
					player.sendMessage(classname);
					if (classname.contains("Creg")) {
						player.sendMessage(prefix() + ChatColor.GOLD + "You are using class: " + ChatColor.GREEN + "[Creg]" + ChatColor.GOLD + "!");
						player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Creg I]" + ChatColor.GOLD + "!");
						ClassItems.giveCreg(player);
					}
					else if (classname.contains("Creg")) {
						player.sendMessage(prefix() + ChatColor.GOLD + "You are using class: " + ChatColor.GREEN + "[Creg]" + ChatColor.GOLD + "!");
						player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Creg I]" + ChatColor.GOLD + "!");
						ClassItems.giveCreg(player);
					}
					else if (classname.contains("Creg")) {
						player.sendMessage(prefix() + ChatColor.GOLD + "You are using class: " + ChatColor.GREEN + "[Creg]" + ChatColor.GOLD + "!");
						player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Creg I]" + ChatColor.GOLD + "!");
						ClassItems.giveCreg(player);
					}
					else {
						player.sendMessage("asdasdasd");
						
						Random rand = new Random();
						
						int randomInt = rand.nextInt((1-3));
						
						if (randomInt == 1) {
							ClassItems.giveCreg(player);
							String randomclass = "Creg";
							player.sendMessage(prefix() + ChatColor.GOLD + "You did not pick a class so you have been given: " + ChatColor.GREEN + "[" + randomclass + "]" + ChatColor.GOLD + "!");
							player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Tank I]" + ChatColor.GOLD + "!");
						}
						else if (randomInt == 2) {
							ClassItems.giveCreg(player);
							String randomclass = "Creg";
							player.sendMessage(prefix() + ChatColor.GOLD + "You did not pick a class so you have been given: " + ChatColor.GREEN + "[" + randomclass + "]" + ChatColor.GOLD + "!");
							player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Ranger I]" + ChatColor.GOLD + "!");
						}
						else if (randomInt == 1) {
							ClassItems.giveCreg(player);
							String randomclass = "Creg";
							player.sendMessage(prefix() + ChatColor.GOLD + "You did not pick a class so you have been given: " + ChatColor.GREEN + "[" + randomclass + "]" + ChatColor.GOLD + "!");
							player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Runner I]" + ChatColor.GOLD + "!");
						}
						else {
							ClassItems.giveCreg(player);
							String randomclass = "Creg";
							player.sendMessage(prefix() + ChatColor.GOLD + "You did not pick a class so you have been given: " + ChatColor.GREEN + "[" + randomclass + "]" + ChatColor.GOLD + "!");
							player.sendMessage(prefix() + ChatColor.GOLD + "Your kit level is: " + ChatColor.GREEN + "[Runner I]" + ChatColor.GOLD + "!");
						}
						
					}

				
				}
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			

			//Capture.captureBeacon(player);
			
			
		}
		

	}

	public static void StopGame(){
		//Stop the Game
		hasStarted = false;
	}
	
	public static boolean canStart() {
		//Check if the game can start
		return canStart;
	}
	
	public static boolean hasStarted(){
		return hasStarted;
	}
	
	public static void setCanStart(boolean b){
		canStart = b;
	}
}
