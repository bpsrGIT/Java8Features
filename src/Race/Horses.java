package Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Horses {

	final static List<String> warCryList = new ArrayList<>() {{
		add("Vroom");
		add("Urrah");
		add("Banzai");
		add("Opps");
		add("Yeah");
		add(null);
	}};
	
	public String getRandomWarcry() {

		Random r = new Random();
		
		String randomWarCry = warCryList.get(r.nextInt(warCryList.size()));
		
		return randomWarCry;
		
	}

	public String name;
	
	public String warCry;

	public Health health;
	
	public Integer speed;

	public Integer distanceTravelled;
	
	public Horses(String name) {
		this.name = "horse"+name;
		this.health = Health.getRandomHealth();
		this.distanceTravelled = 0;
		Optional<String> getWarCry = Optional.ofNullable(getRandomWarcry());
		this.warCry = getWarCry.orElse("No war cry");
		this.speed = 0;
	}

	public void getDetails() {
		String details = "Name: " + name + ", Health: " + health + ", Distance Travelled: " + distanceTravelled + ".";
		System.out.println(details);
	}
	
}
