package org.doomdns.fitznet.jimmy;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/*
					To Do List
TODO Read and edit objects in the file
TODO Prepare for merge to master branch
TODO Obtain basic running state of program
TODO Idiot proof the inputs, make sure everything thats written cant be broken
TODO Create and run Idiot-Proofing Test
TODO find better way to evaluate BTU usage

*/

public class JNM {
	public static void main(String[] args) throws Exception {
		char choice;
		boolean not_done = true; // Control Loop Flag
		// Main home local database storage
		ArrayList<Home> homes = new ArrayList<>();
		// Test case file to quickly test
		//File testCaseFile = new File("testCases.txt");
		// Scanner for human input
		Scanner in = new Scanner(System.in);
		// Scanner in = new Scanner(testCaseFile);
		// Database Manager to load data
		DatabaseManager databaseManager = new DatabaseManager(homes, new File("database.dat"));
		databaseManager.readHomesListIntoDatabase();
		
		GUI gui = new GUI();

		System.out.println("JNM_Mechanical BTU Measurement System.");
		System.out.println("Version 1.0.0\n");

		do {
			showMenu();
			choice = in.next().charAt(0);
			switch (choice) {
			case 'q':
			case 'Q':
				databaseManager.writeHomesIntoDatabase();
				not_done = false;
				break;
			case 'c':
			case 'C':
				quickCalc(in);
				break;
			case 'h':
			case 'H':
				addHome(homes, in);
				break;
			case 'r':
			case 'R':
			//TODO Add this method
				System.out.println("Change Home information ADD THIS MOOK");
				break;
			case 'e':
			case 'E':
				editDataEntry(homes, in);
				break;
			case 'p':
			case 'P':
				System.out.println("Add This method");
			default:
				System.out.println("|********************************************|");
				System.out.println("Error: " + choice + " is an invalid selection -  try again");
				System.out.println("|********************************************|");
				System.out.println("");
				break;
			}

		} while (not_done);

		// Close resources
		in.close();
		System.out.println("Exiting.");
		System.exit(0);
	}

	/*
	 * QuickCalc() is a quick calculator for quickly estimating the BTU required to
	 * cool the room
	 */
	private static void quickCalc(Scanner in) {
		Room tempRoom = createNewRoom(in);
		System.out.println(tempRoom.calculateBtu() + "BTU Required.");
	}

	/***********************************************/
	/* OBJECT CREATION */

	// Creates a new Person object with prompts
	static Person createNewPerson(Scanner in) {
		System.out.println("Enter Client First Name.");
		String firstName = in.next();

		System.out.println("Enter Clients Last Name.");
		String lastName = in.next();

		System.out.println("Enter clients E-Mail address.");
		String email = in.next();
		// Create New Person object
		Person newPerson = new Person(firstName, lastName, email);
		in.nextLine();
		return newPerson;
	}

	// Creates new room object with prompts
	static Room createNewRoom(Scanner in) {
		Room newRoom;
		System.out.println("Enter Length.");
		double length = Double.parseDouble(in.next());

		System.out.println("Enter Width.");
		double width = Double.parseDouble(in.next());

		newRoom = new Room(length, width);
		return newRoom;
	}

	// Creates new address object, with prompts
	static Address createNewAddress(Scanner in) {

		System.out.println("Enter Street Name & Number.");
		String streetAddress = in.nextLine();

		System.out.println("Enter City.");
		String city = in.nextLine();

		System.out.println("Enter State.");
		String state = in.nextLine();

		System.out.println("Enter zip code.");
		String zip = in.nextLine();

		Address newAddress = new Address(streetAddress, city, state, zip);
		return newAddress;
	}

	// This method creates a new Home object with prompts.
	static Home createNewHome(Scanner in) {

		System.out.println("How many rooms need to be cooled?");
		int numRooms = in.nextInt();
		// Create empty array of rooms
		ArrayList<Room> roomList = new ArrayList<>();

		for (int i = 0; i < numRooms; i++) {
			System.out.println("ROOM #" + (i + 1));
			roomList.add(createNewRoom(in));
		}
		Home newHome = new Home(createNewPerson(in), createNewAddress(in), roomList);
		return newHome;
	}

	/***********************************************/
	/* METHODS */

	static void showMenu() {
		// This just displays the main menu on the main loop

		System.out.println();
		System.out.println("Select one of the following transactions:");
		System.out.println("\t****************************");
		System.out.println("\t          Main Menu   ");
		System.out.println("\t****************************");
		System.out.println("\t     C -- Quick Calculator");
		System.out.println("\t     H -- Add Home");
		System.out.println("\t     A -- Add New Air System");
		System.out.println("\t     E -- Edit Item/Home");
		System.out.println("\t     Q -- Quit Application\n");
		System.out.print("\tEnter your selection:\n");
		System.out.println("");
	}

	static void showEditMenu() {
		System.out.println();
		System.out.println("Select one of the following edit options:");
		System.out.println("\t****************************");
		System.out.println("\t          Editor Menu   ");
		System.out.println("\t****************************");
		System.out.println("\t     P -- Edit Person");
		System.out.println("\t     H -- Edit Home");
		System.out.println("\t     A -- Edit Address");
		System.out.println("\t     E -- Edit/Change Air System");
		System.out.println("\t     Q -- Quit Edit Menu\n");
		System.out.print("\tEnter your selection:\n");
		System.out.println("");
	}

	static void addHome(ArrayList<Home> homes, Scanner in) {
		/*
		 * addHome() adds a new home to the arrayList.
		 *
		 */
		homes.add(createNewHome(in));
	}

	/**
	 * This method will ask the user which kind of object they need to edit and will
	 * provied ways to change and search for an item.
	 * 
	 * @param homes - Arraylist of homes
	 * @param in    - Scanner System.in
	 */
	static void editDataEntry(ArrayList<Home> homes, Scanner in) {
		char choice;
		boolean not_done = true;
		do {
			showEditMenu();
			choice = in.next().charAt(0);
			switch (choice) {

				case 'q':
				case 'Q':
				not_done = false;
				break;
			default:
				System.out.println("|********************************************|");
				System.out.println("Error: " + choice + " is an invalid selection -  try again");
				System.out.println("|********************************************|\n");
				break;
			}

		} while (not_done);
	}


	/***********************************************/
	/* TESTING METHODS */
	// Testing method to verify toString is working properly
	static void testToString(Home testHome) {
		System.out.println("Home.toString: \n" + testHome.toString());
		System.out.println("Address.toString: " + testHome.getAddress().toString());
		System.out.println("Person.toString: " + testHome.getPerson().toString());
		for (int i = 0; i < testHome.getRooms().size(); i++)
			System.out.println("Room #" + (i + 1) + " " + testHome.getRooms().get(i).toString());
	}

}
