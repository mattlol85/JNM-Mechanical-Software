package org.doomdns.fitznet.jimmy;

import java.util.ArrayList;

/* Matthew Fitzgerald 10/10/2019
 * 
 * Class Home - Defines a list of rooms in the home
 */
public class Home {
	ArrayList<Room> rooms;
	String ownerFirst;
	String ownerLast;

	// No Arg Constructor
	public Home() {
	this.ownerFirst = "First Name";
	this.ownerLast = "Last Name";
	
	}

	// Copy Constructor
	public Home(Home copyHome) {
		this.ownerFirst = copyHome.getOwnerFirst();
		this.ownerLast = copyHome.getOwnerLast();
		this.rooms = copyHome.getRooms();
	}

	public Home(String firstName, String lastName) {
		this.ownerFirst = firstName;
		this.ownerLast = lastName;
	}

	// Setters
	void setOwnerFirst(String firstName) {
		this.ownerFirst = firstName;
	}

	void setOwnerLast(String lastName) {
		this.ownerLast = lastName;
	}

	void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	// Getters
	String getOwnerFirst() {
		return ownerFirst;
	}

	String getOwnerLast() {
		return ownerLast;
	}

	ArrayList<Room> getRooms() {
		return rooms;
	}

	// Methods
}
