package me.Godbrandont.Retribution;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import me.Godbrandont.Retribution.Admin.ForceStart;
import me.Godbrandont.Retribution.BaseClasses.Game;
import me.Godbrandont.Retribution.BaseClasses.GameStates;
import me.Godbrandont.Retribution.BaseClasses.LobbyScoreboard;
import me.Godbrandont.Retribution.BaseClasses.StartCount;
import me.Godbrandont.Retribution.BaseClasses.Team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public static int startCountdownID;
	public static int captureCountdownID;
	public static int captureCooldownID;
	
	// <-- Database details
	String url = "Removed for security purposes";
	String user = "root";
	String pass = "Removed for security purposes";
	
	public void onEnable()
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		registerListeners();
		GameStates.setState(GameStates.IN_LOBBY);
		startCountdown();
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");
		this.getCommand("forcestart").setExecutor(new ForceStart());
	}
	
	public void registerListeners()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Events(this), this);
		pm.registerEvents(new AdminSelector(), this);
		pm.registerEvents(new LobbyScoreboard(), this);
		pm.registerEvents(new MasterListener(this), this);
		pm.registerEvents(new PlayerJoinListener(this), this);
		pm.registerEvents(new PlayerQuitListener(this), this);
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e)
	{
		e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 10025.5, 16, 14986.5));
		e.getPlayer().getInventory().setArmorContents(null);
		e.getPlayer().getInventory().setContents(null);
	}
	
	@EventHandler
	public void OnPlayerMove(PlayerMoveEvent e)
	{
		e.getPlayer().setFoodLevel(20);
	}
	
	public void sendServer(Player player, String targetServer) { // Sends players to other servers. Use sendServer(player,"servername")
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try {
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
	}
	
	public boolean onCommand(CommandSender sender, Command cmd) { // Leave lobby command
		Player player = (Player) sender;
		
		if(cmd.getName() == "lobby" || cmd.getName() == "leave" || cmd.getName() == "hub" || cmd.getName() == "quit" || cmd.getName() == "exit" ) {
			sendServer(player,"MainLobby");
		}
		
		
		return false;
		
	}
	
	@EventHandler
	public void OnPlayerRespawn(PlayerRespawnEvent e)
	{
		Player player = e.getPlayer();
		
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect " + e.getPlayer() + " speed 100000");
		if(Team.getTeam(player).getName().toString() == "Red"){
			player.teleport(Game.redSpawn);
		}
		else if(Team.getTeam(player).getName().toString() == "Blue"){
			player.teleport(Game.blueSpawn);
		}
		
	}


	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player k = (Player) e.getEntity().getKiller();
		String uuid = k.getUniqueId().toString();
		
		try { 
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM killstats WHERE UUID='"+uuid+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String sql = "UPDATE killstats SET kills=kills+1 WHERE UUID='"+uuid+"'";
				stmt.executeUpdate(sql);
			}else{
				String sqladd = "INSERT INTO killstats (UUID,kills) VALUES ('"+uuid+"','1')";
				stmt.executeUpdate(sqladd);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
	
	
	}
	
	public void startCountdown()
	{
		StartCount.timeUntilStart = 60;
		startCountdownID = getServer().getScheduler().scheduleSyncRepeatingTask(this, new StartCount(this), 20l, 20l);
	}
	
	public void stopCountdown(){
		getServer().getScheduler().cancelTask(startCountdownID);
	}
	
	public void restartCountdown(){
		stopCountdown();
		startCountdown();
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("retkit1")) {
			e.setLine(0, "§2[Class 1]");
			e.setLine(1, "");
			e.setLine(2, "Click to equip!");
			e.setLine(3, "");
		}
		if (e.getLine(0).equalsIgnoreCase("retkit2")) {
			e.setLine(0, "§2[Class 2]");
			e.setLine(1, "");
			e.setLine(2, "Click to equip!");
			e.setLine(3, "");
		}
		if (e.getLine(0).equalsIgnoreCase("retkit3")) {
			e.setLine(0, "§2[Class 3]");
			e.setLine(1, "");
			e.setLine(2, "Click to equip!");
			e.setLine(3, "");
		}
	}
	
	
}


	
	
	//@EventHandler //<-- Easter egg
	//public void onJoin(PlayerJoinEvent e) {
	//	e.getPlayer().sendMessage("http://goo.gl/ezVZrK");
	//}
	


