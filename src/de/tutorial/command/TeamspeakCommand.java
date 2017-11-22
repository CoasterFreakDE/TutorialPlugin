package de.tutorial.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.tutorial.main.Main;

public class TeamspeakCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String string, String[] args) {
		
		s.sendMessage(Main.PREFIX + "§dUnser Teamspeak");
		s.sendMessage(Main.PREFIX + "    §emeinserver.de");
		
		return true;
	}

}
