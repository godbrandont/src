package me.Godbrandont.Retribution;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;


public class Events implements Listener{
	
	
	static Main plugin;
	
	public Events(Main pl) {
		plugin = pl;
	}
	
	ParticleEffect flameeffect = new ParticleEffect(ParticleEffect.ParticleType.FLAME, 0.5, 20, 0.0005);
	ParticleEffect cloudeffect = new ParticleEffect(ParticleEffect.ParticleType.CLOUD, 1, 50, 0.0006);
	ParticleEffect explosioneffect = new ParticleEffect(ParticleEffect.ParticleType.EXPLOSION_NORMAL, 1, 10, 0.0004);
	ParticleEffect explosioneffectbig = new ParticleEffect(ParticleEffect.ParticleType.EXPLOSION_NORMAL, 1, 400, 0.001);
	ParticleEffect crit = new ParticleEffect(ParticleEffect.ParticleType.CRIT, 1, 400, 0.001);
	ParticleEffect critmagic = new ParticleEffect(ParticleEffect.ParticleType.CRIT_MAGIC, 1, 400, 0.001);
	ParticleEffect fireworkspark = new ParticleEffect(ParticleEffect.ParticleType.FIREWORKS_SPARK, 1, 75, 0.00003);

	public static Location lookAt(Location loc, Location lookat) {
        //Clone the loc to prevent applied changes to the input loc
        loc = loc.clone();
 
        // Values of change in distance (make it relative)
        double dx = lookat.getX() - loc.getX();
        double dy = lookat.getY() - loc.getY();
        double dz = lookat.getZ() - loc.getZ();
 
        // Set yaw
        if (dx != 0) {
            // Set yaw start value based on dx
            if (dx < 0) {
                loc.setYaw((float) (1.5 * Math.PI));
            } else {
                loc.setYaw((float) (0.5 * Math.PI));
            }
            loc.setYaw((float) loc.getYaw() - (float) Math.atan(dz / dx));
        } else if (dz < 0) {
            loc.setYaw((float) Math.PI);
        }
 
        // Get the distance from dx/dz
        double dxz = Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2));
 
        // Set pitch
        loc.setPitch((float) -Math.atan(dy / dxz));
 
        // Set values, convert to degrees (invert the yaw since Bukkit uses a different yaw dimension format)
        loc.setYaw(-loc.getYaw() * 180f / (float) Math.PI);
        loc.setPitch(loc.getPitch() * 180f / (float) Math.PI);
 
        return loc;
    }
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		p.getInventory().setContents(null);
		p.getInventory().addItem(new ItemStack(Material.BOWL, 1));
		p.setFallDistance(-300f);
		p.setMaxHealth(40);
		p.setHealth(40);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		p.setFallDistance(-300f);
		if((e.getAction() == Action.RIGHT_CLICK_AIR)||(e.getAction() == Action.RIGHT_CLICK_BLOCK))
		{
			if(e.getItem().getType() == Material.BOWL)
			{
				Arrow a = p.launchProjectile(Arrow.class);
				a.setVelocity(p.getLocation().getDirection().multiply(6D));
				Arrow a1 = p.launchProjectile(Arrow.class);
				a1.setVelocity(p.getLocation().getDirection().multiply(6D));
				Arrow a2 = p.launchProjectile(Arrow.class);
				a1.setVelocity(p.getLocation().getDirection().multiply(6D));
				Arrow a3 = p.launchProjectile(Arrow.class);
				a1.setVelocity(p.getLocation().getDirection().multiply(4D));
				a.getWorld().playSound(a.getLocation(), Sound.EXPLODE, 10, 1);
				flameeffect.sendToLocation(a.getLocation());	
			}
			
			if(e.getItem().getType() == Material.WHEAT)
			{ 
				Arrow a = p.launchProjectile(Arrow.class);
				a.setVelocity(p.getLocation().getDirection().multiply(1D));
				Arrow a1 = p.launchProjectile(Arrow.class);
				a1.setVelocity(p.getLocation().getDirection().multiply(1D));
				p.getWorld().playSound(p.getLocation(), Sound.BAT_TAKEOFF, 10, 1);
				p.setVelocity(p.getEyeLocation().getDirection().multiply(4.0));
				cloudeffect.sendToLocation(p.getLocation());	
			}
			
			if(e.getItem().getType() == Material.BOOK)
			{ 
				Snowball a = p.launchProjectile(Snowball.class);
				a.setVelocity(p.getLocation().getDirection().multiply(5D));
				p.getWorld().playSound(p.getLocation(), Sound.FIRE_IGNITE, 10, 1);
				fireworkspark.sendToLocation(p.getLocation());	
			}
			
			if(e.getItem().getType() == Material.COAL)
			{ 
				Egg a = p.launchProjectile(Egg.class);
				a.setVelocity(p.getLocation().getDirection().multiply(2.5D));
				p.getWorld().playSound(p.getLocation(), Sound.PISTON_EXTEND, 10, 1);
				crit.sendToLocation(p.getLocation());	
			}
		}
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Snowball) {
			Snowball snowball = (Snowball) event.getDamager();
			Player damager = (Player) snowball.getShooter();
			Entity hitBySnowball = event.getEntity();
			if (hitBySnowball instanceof Player) {
				Player pl = (Player) hitBySnowball;
				pl.teleport(new Location(pl.getWorld(), pl.getLocation().getX(), pl.getLocation().getY() + 4, pl.getLocation().getZ()));
				damager.teleport(new Location(pl.getWorld(), pl.getLocation().getX(), pl.getLocation().getY() + 3, pl.getLocation().getZ() - 1));
				explosioneffectbig.sendToLocation(pl.getLocation());
				critmagic.sendToLocation(pl.getLocation());
				fireworkspark.sendToLocation(pl.getLocation());
				pl.getWorld().playSound(pl.getLocation(), Sound.SUCCESSFUL_HIT, 10, 1);
				pl.getWorld().playSound(pl.getLocation(), Sound.FIREWORK_BLAST, 10, 1);
				pl.getWorld().playSound(pl.getLocation(), Sound.ZOMBIE_WOODBREAK, 10, 1);
				pl.setFallDistance(-300f);
				damager.setFallDistance(-300f);
			}
			
		}
		if (event.getDamager() instanceof Egg) {
			Egg egg = (Egg) event.getDamager();
			Player damager = (Player) egg.getShooter();
			Entity hitByEgg = event.getEntity();
			if (hitByEgg instanceof Player) {
				Player pl = (Player) hitByEgg;
				Location loc = lookAt(pl.getLocation(), damager.getLocation());
				//pl.getLocation().setDirection(loc.getDirection());
				pl.teleport(loc);
				critmagic.sendToLocation(pl.getLocation());
				pl.getWorld().playSound(pl.getLocation(), Sound.PISTON_RETRACT, 10, 1);
				pl.setVelocity(pl.getEyeLocation().getDirection().multiply(4));
				pl.setFallDistance(-300f);
				damager.setFallDistance(-300f);
			}
			
		}
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		e.setCancelled(true);
	}

	
	
	//IDEA FOR ABILITY
	//for (Entity entity : player.getNearbyEntities(5D, 5D, 5D)){
	//entity.setVelocity(new Vector(0.0, 1.5, 0.0));
	//}
	

	
}
