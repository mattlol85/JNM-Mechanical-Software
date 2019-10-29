package org.doomdns.fitznet.jimmy;

import java.util.ArrayList;
import java.io.Serializable;

/* Matthew Fitzgerald 10/10/2019
 * 
 * Class Home - Defines a list of rooms in the home
 */
public class Home implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -33894740830985938L;
	ArrayList<Room> rooms;
	Person person;
	Address address;

	// No Arg Constructor
	public Home() {
	this.person = new Person();
	address = new Address();
	rooms = new ArrayList<>();
	
	}

	// Copy Constructor
	public Home(Home copyHome) {
		this.rooms = copyHome.getRooms();
		this.address = copyHome.getAddress();
		this.person = copyHome.getPerson();
	}

	//Argument Constructor
	public Home(Person person,Address address, ArrayList<Room> rooms) {
		this.person = person;
		this.address = address;
		this.rooms = rooms;
	}

	/*****************************/

	// Setters

	void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	void setAddress(Address address){
		this.address = address;
	}
	void setPerson(Person person){
		this.person = person;
	}
	/*****************************/

	// Getters
	Person getPerson(){
		return person;
	}
	ArrayList<Room> getRooms() {
		return rooms;
	}

	Address getAddress(){
		return address;
	}

	/*****************************/

	// Methods
	@Override
	public String toString() {
		return person.toString() + address.toString();
	}
}
