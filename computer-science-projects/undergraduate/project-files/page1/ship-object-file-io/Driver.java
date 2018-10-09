import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Lecture #3 -- File I/O
 * The purpose of this program is to use utilize classes, and file i/o
 * Write a program that creates 250 different ships.
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 11, 2018
 * @author Joseph Hentges
 */

/**
 * The Driver.java file will run the program.
 */
public class Driver {
    
    /**
     * This is where all the methods are called and run through.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] shipNames = getShipNames("ShipNames.txt");
        Ship[] fleet = getAllShips(shipNames);
        documentShips(fleet, "MyFleet.txt");
    }
    
    /**
     * Print out each ship, and write their data to a text file.
     * The ship documentation formating is in the toString method in Ship.java
     * @param fleet : Ship[] - The array of ship objects
     * @param outputFileName : String - The name of the file I'm outputting to
     */
    public static void documentShips(Ship[] fleet, String outputFileName) throws FileNotFoundException
    {
        File output = new File(outputFileName); //Open the file
        PrintWriter outWriter = new PrintWriter(output); //Create a writer for the file
        //Run through the fleet of ships and write them to the file.
        for(int i = 0; i < fleet.length; i++)
        {
            System.out.println("Ship Number: " + (i+1) + " | " + fleet[i].toString());
            outWriter.println(fleet[i].toString());
        }
        outWriter.close(); //close the opened file.
    }
    
    /**
     * Create as many ships as there are names (251), and return the fleet.
     * @param shipNames : String[] - An array of ship names.
     * @return fleet : Ship[] - An array of Ship objects.
     */
    public static Ship[] getAllShips(String[] shipNames)
    {
        Ship[] fleet = new Ship[shipNames.length-1]; //Create an empty array for Ships (shipNames contains 251 names, so remove 1 to make it exactly 250)
        //Create three variables used in the create of ships. Will be filled with random values
        double tonnage;
        int speed;
        int distance;
        for(int i = 0; i < fleet.length; i++)
        {
            Random gen = new Random();//Create a generator for random values
            tonnage = 100.0 + (100000.0 - 100.0) * gen.nextDouble(); //Random double (100.0 to 100,000.0)
            speed = gen.nextInt(100)+1; //Random integer (1 - 100)
            distance = gen.nextInt(2000); //Random integer (0 - 2000)
            fleet[i] = createShip(shipNames[i], tonnage, speed, distance); //Add the ship to the fleet
        }
        return fleet;
    }
    
    /**
     * With the passed in values, create and return a ship object.
     * @param name : String
     * @param tonnage : double
     * @param speed : int
     * @param distance : distance
     * @return 
     */
    public static Ship createShip(String name, double tonnage, int speed, int distance)
    {
        Ship newShip = new Ship();
        newShip.setShipName(name);
        newShip.setMaxTonnage(tonnage);
        newShip.setMaxSpeed(speed);
        newShip.setDistance(distance);
        return newShip;
    }
    
    /**
     * Method to grab all of the values in the passed in text file.
     * Places them into a String array, and returns it.
     * @param fileName : String
     * @return String[] shipNames : String[] containing all the values in the passed in txt file.
     * @throws FileNotFoundException 
     */
    public static String[] getShipNames(String fileName) throws FileNotFoundException
    {
        ArrayList<String> shipNamesArray = new ArrayList<String>(); //Create a ArraList for Strings
        Scanner dataReader = new Scanner(new File(fileName)); //Create dataReader to read the values in the txt file
        //While loop to run through all lines in the text file, and adding them to the array list
        while(dataReader.hasNext())
        {
            String line = dataReader.nextLine();
            shipNamesArray.add(line);
        }
        dataReader.close(); //Close the opened file
        String[] shipNames = new String[shipNamesArray.size()]; //Create an array of strings
        return shipNamesArray.toArray(shipNames); //pass the values in the arrayList to the strings, and return
    }
}
