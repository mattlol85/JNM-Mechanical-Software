package org.doomdns.fitznet.jimmy;

import java.util.*;
import java.io.*;

public class JNM {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		char choice;
		boolean not_done = true; // Control Loop Flag
		ArrayList<Home> homeList = new ArrayList<>();

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
				quickCalc();
				break;
			case 'h':
			case 'H':
				addHome(in);
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
	private static void quickCalc() {

		System.out.println("Enter Length.");
		double length = in.nextDouble();

		System.out.println("Enter Width.");
		double width = in.nextDouble();

		Room room = new Room(length, width);
		System.out.println(room.getSqFoot() + " Sq.Ft");
	}

	/*
	 * addHome() adds a new home to the database.
	 *
	 */
	private static void addHome(Scanner in) {
		// TODO Account for new person class
		Home newHome = new Home();
		System.out.println("Client Information Input Screen.\n");

		System.out.println("Enter Client First Name.");
		String firstName = in.nextLine();

		System.out.println("Enter Clients Last Name.");
		String lastName = in.nextLine();

		System.out.println("Enter clients E-Mail address.");
		String email = in.nextLine();
		// Create New Person object
		Person newPerson = new Person(firstName, lastName, email);

		System.out.println("Enter Street Name & Number.\n");
		String streetAddress = in.nextLine();

		System.out.println("Enter City.");
		String city = in.nextLine();

		System.out.println("Enter State.");
		String state = in.nextLine();

		System.out.println("Enter zip code.");
		String zip = in.nextLine();

		Address newAddress = new Address(streetAddress, city, state, zip);
		newHome = new Home(newPerson, newAddress);
		System.out.println(newHome.toString());
		// street, city, state ,zip
		// TODO check to see if the client is already listed.
	}

	private static void loadDatabases() {
		// TODO Add these
		System.out.println("Loading Databse...");

		File airUnitData = new File("AirUnit.txt");
		File homeList = new File("homeList.txt");
		//If the files dont exist, make new ones
		try {
			if (!airUnitData.exists()) {
				airUnitData.createNewFile();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (!homeList.exists()) {
				homeList.createNewFile();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
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

}
