package Race;

public class Horses {

	public String name;
	
	public Warcry warCry;

	public Health health;
	
	public Integer speed;

	public Integer distanceTravelled;
	
	public Horses(String name) {
		this.name = "horse"+name;
		this.health = Health.getRandomHealth();
		this.distanceTravelled = 0;
		this.warCry = Warcry.getRandomWarcry();
		this.speed = 0;
	}

	public void getDetails() {
		String details = "Name: " + name + ", Health: " + health + ", Distance Travelled: " + distanceTravelled + ".";
		System.out.println(details);
	}
	
}
