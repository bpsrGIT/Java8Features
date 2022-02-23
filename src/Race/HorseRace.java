package Race;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HorseRace {
	Scanner scanner = new Scanner(System.in);
	Random r = new Random();
	
	public Integer distance = 0;
	
	
	public Integer noOfHorses;
	
	
	public void getTrackLength(Integer length) {
			System.out.println("Please enter the track distance (meters):");
			length = scanner.nextInt();
			distance = length;
			System.out.printf("Track distance is set to %d meters", distance).println();

	}
	
	
	public void assignNoOfHorses() {
			System.out.println("Please enter number of participating horses:");
			noOfHorses = scanner.nextInt();
	}
		
	
	public void startRace(List<Racer> horses) {
		if(horses.size() < 2) {
			System.out.println("Not enough healthy horses to race. Try again next time.");
		} else {
			start(horses);
		}
	}
	
	
	public void resultSummary(List<Racer> horses) {
		try {
			horses.stream().forEach(e ->
				System.out.printf("Total distance travelled of %s is %d meters", e.name, e.distanceTravelled).println());
		} catch (NullPointerException exception) {
			System.out.println("Matched NullPointerException");
			exception.printStackTrace();
		}

	}
	
	
	public void start(List<Racer> horses) {
		
		for (int i = 0; i < distance; i++) {
			
			Boolean winner = horses.stream().anyMatch(e -> e.distanceTravelled >= distance);
			
			if(winner == true) {List<Racer> raceWinner = horses.stream().filter(e -> e.distanceTravelled >= distance).collect(Collectors.toList());
					
				if(raceWinner.size() > 1) {
					Racer one = raceWinner.stream().sorted(new WinnerComparator()).findFirst().get();
					one.won();
					resultSummary(horses);
					break;
				} else {
					raceWinner.stream().forEach(e -> e.won());
					resultSummary(horses);
					break;
				}
			} else {
				horses.stream().forEach(e -> e.race());
			}
		};
	}
}