package org.doomdns.fitznet.jimmy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;   //ObIn
import java.io.ObjectOutputStream;  //Ob Out
import java.util.ArrayList;

/*
*This holds a master database of all the homes recorded
*in JNM Software.
*
*/
public class DatabaseManager {

    ArrayList<Home> homes;
    File homesDb;

    // Argument constructor
    public DatabaseManager(ArrayList<Home> homes, File homesDatabase) {
        this.homes = homes;
        this.homesDb = homesDatabase;
    }

    // Setters

    // Getters

    // Methods

    public void readHomesListIntoDatabase() {
        boolean continueReading = true;
        try {
            FileInputStream fileIn = new FileInputStream(homesDb);
            ObjectInputStream obInStream = new ObjectInputStream(fileIn);
            while (continueReading) {
                Home tempHome = (Home) obInStream.readObject();
                if (tempHome != null) {
                    homes.add(tempHome);
                } else {
                    continueReading = false;
                }
            }
            obInStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found Exception.");
        } catch (IOException e) {
            System.out.println("Error: IO Exception");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
    }
    //Return number of homes, Honestly i could just use
    //something like DatabaseManager.getHomes.size() but not
    //sure which is better
    public void writeHomesIntoDatabase(){
        //TODO Finish method !!!
        try{
            FileOutputStream fileOut = new FileOutputStream(homesDb);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            for(int i= 0; i < homes.size();i++){
                objectOut.writeObject(homes.get(i));
                System.out.println("Wrote " + (i+1) + " Home(s) to database.");
            }

            objectOut.close();
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found.");
        }catch(IOException e){
            System.out.println("Error: IO Exception.");
        }
    }
    public int getNumberOfHomes() {
        return homes.size();
    }
}