package org.doomdns.fitznet.jimmy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class JNM {
	public static void main(String[] args) throws Exception{
		char choice;
		boolean not_done = true; // Control Loop Flag
		ArrayList<Home> homes = new ArrayList<>();
		File testCaseFile = new File("testCases.txt");
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(testCaseFile);
		//DatabaseManager databaseManager = new DatabaseManager(homes);

		loadDatabases();

		System.out.println("JNM_Mechanical BTU Measurement System.");
		System.out.println("Version 1.0.0\n");

		do {
			menu();
			choice = in.next().charAt(0);
			switch (choice) {
			case 'q':
			case 'Q':
				not_done = false;
				break;
			case 'c':
			case 'C':
				quickCalc(in);
				break;
			case 'h':
			case 'H':
				addHome(homes,in);
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

	private static void loadDatabases() {
		// TODO Add these
		System.out.println("Loading Databse...");

		// File airUnitData = new File("AirUnit.txt");
		// First Load Up the Homes Database
		File homeList = new File("homes.txt");
		// If the files dont exist, make new ones
		try { // TODO Remove or Redo
			if (!homeList.exists()) {
				homeList.createNewFile();
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File Not Found.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// This just displays the main menu on the main loop
	private static void menu() {
		System.out.println();
		System.out.println("Select one of the following transactions:");
		System.out.println("\t****************************");
		System.out.println("\t    List of Choices         ");
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

	/*
	 * Writes the database to the file
	 */
	static void writeDatabase(ArrayList<Home> homesDatabase) {
		// Set the homes file
		File homes = new File("homes.txt");
		// Set up printWriter on the new file

		try {
			PrintWriter printer = new PrintWriter(homes);
			for (int i = 0; i < homes.length(); i++) {

			}
		} catch (IOException e) {
			System.err.println("IO Exception.");
		}

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

	// Creates new room with prompts
	static Room createNewRoom(Scanner in) {
		Room newRoom;
		System.out.println("Enter Length.");
		double length = Double.parseDouble(in.next());

		System.out.println("Enter Width.");
		double width = Double.parseDouble(in.next());

		newRoom = new Room(length, width);
		return newRoom;
	}

	// OVERLOADED !
	// This version creates everything with the text for the user.
	static Home createNewHome(Scanner in) {

		System.out.println("How many rooms need to be cooled?");
		int numRooms = in.nextInt();
		// Create empty array of rooms
		ArrayList<Room> roomList = new ArrayList<>();

		for (int i = 0; i < numRooms; i++) {
			System.out.println("ROOM #" + i+1);
			roomList.add(createNewRoom(in));
		}
		Home newHome = new Home(createNewPerson(in), createNewAddress(in), roomList);
		System.out.println(newHome.toString());
		return newHome;
	}

	static Address createNewAddress(Scanner in) {

		System.out.println("Enter Street Name & Number.\n");
		String streetAddress = in.nextLine();

		System.out.println("Enter City.");
		String city = in.next();

		System.out.println("Enter State.");
		String state = in.next();

		System.out.println("Enter zip code.");
		String zip = in.nextLine();

		Address newAddress = new Address(streetAddress, city, state, zip);
		return newAddress;
	}

}
