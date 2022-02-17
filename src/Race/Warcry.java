package Race;

import java.util.Random;

public enum Warcry {
	Vroom,
	Urrah,
	Banzai,
	Opps,
	Yeah;
	
	public static Warcry getRandomWarcry() {
		Random r = new Random();
		return values()[r.nextInt(values().length)];
	}
}
