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
	
	public Home(){

	}

	//No Arg Constructor
	public Home(String firstName, String lastName){
		this.ownerFirst = firstName;
		this.ownerLast = lastName;
	}
}
