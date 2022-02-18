package Race;

public class Horses {

	public String name;

	public Health health;
	
	public Integer speed;

	public Integer distanceTravelled;
	
	public Horses(String name, Integer distance, Integer speed, Health health) {
		this.name = name;
		this.health = health;
		this.distanceTravelled = distance;
		this.speed = speed;
	}

	public String toString() {
		String details = "Name: " + name + ", Health: " + health + ", Distance Travelled: " + distanceTravelled + ".";
		return details;
	}
	
}
