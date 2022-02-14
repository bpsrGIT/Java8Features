package Race;

import java.util.List;
import java.util.Scanner;

public class RaceRunner {
	
	static Scanner scanner = new Scanner(System.in);
	
	private static List<Horses> getHorses(String name) {
		return List.of(
			new Horses(name)
		);
	}
	
	private static List<Horses> healthyHorses;

	public static void main(String[] args) {
		
		Functions race = () -> {
			System.out.println("Please enter the track distance (meters):");
			
			Tracks.setDistance(scanner.nextInt());
			
			System.out.printf("Track distance is set to %d meters", Tracks.getDistance()).println();
			
			System.out.println("Please enter number of participating horses:");
			
			Integer numberOfHorses = scanner.nextInt();
			
			for(int i = 0; i < numberOfHorses; i++) {
				String name = "horse" + i;
				
				getHorses(name);
				
				Horses.getDetails();
				
				if(Horses.getHealth() == "Not well") {
					System.out.println(Horses.getName() + " is not feeling well and will not be allowed to join the race");
				} else {
					System.out.println(Horses.getName() + " is ready to race!");
				}
				
			}
		};
		
		race.set();

	}

}
