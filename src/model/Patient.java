package model;

//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to create and Patients
	 *@author Yimar Tamayo
	 *@version V0.1_2019
	 */

public class Patient{
	
	//Attributes_________________________________________________________________________________________________________________________________________

	
	private Virus virus;
	private Bacterium bacterium;
	
	public Patient(){
		}

	/**
	 * This method returns Virus  <br><br>
	 * <b>Pre: </b> The current Virus must not be null <br><br>
	 * @return An object of type Virus that represents a disease <br><br>
	 */
	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus) {
		this.virus = virus;
	}
	
	/**
	 * This method returns Bacterium  <br><br>
	 * <b>Pre: </b> The current Bacterium must not be null <br><br>
	 * @return An object of type Bacterium that represents a disease <br><br>
	 */

	public Bacterium getBacterium() {
		return bacterium;
	}

	public void setBacterium(Bacterium bacterium) {
		this.bacterium = bacterium;
	}
	
	
	
	}
