package Race;

import java.util.ArrayList;
import java.util.List;

public class ListHorses {
	
	private static List<Racer> horses = new ArrayList<>();
	
	private static List<Racer> healthyHorses = new ArrayList<>();
	
	public static List<Racer> getHorses() {
		return horses;
	}

	public static void setHorses(List<Racer> horses) {
		ListHorses.horses = horses;
	}

	public static List<Racer> getHealthyHorses() {
		return healthyHorses;
	}

	public static void setHealthyHorses(List<Racer> healthyHorses) {
		ListHorses.healthyHorses = healthyHorses;
	}
}
