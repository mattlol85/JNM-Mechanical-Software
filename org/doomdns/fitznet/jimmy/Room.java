package org.doomdns.fitznet.jimmy;

import java.io.Serializable;

/* Matthew Fitzgerald 10/10/2019
 * Room - This class defines a room to be measured.
 */
public class Room implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -7625412539581512862L;
	double length;
	double width;
	// double height;

	// Argument Constructor
	public Room(double length, double width) {
		this.length = length;
		this.width = width;
	}

	// No Arg
	public Room() {
		length = 0;
		width = 0;
	}

	// Setters
	void setLength(double length) {
		this.length = length;
	}

	void setWidth(double width) {
		this.width = width;
	}
	// void setHeight(double height) {this.height = height;}

	// Getters
	double getLength() {
		return this.length;
	}

	double getWidth() {
		return this.width;
	}
	// double getHeight() {return this.height;}

	// Methods
	public double calculateBtu(){
		//Crude estimation for BTU required to cool room
		return (length*width)*20;
	}
	/*
	 * @PARAM legnth - Length of the room being measured
	 * 
	 * @PARAM width - Width of the room being measured
	 * 
	 * @Return Double resulting in a measurement in square feet.
	 */
	public double getSqFoot() {
		return length * width;
	}
	// public double getCubicFeet(){return length*width*height;};

	@Override
	public String toString() {
		String str = String.format("%-10s%-10s", length, width);
		return str;

	}
}
