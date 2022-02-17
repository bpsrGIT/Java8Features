
package Race;

import static Race.RaceRunner.setHorses;
import static Race.RaceRunner.setHealthyHorses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

@FunctionalInterface
public interface _Functions {
	
	static Scanner scanner = new Scanner(System.in);
	
	public void set();
	
	public static void getTrackLength() {
		
		System.out.println("Please enter the track distance (meters):");
		
		Tracks.setDistance(scanner.nextInt());
		
		System.out.printf("Track distance is set to %d meters", Tracks.getDistance()).println();
		
	}
	
	public static void assignNoOfHorses(List<Horses> horses) {
		
		System.out.println("Please enter number of participating horses:");
		
		Integer numberOfHorses = scanner.nextInt();
		
		setHorses(generateHorsesList(numberOfHorses));
		
	}
	
	public static List<Horses> generateHorsesList(Integer num) {
		
		List<Horses> tempData = new ArrayList<>();
		
		for(int i = 0; i<= num; i++) {
			
			tempData.add(i, new Horses(""+i));
			
		}
		
		tempData.stream().forEach(e -> e.getDetails());
		
		return tempData;
		
	}
	
	public static void assignFinalRacers(List<Horses> horses) {
		
		List<Horses> healthyHorses = horses.stream()
				.filter(e -> e.health == Health.Healthy)
				.collect(Collectors.toList());
		
		healthyHorses.stream()
				.forEach(e -> e.name = e.name.toUpperCase());
		
		setHealthyHorses(healthyHorses);
		
	}
	
	public static Integer raceMove() {
		
		Random r = new Random();
		
		return r.nextInt(10 - 1) + 1;
		
	}
	
	public static void validatingRace(List<Horses> horses) {
		
		if(horses.size() < 2) {
			
			System.out.println("Not enough healthy horses to race. Try again next time.");
			
		} else {
			
			startRace(horses);
			
		}
	}
	
	public static void startRace(List<Horses> horses) {
		
		for (int i = 0; i < Tracks.getDistance(); i++) {
			
			Boolean winner = horses.stream().anyMatch(e -> e.distanceTravelled >= Tracks.getDistance());
			
			if(winner == true) {
				
				List<Horses> raceWinner = horses.stream().filter(e -> e.distanceTravelled >= Tracks.getDistance()).collect(Collectors.toList());
				
				raceWinner.stream().forEach(e -> won(e));
				
				break;
				
			} else {
				
				horses.stream().forEach(e -> racing(e));
				
			}
		};
	}
	
	public static void racing(Horses horse) {
		
		horse.speed = raceMove();
		
		Integer move = horse.speed + horse.distanceTravelled;
		
		horse.distanceTravelled = move;
		
		System.out.printf("%s moved %d meters with total distance travelled of %d meters", horse.name, horse.speed, horse.distanceTravelled).println();
		
		horse.speed = 0;
		
	}
	
	public static void won(Horses horse) {
		
		System.out.printf("%s won!", horse.name).println();
		
		System.out.printf("%s: '%s'", horse.name, horse.warCry).println();
		
		System.out.printf("Total distance travelled is %d", horse.distanceTravelled);
		
	}

	
}
