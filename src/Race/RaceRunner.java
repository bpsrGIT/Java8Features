package Race;

import java.util.ArrayList;
import java.util.List;

public class RaceRunner {
	
	private static List<Horses> horses = new ArrayList<>();
	
	private static List<Horses> healthyHorses = new ArrayList<>();
	
	public static List<Horses> getHorses() {
		return horses;
	}

	public static void setHorses(List<Horses> horses) {
		RaceRunner.horses = horses;
	}

	public static List<Horses> getHealthyHorses() {
		return healthyHorses;
	}

	public static void setHealthyHorses(List<Horses> healthyHorses) {
		RaceRunner.healthyHorses = healthyHorses;
	}
	
	
	public static void main(String[] args) {
		
		_Functions race = () -> {
			
			_Functions.getTrackLength();
			
			_Functions.assignNoOfHorses(getHorses());
			
			_Functions.assignFinalRacers(getHorses());
			
			_Functions.validatingRace(getHealthyHorses());
			
		};
		
		race.set();
		
	}

}