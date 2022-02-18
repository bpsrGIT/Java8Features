package Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Racer extends Horses{
	
	final static List<String> warCryList = new ArrayList<>() {{
		add("Vroom");
		add("Urrah");
		add("Banzai");
		add("Opps");
		add("Yeah");
		add(null);
		add(null);
		add(null);
	}};
	
	private String getRandomWarcry() {
		Random r = new Random();
		String randomWarCry = warCryList.get(r.nextInt(warCryList.size()));
		return randomWarCry;
	}
	
	public String warCry;

	public Racer(String name, Integer distance, Integer speed, Health health) {
		super(name, distance, speed, health);
		
		Optional<String> getWarCry = Optional.ofNullable(getRandomWarcry());
		
		this.warCry = getWarCry.orElse("No war cry");
	}
	
	public String toString() {
		String details = "Name: " + name + ", Health: " + health + ", Distance Travelled: " + distanceTravelled + ".";
		return details;
	}

}
