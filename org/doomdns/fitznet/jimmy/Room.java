package org.doomdns.fitznet.jimmy;
/* Matthew Fitzgerald 10/10/2019
 * Room - This class defines a room to be measured.
 */
public class Room {

double length;
double width;

//Argument Constructor
public Room(double length, double width) {
	this.length = length;
	this.width = width;
}
//No Arg
public Room() {
	
}

//Setters
void setLength(double length) {this.length = length;}
void setWidth(double width) {this.width = width;}

//Getters
double getLength() {return this.length;}
double getWidth() {return this.width;}

//Methods
/*
 * @PARAM legnth - Length of the room being measured
 * @PARAM width - Width of the room being measured
 * @Return Double resulting in a measurement in square feet.
 */
double getSqFoot() {return length*width;}


/*
 * 
 */
}
