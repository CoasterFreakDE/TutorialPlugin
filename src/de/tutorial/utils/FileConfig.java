package de.tutorial.utils;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileConfig extends YamlConfiguration {

	public String path;
	public String separator;
	
	public FileConfig(String folder, String fileName) {
		separator = System.getProperty("file.separator");
		path = "plugins" + separator + folder + separator + fileName;
		
		try {
			load(path);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void saveConfig() {
		try {
			save(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
