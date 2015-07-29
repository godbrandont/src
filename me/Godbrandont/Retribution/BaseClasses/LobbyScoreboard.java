package me.Godbrandont.Retribution.BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import me.Godbrandont.Retribution.BaseClasses.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class LobbyScoreboard implements Listener {
	
	String url = "Removed for security purposes";
	String url1 = "Removed for security purposes";
	String user = "root";
	String pass = "Removed for security purposes";


	public static void onScoreboard() {
		if (!(Game.hasStarted())) {
	
			ScoreboardManager sm = Bukkit.getScoreboardManager();
			Scoreboard onJoin = sm.getNewScoreboard();
			Objective o = onJoin.registerNewObjective("dash", "dummy");
			o.setDisplaySlot(DisplaySlot.SIDEBAR);
			o.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "RETRIBUTION");
			Score spacer = null;
			Score map = null;
			Score players = null;
			Score spacer2 = null;
			Score time = null;
			Score spacer3 = null;
			Score web = null;
			
			try {
				spacer = o.getScore(ChatColor.BLACK + "");
				spacer.setScore(8);
				
				map = o.getScore(ChatColor.GREEN + "Map: " + ChatColor.WHITE + "TBD");
				map.setScore(7);
				
				players = o.getScore(ChatColor.GREEN + "Players: " + ChatColor.LIGHT_PURPLE + Bukkit.getOnlinePlayers().size() + "/12");
				players.setScore(6);
				
				spacer2 = o.getScore(ChatColor.RED + "");
				spacer2.setScore(5);
				
				time = o.getScore(ChatColor.GREEN + "Time: " + ChatColor.YELLOW + StartCount.timeUntilStart);
				time.setScore(4);

				spacer3 = o.getScore(ChatColor.YELLOW + "");
				spacer3.setScore(2);
				
				web = o.getScore(ChatColor.YELLOW + "AndromedaMC.com");
				web.setScore(1);
	
				for (Player pl : Bukkit.getOnlinePlayers()) {
					pl.setScoreboard(onJoin);
				}
				
			
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			}
			
			
	}
}
