package de.tutorial.command;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import de.tutorial.main.Main;

public class MobSpawnerCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String name, String[] args) {
		
		if(s instanceof Player) {
			Player p = (Player) s;
			
			if(p.hasPermission(new Permission("tutorial.mobspawner", PermissionDefault.OP))) {
				// /mobspawner id Entity
				// /mobspawner id delete
				
				if(args.length == 2) {
					String id = args[0];
					String entity = args[1];
					
					if(entity.equalsIgnoreCase("delete")) {
						Main.INSTANCE.getMobManager().deleteMobspawner(id);
						p.sendMessage(Main.PREFIX + "§aMobspawn §e" + id + " §agelöscht.");
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 80, 80);
						return true;
					}
					
					if(EntityType.fromName(entity) != null) {
						Main.INSTANCE.getMobManager().setMobspawner(id, p.getLocation(), entity);
						p.sendMessage(Main.PREFIX + "§aMobspawn §e" + id + " §agesetzt.");
						p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 80, 80);
					}
					else {
						p.sendMessage(Main.PREFIX + "§cDieses Entity existert nicht.");
					}
				}
				else {
					p.sendMessage(Main.PREFIX + "§7§oBitte benutze §e/mobspawner id Entity");
				}
			}
			else {
				p.sendMessage(Main.PREFIX + "§cDu hast keine Berechtigungen für dieses Command.");
			}
		}
		else {
			s.sendMessage(Main.PREFIX + "§cNur für Spieler.");
		}
		
		return true;
	}

}
