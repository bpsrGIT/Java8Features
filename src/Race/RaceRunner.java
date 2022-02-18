package Race;

public class RaceRunner extends Functions {
	
	public static void main(String[] args) {
		getTrackLength();
		assignNoOfHorses(ListHorses.getHorses());
		assignFinalRacers(ListHorses.getHorses());
		validatingRace(ListHorses.getHealthyHorses());
	}

}