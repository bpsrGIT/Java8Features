package Race;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Racer extends Horses{
	
	Random r = new Random();
	
	final static List<String> WAR_CRY_LIST = 
			Arrays.asList("Vroom", "Urrah", "Banzai", "Opps", "Yeah", null, null, null);
	
	
	public String getRandomWarcry() {
		String randomWarCry = WAR_CRY_LIST.get(r.nextInt(WAR_CRY_LIST.size()));
		return randomWarCry;
	}
	
	
	public String warCry;

	
	public Racer(String name, Integer distance, Integer speed, Health health) {
		super(name, distance, speed, health);
		
		Optional<String> getWarCry = Optional.ofNullable(getRandomWarcry());
		
		this.warCry = getWarCry.orElse("No war cry");
	}
	
	
	public void race() {
		speed = r.nextInt(10 - 1) + 1;
		Integer move = speed + distanceTravelled;
		distanceTravelled = move;
		System.out.printf("%s moved %d meters with total distance travelled of %d meters", name, speed, distanceTravelled).println();
		speed = 0;
	}
	
	
	public void won() {
		System.out.printf("%s won!", name).println();
		System.out.printf("%s: '%s'", name, warCry).println();
	}
}
