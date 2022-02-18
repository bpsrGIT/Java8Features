package Race;

import java.util.Random;

public enum Health {
	GOOD,
	BAD;
	
	public static Health getRandomHealth() {
		Random r = new Random();
		return values()[r.nextInt(values().length)];
	}
}