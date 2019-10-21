package org.doomdns.fitznet.jimmy;

import java.io.File;
import java.util.Scanner;

public class DataTest {
    public static void main(String[] args) {
        File acData = new File("AirUnit.txt");
        System.out.println("Running DataTest\n");
        printFileInformation(acData);
    }
    //Provide information on the file
    public static void printFileInformation(File file) {
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("Does File Exist?: " + file.exists());
    }
}
