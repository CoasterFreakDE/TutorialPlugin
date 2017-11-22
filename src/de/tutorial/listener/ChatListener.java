package de.tutorial.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(p.isOp()) {
			e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
		}
		
		e.setFormat("§a%s§e: §7%s");
	}
	
}
