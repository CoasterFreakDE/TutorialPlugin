package de.tutorial.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.tutorial.main.Main;

public class MoveListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Main.INSTANCE.getMobManager().onMoved(e.getPlayer());
	}
	
}
