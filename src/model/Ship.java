package model;

public class Ship {
	
	public final static double MAX_HEALTH =100;
	
	private double health;
	
	private Laser next;
	
	public Ship(double health){
		health=MAX_HEALTH;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public Laser getNext() {
		return next;
	}

	public void setNext(Laser next) {
		this.next = next;
	}
	
	
	
	
	
}
