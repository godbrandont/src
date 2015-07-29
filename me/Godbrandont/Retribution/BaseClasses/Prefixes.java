package me.Godbrandont.Retribution.BaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Prefixes implements Listener {
	
	String url = "Removed for security purposes";
	String user = "root";
	String pass = "Removed for security purposes";
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		  e.setFormat("%s %s");
	
			e.getPlayer().setPlayerListName(ChatColor.GRAY  + e.getPlayer().getName());
			try {
				Player p = e.getPlayer();
				Connection conn = DriverManager.getConnection(url,user,pass);
				Statement stmt = conn.createStatement();
				String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
				ResultSet rs = stmt.executeQuery(checker);
				if(rs.next()) {
					String rank = rs.getString("rank");
				if(rank.contains("Admin")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.RED + "[ADMIN] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.RESET + ChatColor.YELLOW);
								e.getPlayer().setPlayerListName(ChatColor.RED + "[ADMIN] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.RED + "[ADMIN] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.RESET + ChatColor.YELLOW);
								e.getPlayer().setPlayerListName(ChatColor.RED + "[ADMIN] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("Builder")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.AQUA + "[BUILDER] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.AQUA + "[BUILDER] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.AQUA + "[BUILDER] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.AQUA + "[BUILDER] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("Mod")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.DARK_GREEN + "[MOD] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + "[MOD] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.DARK_GREEN + "[MOD] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + "[MOD] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("Default")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								 e.getPlayer().setDisplayName(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.RESET + ChatColor.GRAY);
								 e.getPlayer().setPlayerListName(ChatColor.GRAY + e.getPlayer().getName() + " - " + clanname);
								 
							
							}else{
								 e.getPlayer().setDisplayName(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.RESET + ChatColor.GRAY);
								 e.getPlayer().setPlayerListName(ChatColor.GRAY + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("Donator")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.GOLD + "[D] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.GOLD + "[D] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
								 
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.GOLD + "[D] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.GOLD + "[D] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("DonatorPlus")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.LIGHT_PURPLE + "[D+] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.LIGHT_PURPLE + "[D+] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
								 
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.LIGHT_PURPLE + "[D+] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.LIGHT_PURPLE + "[D+] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("DonatorElite")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.GREEN + "[D-Elite] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.GREEN + "[D-Elite] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
								 
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.GREEN + "[D-Elite] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.GREEN + "[D-Elite] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
				if(rank.contains("YT")) {
					try {
						Connection conn1 = DriverManager.getConnection(url,user,pass);
						Statement stmt1 = conn1.createStatement();
						String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
						ResultSet rs1 = stmt1.executeQuery(checker1);
							if(rs1.next()) {
								String clanname = rs1.getString("clan");
								e.getPlayer().setDisplayName(ChatColor.DARK_AQUA + "[YT] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.DARK_AQUA + "[YT] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
								 
							
							}else{
								e.getPlayer().setDisplayName(ChatColor.DARK_AQUA + "[YT] " + e.getPlayer().getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " >" + ChatColor.WHITE);
								e.getPlayer().setPlayerListName(ChatColor.DARK_AQUA + "[YT] " + e.getPlayer().getName());
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
	
			
					
				
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("Admin")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.RED + "[ADMIN] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.RED + "[ADMIN] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("Mod")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + "[MOD] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + "[MOD] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("Builder")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.AQUA + "[BUILDER] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.AQUA + "[BUILDER] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("Default")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.GRAY + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("Donator")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.GOLD + "[D] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.GOLD + "[D] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("DonatorPlus")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.LIGHT_PURPLE + "[D+] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.LIGHT_PURPLE + "[D+] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("DonatorElite")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.GREEN + "[D-Elite] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.GREEN + "[D-Elite] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		try {
			Player p = e.getPlayer();
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			String checker = "SELECT * FROM rank WHERE UUID='"+p.getUniqueId().toString()+"'";
			ResultSet rs = stmt.executeQuery(checker);
			if(rs.next()) {
				String rank = rs.getString("rank");
			if(rank.contains("YT")) {
				try {
					Connection conn1 = DriverManager.getConnection(url,user,pass);
					Statement stmt1 = conn1.createStatement();
					String checker1 = "SELECT * FROM clanname WHERE UUID='"+p.getUniqueId().toString()+"'";
					ResultSet rs1 = stmt1.executeQuery(checker1);
						if(rs1.next()) {
							String clanname = rs1.getString("clan");
							e.getPlayer().setPlayerListName(ChatColor.DARK_AQUA + "[YT] " + e.getPlayer().getName() + ChatColor.GRAY + " - " + clanname);
						
						}else{
							e.getPlayer().setPlayerListName(ChatColor.DARK_AQUA + "[YT] " + e.getPlayer().getName());
					}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			}
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}

}
