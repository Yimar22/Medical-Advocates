package model;

public class Patient{
	
	
	private Virus virus;
	private Bacterium bacterium;
	
	public Patient(){
		}


	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus) {
		this.virus = virus;
	}

	public Bacterium getBacterium() {
		return bacterium;
	}

	public void setBacterium(Bacterium bacterium) {
		this.bacterium = bacterium;
	}
	
	
	
	}
