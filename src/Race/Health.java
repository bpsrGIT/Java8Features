package Race;

import java.util.Random;

public enum Health {
	Healthy,
	Unwell;
	
	public static Health getRandomHealth() {
		
		Random r = new Random();
		
		return values()[r.nextInt(values().length)];
		
	}
}
