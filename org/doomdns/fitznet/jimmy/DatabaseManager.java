package org.doomdns.fitznet.jimmy;

import java.io.File;
import java.util.Scanner;

public class DatabaseManager{
File airUnitList;
File homeList;

public DatabaseManager(){
    this.airUnitList = new File("newAirUintList.txt");
    this.homeList = new File("newHomeslist.txt");
    //No clue why I did this, school got me messed up yo
}

//Argument constructor
public DatabaseManager(File airUnitList, File homeList){
    this.airUnitList = airUnitList;
    this.homeList = homeList;
}

//Setters

//Getters

//Methods
public void readAirSystemsIntoDatabase(){

}

public void readHomesListIntoDatabase(){

}
}