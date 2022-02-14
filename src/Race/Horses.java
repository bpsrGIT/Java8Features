package Race;

import java.util.Random;

public class Horses {
	
	Random r = new Random();

	public static String[] randomWarCry = {"Vroooom", "Uurah!", "Banzai", "Dieu et Mon Droit", "Opps I did it again"};
	
	public static String[] randomHealth = {"Healthy", "Not well"};
	
	private static String name;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Horses.name = name;
	}
	
	private static String warCry;
	
	public static String getWarCry() {
		return warCry;
	}

	public static void setWarCry(String warCry) {
		Horses.warCry = warCry;
	}

	private static String health;
	
	public static String getHealth() {
		return health;
	}

	public static void setHealth(String health) {
		Horses.health = health;
	}
	
	private static Integer speed;
	
	public static Integer getSpeed() {
		return speed;
	}

	public static void setSpeed(Integer speed) {
		Horses.speed = speed;
	}

	private static Integer distanceTravelled;
	
	public static Integer getDistanceTravelled() {
		return distanceTravelled;
	}

	public static void setDistanceTravelled(Integer distanceTravelled) {
		Horses.distanceTravelled = distanceTravelled;
	}
	
	public Horses(String name) {
		setName(name);
		int randomIdx = r.nextInt(randomHealth.length);
		setHealth(randomHealth[randomIdx]);
		setDistanceTravelled(0);
		int randomWarCryIdx = r.nextInt(randomWarCry.length);
		setWarCry(randomWarCry[randomWarCryIdx]);
		setSpeed(0);
	}

	public static void getDetails() {
		String details = "Name: " + getName() + ", Health: " + getHealth() + ", Distance Travelled: " + getDistanceTravelled() + ".";
		System.out.println(details);
	}
}
