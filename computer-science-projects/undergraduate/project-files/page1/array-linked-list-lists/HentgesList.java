/**
 * This is the interface for Lists
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 24, 2018
 * @author Joseph Hentges
 */

/**
 * This is a NON-GENERIC interface
 */

public interface HentgesList {
    
    /**
     * Add item to the end of the list
     * @param item : int - item to be added
     * @return bool : boolean - true if add succeeded, false otherwise
     */
    boolean add(int item);
    
    /**
     * Add an item to a particular position
     * @param pos : int - position for item to be added to | 1 as the front index
     * Any index lower than 0 will put the item at the front of the list
     * Any index greater than the current largest index will put the item at the end of the list
     * @param item : int - item to be added (int item)
     * @return bool : boolean - true if add succeeded, false otherwise
     */
    boolean add(int pos, int item);
    
    /**
     * Remove item from a specific position
     * @param pos : int - position of the item to be removed
     * Zero and negative positions ill remove from the front
     * Positions larger than the current greatest will remove from the end
     * @return int - provide the removed item, null if the list is empty ... or returns -1 if the list is empty
     */
    int remove(int pos);
    
    /**
     * Get item from a specific position
     * @param pos : int - position of the item to be removed
     * Zero and negative positions ill get from the front
     * Positions larger than the current greatest will get from the end
     * @return int - provide the gotten item, null if the list is empty ... or returns -1 if the list is empty
     */
    int getEntryAt(int pos);
    
    /**
     * Clears the list of all values
     */
    void clear();
    
    /**
     * Returns an array of all the items in the list
     * Preserves the order!
     * @return array : int[] - An array of the items in the list
     */
    int[] toArray();
    
    /**
     * Checks if a given target is in the list
     * @param target : int - target to be found
     * @return bool : boolean - true if target is in the list, false otherwise
     */
    boolean contains(int target);
    
    /**
     * How many items are in the list?
     * @return size : int - the number of items in the list
     */
    int size();
    
    /**
     * Returns whether the list is empty or not
     * @return bool : boolean - True if the list is empty, false otherwise
     */
    boolean isEmpty();
}
