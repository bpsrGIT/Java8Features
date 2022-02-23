package Race;

public class RaceRunner {
	
	public static void main(String[] args) {
		
		ListHorses gameHorses = new ListHorses();
		
		Tracks venue = new Tracks();
		
		HorseRace game = new HorseRace();
		
		game.getTrackLength(venue.distance);
		
		game.assignNoOfHorses();
		
		gameHorses.setListOfRandomHorses(game.noOfHorses);
		
		gameHorses.setHealthyHorses(gameHorses.getListOfRandomHorses());
		
		game.startRace(gameHorses.getHealthyHorses());
		
	}
}