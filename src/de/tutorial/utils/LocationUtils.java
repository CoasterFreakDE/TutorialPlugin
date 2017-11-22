package de.tutorial.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtils {

	public static String loc2Str(Location loc) {
		String l = "";
		
		// world;10.0;4.0;12.4;127;-23
		
		l += loc.getWorld().getName() + ";";
		l += loc.getX() + ";";
		l += loc.getY() + ";";
		l += loc.getZ() + ";";
		l += loc.getYaw() + ";";
		l += loc.getPitch();
		
		return l;
	}
	
	public static Location str2Loc(String str) {
		String[] args = str.split(";");
		
		return new Location(Bukkit.getWorld(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Float.parseFloat(args[4]), Float.parseFloat(args[5]));
	}
	
}
