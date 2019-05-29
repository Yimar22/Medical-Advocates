package model;

public class Bacterium extends Disease{
	
	private Bacterium next;

	public Bacterium() {
		super(8, 30);
	}

	public Bacterium getNext() {
		return next;
	}

	public void setNext(Bacterium next) {
		this.next = next;
	}
	
	
}
