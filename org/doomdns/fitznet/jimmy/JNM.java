package org.doomdns.fitznet.jimmy;

import java.util.*;
//import java.io.*;

public class JNM {
static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
	System.out.println("JNM_Mechanical BTU Measurement System.");
	System.out.println("Version 1.0.0");
	System.out.println();
	
	System.out.println("Enter Length.");
	double length = in.nextDouble();
	
	System.out.println("Enter Width.");
	double width = in.nextDouble();
	
	Room room = new Room(length,width);
	System.out.println(room.getSqFoot() + " Sq.Ft");
	}

}
