package org.doomdns.fitznet.jimmy;

import java.util.ArrayList;

/* Matthew Fitzgerald 10/10/2019
 * 
 * Class Home - Defines a list of rooms in the home
 */
public class Home {
	ArrayList<Room> rooms;
	Person person;
	Address address;

	// No Arg Constructor
	public Home() {
	this.person = new Person();
	address = new Address();
	
	}

	// Copy Constructor
	public Home(Home copyHome) {
		this.rooms = copyHome.getRooms();
		this.address = copyHome.getAddress();
		this.person = copyHome.getPerson();
	}

	//Argument Constructor
	public Home(Person person,Address address) {
		this.person = person;
		this.address = address;
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
}
