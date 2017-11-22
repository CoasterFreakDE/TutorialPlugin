package de.tutorial.mobspawner;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.tutorial.utils.FileConfig;
import de.tutorial.utils.LocationUtils;

public class MobManager {

	private List<Mobspawner> mobspawner;
	
	public MobManager() {
		this.setMobspawner(new ArrayList<Mobspawner>());
		setup();
	}
	
	
	public void setup() {
		FileConfig mobspawner = new FileConfig("Tutorial", "mobspawner.yml");
		
		for(String id : mobspawner.getKeys(false)) {
			this.getMobspawner().add(new Mobspawner(LocationUtils.str2Loc(mobspawner.getString(id + ".location")), mobspawner.getString(id + ".entity")));
		}
	}
	
	public void setMobspawner(String id, Location loc, String entity) {
		FileConfig mobspawner = new FileConfig("Tutorial", "mobspawner.yml");
		
		mobspawner.set(id + ".location", LocationUtils.loc2Str(loc));
		mobspawner.set(id + ".entity", entity);
		mobspawner.saveConfig();
		
		this.getMobspawner().add(new Mobspawner(loc, entity));
	}
	
	public void deleteMobspawner(String id) {
		FileConfig mobspawner = new FileConfig("Tutorial", "mobspawner.yml");
		if(mobspawner.contains(id)) {
			mobspawner.set(id, null);
			mobspawner.saveConfig();
			reload();
		}
	}
	
	public void reload() {
		this.getMobspawner().clear();
		this.setup();
	}

	public List<Mobspawner> getMobspawner() {
		return mobspawner;
	}

	public void setMobspawner(List<Mobspawner> mobspawner) {
		this.mobspawner = mobspawner;
	}

	public void onMoved(Player p) {
		for(Mobspawner ms : this.getMobspawner()) {
			if(ms.getLoc().distance(p.getLocation()) <= 5.0d) {
				if(!ms.isTriggered()) {
					ms.spawn();
				}
			}
			else {
				if(ms.isTriggered()) {
					ms.setTriggered(false);
				}
			}
		}
	}
}
