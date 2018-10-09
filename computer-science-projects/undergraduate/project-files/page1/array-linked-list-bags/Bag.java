/**
 * This is the interface for Bags
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 19, 2018
 * @author Joseph Hentges
 */

public interface Bag<T> {
    
    /**
     * @return size : int - The size of the array 
     */
    int size();
    
    /**
     * Add data to the bag
     * @param data : T - The data we want to add
     * @return true/false : boolean - If the value was successfully added
     */ 
    boolean add(T data);
    
    /**
     * Remove an item based on the id specified
     * @param value : int - The ID of the item we want to remove
     * @return T : data - The item removed from the bag
     */
    T remove(int value);
    
    /**
     * Remove items based on being less than 0
     */
    void removeLessThanZero();
    
    /**
     * Remove a random data from the bag
     * @return T : data - A random data from the bag
     */ 
    T remove();
    
    /**
     * Return an array of all the data in the bag
     * @return T[] : array of data
     */
    T[] removeAll();
    
    /**
     * Clears all data from the bag
     */
    void clear();
    
    /**
     * Get how many of a certain piece of data the bag contains
     * @param value : int - The id of some data in the bag
     * @return value : int - The number of how many there are
     */ 
    int howMany(int value);
    
    /**
     * Find if the bag contains a certain piece of data
     * @param value : int - The id of some data to be found
     * @return true/false : boolean - whether or not the bag contains that data
     */ 
    boolean contains(int value);
    
    /**
     * Return an array of all the data in the bag
     * @return T : array - An array of all the data the bag contains
     */ 
    T[] toArray();
    
    /**
     * Return an String of the bag
     * @return toString : String - A string of all the data the bag contains
     */
    String toString();
}
