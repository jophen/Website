
import java.util.Random;

/**
 * This is the class for Bags using Arrays
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 19, 2018
 * @author Joseph Hentges
 */

public class BagArray<T> implements Bag
{
    
    private T[] array; //An array of all the data in bag
    private int items = 0; //An integer to represent the amount of data in the array (bags array)
    
    /**
     * @param size : int - The size of the array created
     */
    public BagArray(int size)
    {
        array = (T[]) new Object[size];
    }
    
    /**
     * Create and return a String of the data in the Bag (array)
     * @return toString : String - A string of all the values in the Bag (array)
     */
    public String toString()
    {
        String output = "ArrayBag{count=" + items + "}:\n";
        for (int i = 0; i < items; i++)
        {
            output += "\t"+array[i]+"\n";
        }
        return output;
    }

    /**
     * Get the number of items in the bag
     * @return items : int - The amount of items in the bag
     */ 
    @Override
    public int size() {
        return items;
    }

    /**
     * Add data to the bag | array
     * @param data : Object : some particular object (of some data type)
     * @return true/false : Boolean - did the data successfully add to the bag (array)
     */
    @Override
    public boolean add(Object data) {
        //If items equals the max amount of data the bag (array) can hold, don't try to add more data
        if(items == array.length)
        {
            return false; //The data does not successfully add
        }
        //Hope that the object is the right type of data
        
        array[items] = (T)data; //Put the data into the array
        //If the cast failed (data to T type), Java will kick us out with an exception
        
        items++; //Increment items to show that another piece of data was added to the bag (array)
        
        return true; //The data does successfully add
    }

    /**
     * Remove an item based on the id specified
     * @param value : int - The ID of the item we want to remove
     * @return T : data - The item removed from the bag
     */
    @Override
    public Object remove(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Remove items based on being less than 0
     */
    @Override
    public void removeLessThanZero()
    {
        int curr = 0;
        for (int i = 0; i < items; i++)
        {
            if (array[i].hashCode() > 0)
            {
                array[curr] = array[i];
                curr++;
            }
        }
        items = curr;
    }

    /**
     * Get a random piece of data from the array
     * @return temp : Object - return some data from the bag (data)
     */
    @Override
    public Object remove() {
        //Check for there still being items in the bag (array) | Return null if the bag (array) is empty
        if(items <= 0)
        {
            return null;
        }
        
        Random gen = new Random(); //Generator to create random values
        int index = gen.nextInt(items); // (max - min + 1) + min | A random index to be removed from the bag (array)
        
        Object temp = array[index]; //Get some value from the bag (array)
        
        array[index] = array[items - 1]; //move the data over
        array[items-1] = null; 
        items--; //decrement the amount of items in the bag (array)
        
        return temp;
    }

    /**
     * Remove and return all data from the bag (array)
     * @return temp : Object - An array of data the bag (array) contained
     */
    @Override
    public Object[] removeAll() {
        Object[] temp = toArray(); //Create a temporary array (temp) to be returned
        
        clear(); //Clear the bag (array) of all items.
        
        return temp;
    }

    /**
     * Clear all items for the bag (array) and set them to null.
     * @param void
     * @return void
     */
    @Override
    public void clear() {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = null;
        }
        items = 0;
    }
    
    /**
     * Get how many of a certain piece of data the bag contains
     * @param value : int - The id of some data in the bag
     * @return value : int - The number of how many there are
     */ 
    @Override
    public int howMany(int value) {
        int counter = 0; //Counter to hold onto the number of times a number comes up in the bag
        
        //Use a for loop to count to amount of times value shows up in the bag
        for(int i = 0; i < items; i++)
        {
            if(array[i].hashCode() == value)
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Find if the bag contains a certain piece of data
     * @param value : int - The id of some data to be found
     * @return true/false : boolean - whether or not the bag contains that data
     */ 
    @Override
    public boolean contains(int value) {      
        return (howMany(value) >= 1); //Return true if there is at least 1 of the value, false otherwise
    }

    /**
     * Return an array of all the data in the bag
     * @return T : array - An array of all the data the bag contains
     */ 
    @Override
    public Object[] toArray() {
        Object[] temp = new Object[items]; //Create a temporary array (temp) to be returned
        //Add all value from the bag (array) to the temporary array
        for(int i = 0; i < items; i++)
        {
            temp[i] = array[i];
        }
        return temp;
    }
    
}
