package model;

public class Boss extends Disease{
	
	private Boss next;

	public Boss() {
		super(35, 200);
	}

	public Boss getNext() {
		return next;
	}

	public void setNext(Boss next) {
		this.next = next;
	}
	
	
}
