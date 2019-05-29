package model;

public class Disease {

	private int damage;
	private int health;
	
	public Disease(int damage, int health) {
		this.damage=damage;
		this.health=health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
	
}
