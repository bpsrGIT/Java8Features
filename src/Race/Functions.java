
package Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Functions extends ListHorses {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void getTrackLength() {
		System.out.println("Please enter the track distance (meters):");
		Tracks.setDistance(scanner.nextInt());
		System.out.printf("Track distance is set to %d meters", Tracks.getDistance()).println();
	}
	
	public static void assignNoOfHorses(List<Racer> horses) {
		System.out.println("Please enter number of participating horses:");
		Integer numberOfHorses = scanner.nextInt();
		setHorses(generateHorsesList(numberOfHorses));
	}
	
	public static List<Racer> generateHorsesList(Integer num) {
		List<Racer> tempData = new ArrayList<>();
		
		for(int i = 1; i<= num; i++) {
			Health health = Health.getRandomHealth();
			String name = "horse" + i;
			tempData.add(new Racer(name, 0, 0, health));
		}
		
		tempData.stream().forEach(e -> e.toString());
		return tempData;
	}
	
	public static void assignFinalRacers(List<Racer> horses) {
		
		List<Racer> healthyHorses = horses.stream()
				.filter(e -> e.health == Health.GOOD)
				.collect(Collectors.toList());
		
		healthyHorses.stream()
				.forEach(e -> e.name = e.name.toUpperCase());
		
		setHealthyHorses(healthyHorses);
		
	}
	
	public static Integer raceMove() {
		Random r = new Random();
		return r.nextInt(10 - 1) + 1;
	}
	
	public static void validatingRace(List<Racer> horses) {
		if(horses.size() < 2) {
			System.out.println("Not enough healthy horses to race. Try again next time.");
		} else {
			startRace(horses);
		}
	}
	
	public static void startRace(List<Racer> horses) {
		for (int i = 0; i < Tracks.getDistance(); i++) {
			
			Boolean winner = horses.stream().anyMatch(e -> e.distanceTravelled >= Tracks.getDistance());
			
			if(winner == true) {
				List<Racer> raceWinner = horses.stream().filter(e -> e.distanceTravelled >= Tracks.getDistance()).collect(Collectors.toList());
				raceWinner.stream().forEach(e -> won(e));
				horses.stream().forEach(e -> {
					System.out.printf("Total distance travelled of %s is %d meters", e.name, e.distanceTravelled).println();
				});
				break;
			} else {
				horses.stream().forEach(e -> race(e));
			}
		};
	}
	
	public static void race(Racer horse) {
		horse.speed = raceMove();
		Integer move = horse.speed + horse.distanceTravelled;
		horse.distanceTravelled = move;
		System.out.printf("%s moved %d meters with total distance travelled of %d meters", horse.name, horse.speed, horse.distanceTravelled).println();
		horse.speed = 0;
	}
	
	public static void won(Racer horse) {
		System.out.printf("%s won!", horse.name).println();
		System.out.printf("%s: '%s'", horse.name, horse.warCry).println();
	}
}