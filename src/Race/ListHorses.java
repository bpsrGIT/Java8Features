package Race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListHorses {
	
	private List<Racer> listOfRandomHorses;
	
	private List<Racer> listOfhealthyHorses;

	
	public List<Racer> getHealthyHorses() {
		return listOfhealthyHorses;
	}

	
	public void setHealthyHorses(List<Racer> horses) {
		List<Racer> healthyHorses = horses.stream()
				.filter(e -> e.health == Health.GOOD)
				.collect(Collectors.toList());
		
		healthyHorses.stream()
				.forEach(e -> e.name = e.name.toUpperCase());
		
		listOfhealthyHorses = healthyHorses;
	}

	
	public List<Racer> getListOfRandomHorses() {
		return listOfRandomHorses;
	}

	
	public void setListOfRandomHorses(Integer num) {
		List<Racer> raceHorsesPlaceholder = new ArrayList<>();
		
		for(int i = 1; i<= num; i++) {
			Integer initialValue = 0;
			Health health = Health.getRandomHealth();
			String name = "horse" + i;
			raceHorsesPlaceholder.add(new Racer(name, initialValue, initialValue, health));
		}
		
		raceHorsesPlaceholder.stream().forEach(e -> System.out.println(e.toString()));
		
		System.out.println();
		
		this.listOfRandomHorses = raceHorsesPlaceholder;
	}
}
