package de.tutorial.mobspawner;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class Mobspawner {

	private boolean triggered;
	private Location loc;
	private String entity;
	
	public Mobspawner(Location loc, String entity) {
		this.setTriggered(false);
		this.setLoc(loc);
		this.setEntity(entity);
	}

	public boolean isTriggered() {
		return triggered;
	}

	public void setTriggered(boolean triggered) {
		this.triggered = triggered;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	@SuppressWarnings("deprecation")
	public void spawn() {
		if(!this.isTriggered()) {
			loc.getWorld().spawnEntity(loc, EntityType.fromName(getEntity()));
			setTriggered(true);
		}
	}
}
