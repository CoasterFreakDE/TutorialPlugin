package de.tutorial.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.tutorial.command.MobSpawnerCommand;
import de.tutorial.command.TeamspeakCommand;
import de.tutorial.listener.ChatListener;
import de.tutorial.listener.MoveListener;
import de.tutorial.mobspawner.MobManager;

public class Main extends JavaPlugin {

	public static Main INSTANCE;
	public static String PREFIX;
	
	private MobManager mobManager;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		PREFIX = "§aTutorialPlugin §7> ";
		
		this.setMobManager(new MobManager());
		
		register();
		
		Bukkit.getConsoleSender().sendMessage(PREFIX + "§aPlugin aktiviert.");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(PREFIX + "§cPlugin deaktiviert.");
	}
	
	public void register() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new ChatListener(), this);
		pm.registerEvents(new MoveListener(), this);
		
		Bukkit.getPluginCommand("teamspeak").setExecutor(new TeamspeakCommand());
		Bukkit.getPluginCommand("mobspawner").setExecutor(new MobSpawnerCommand());
	}

	public MobManager getMobManager() {
		return mobManager;
	}

	public void setMobManager(MobManager mobManager) {
		this.mobManager = mobManager;
	}
}
