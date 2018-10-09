/**
 * Lecture #3 -- File I/O
 * The purpose of this program is to use utilize classes, and file i/o
 * Write a program that creates 250 different ships.
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 11, 2018
 * @author Joseph Hentges
 */
public class Ship {
    
    //Variables used in the creation of each ship
    private String shipName;     //The name of the ship
    private double maxTonnage;   //The max tonnage the ship can hold
    private int maxSpeed;        //The ships max speed
    private int distance;        //The distance the ship is from its desired destination

    /**
     * Get the name of the ship
     * @return shipName : String
     */
    public String getShipName() 
    {
        return shipName;
    }

    /**
     * Set the name of the ship.
     * @param shipName : String
     */
    public void setShipName(String shipName) 
    {
        this.shipName = shipName;
    }

    /**
     * Get the maxTonnage of the ship
     * @return maxTonnage : double
     */
    public double getMaxTonnage() 
    {
        return maxTonnage;
    }

    /**
     * Set the maxTonnage of the ship
     * @param maxTonnage : double
     */
    public void setMaxTonnage(double maxTonnage) 
    {
        this.maxTonnage = maxTonnage;
    }

    /**
     * Get the maxSpeed of the ship
     * @return maxSpeed : int
     */
    public int getMaxSpeed() 
    {
        return maxSpeed;
    }

    /**
     * Set the maxSpeed of the ship
     * @param maxSpeed : int
     */
    public void setMaxSpeed(int maxSpeed) 
    {
        this.maxSpeed = maxSpeed;
    }
    
    /**
     * Get the distance of the ship. Distance to the destination.
     * @return distance: int
     */
    public int getDistance() 
    {
        return distance;
    }

    /**
     * Set the distance of the ship. Distance to the destination
     * @param distance : int
     */
    public void setDistance(int distance) 
    {
        this.distance = distance;
    }
    
    
    @Override
    public String toString()
    {
        return getShipName() + "~" + getMaxTonnage() + "~" + getMaxSpeed() + "~" + getDistance();
    }
    
}
