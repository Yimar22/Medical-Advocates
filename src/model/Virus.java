package model;

public class Virus extends Disease{
	
	private Virus next;

	public Virus() {
		super(15, 50);
	}

	public Virus getNext() {
		return next;
	}

	public void setNext(Virus next) {
		this.next = next;
	}
	
	
}
