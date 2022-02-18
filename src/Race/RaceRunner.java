package Race;

public class RaceRunner extends Functions {
	
	public static void main(String[] args) {
		getTrackLength();
		assignNoOfHorses();
		validatingRace(ListHorses.getHealthyHorses());
	}

}