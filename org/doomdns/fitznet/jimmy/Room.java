package org.doomdns.fitznet.jimmy;
/* Matthew Fitzgerald 10/10/2019
 * Room - This class defines a room to be measured.
 */
public class Room {

double length;
double width;
//double height;

//Argument Constructor
public Room(double length, double width) {
	this.length = length;
	this.width = width;
}
//No Arg
public Room() {
	length = 0;
	width = 0;
}

//Setters
void setLength(double length) {this.length = length;}
void setWidth(double width) {this.width = width;}
//void setHeight(double height) {this.height = height;}

//Getters
double getLength() {return this.length;}
double getWidth() {return this.width;}
//double getHeight() {return this.height;}

//Methods

/*
 * @PARAM legnth - Length of the room being measured
 * @PARAM width - Width of the room being measured
 * @Return Double resulting in a measurement in square feet.
 */
public double getSqFoot() {return length*width;}
//public double getCubicFeet(){return length*width*height;}; 

}
