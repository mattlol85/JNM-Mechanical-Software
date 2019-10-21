package org.doomdns.fitznet.jimmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/*
					To Do List
TODO Write objects in a binary file
TODO Read and edit objects in the file
TODO Clean Code and remove unused methods
TODO Prepare for merge to master branch
TODO Obtain basic running state of program
TODO Idiot proof the inputs, make sure everything thats written cant be broken
TODO Create and run Idiot-Proofing Test




*/
public class JNM {
	public static void main(String[] args) throws Exception {
		char choice;
		boolean not_done = true; // Control Loop Flag
		//Main home local database storage
		ArrayList<Home> homes = new ArrayList<>();
		//Test case file to quickly test
		File testCaseFile = new File("testCases.txt");
		//Scanner for human input
		// Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(testCaseFile);
		//Database Manager to load data
		DatabaseManager databaseManager = new DatabaseManager(homes, new File("database.dat"));
		databaseManager.readHomesListIntoDatabase();
		

		System.out.println("JNM_Mechanical BTU Measurement System.");
		System.out.println("Version 1.0.0\n");

		do {
			menu();
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
				System.out.println("Change Home information ADD THIS MOOK");
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

		System.out.println("Enter Length.");
		double length = Double.parseDouble(in.nextLine());

		System.out.println("Enter Width.");
		double width = Double.parseDouble(in.nextLine());

		Room room = new Room(length, width);
		System.out.println(room.getSqFoot() + " Sq.Ft");
		System.out.println(calculateBtu(room.getSqFoot()) + " BTU Required.");
	}

	/*
	 * addHome() adds a new home to the arrayList.
	 *
	 */
	private static void addHome(ArrayList<Home> homes, Scanner in) {
		homes.add(createNewHome(in));
	}

	// This just displays the main menu on the main loop
	private static void menu() {
		System.out.println();
		System.out.println("Select one of the following transactions:");
		System.out.println("\t****************************");
		System.out.println("\t          Main Menu   ");
		System.out.println("\t****************************");
		System.out.println("\t     C -- Quick Calculator");
		System.out.println("\t     H -- Add Home");
		System.out.println("\t     A -- Add New Air System");
		System.out.println("\t     E -- Edit/Change Air System");
		System.out.println("\t     R -- Change Home Information\n");
		System.out.println("\t     Q -- Quit Application\n");
		System.out.print("\tEnter your selection:\n");
		System.out.println("");
	}

	// Crude Estimate of BTU Calculation
	// TODO find better way to evaluate BTU usage
	static double calculateBtu(double sqFoot) {
		return sqFoot * 20;
	}

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

	// Testing method to verify toString is working properly
	static void testToString(Home testHome) {
		System.out.println("Home.toString: \n" + testHome.toString());
		System.out.println("Address.toString: " + testHome.getAddress().toString());
		System.out.println("Person.toString: " + testHome.getPerson().toString());
		for (int i = 0; i < testHome.getRooms().size(); i++)
			System.out.println("Room #" + (i + 1) + " " + testHome.getRooms().get(i).toString());
	}
	static void writeHomeToDatabase(ArrayList<Home> homeDb){
		//TODO Finish FIRST
		File dbFile = new File("datbase.dat");
		try{
		FileOutputStream fileOut = new FileOutputStream(dbFile);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		//Write Every home to file
		for (int i = 0 ; i < homeDb.size(); i++){
			
		}

		}catch(FileNotFoundException e){
			System.out.println("Error: File not found.");
		}catch(IOException e){
			System.out.println("Error: Object stream error.");
		}
	}
	static void readHomeFromDatase(){

	}
}
