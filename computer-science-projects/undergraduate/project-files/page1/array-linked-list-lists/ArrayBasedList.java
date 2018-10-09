

/**
 * This is the class for Lists | using Arrays
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 24, 2018
 * @author Joseph Hentges
 */

public class ArrayBasedList implements HentgesList {

    private int items; //int to keep track of the items in the list
    private int[] list; //an array to hold on to the values in the lsit
    
    /**
     * Constructor for list
     */
    public ArrayBasedList()
    {
        items = 0;
        list = new int[16]; //you can always increase the size of the array later, so pick a reasonable starting size
    }
    
    /**
     * Return a string of all the values in the List
     */
    public String toString()
    {
        String output = "Data in the List (" + size() + "):\n";
        
        for(int i = 0; i < items; i++)
        {
            output += "\t" + (i+1) + ":\t" + list[i] + "\n";
        }
        return output;
    }
    
    /**
     * Increase the size of the list
     * make a bigger array for the list, while maintaining all values already in the list
     */
    private void increaseList()
    {
        int[] tempArray = new int[list.length*2]; //give the list double the space
        for(int i = 0; i < list.length; i++)
        {
            tempArray[i] = list[i];
        }
        list = tempArray;
    }
    
    /**
     * Add item tot he end of the list
     * @param item : int - item to be added
     * @return bool : boolean - true if add succeeded, false otherwise
     */
    @Override
    public boolean add(int item) {
        //catch if the list is full. give the list more space
        if(items == list.length)
        {
            //need more space
            increaseList();
        }
        
        list[items] = item;
        items++;
        return true;
    }

    /**
     * Add an item to a particular position
     * @param item : int - item to be added (int item)
     * @return bool : boolean - true if add succeeded, false otherwise
     */
    @Override
    public boolean add(int pos, int item) {
        //if the position given is greater than or equal to the current max
        if(pos >= items)
        {
            //Add the the end of the array
            add(item);
        }
        //add to the middle or front of the list
        else
        {
            //catch if the list is full. give the list more space
            if(items == list.length)
            {
                //need more space
                increaseList();
            }
            //check for too low of a position
            if(pos <= 0)
            {
                pos = 1;
            }
            //make room
            for(int i = items; i > (pos-1); i--)
            {
                list[i] = list[i-1];
            }
            list[pos-1] = item;
        }
        items++;
        return true;
    }
    
    /**
     * Remove item from a specific position
     * @param pos : int - position of the item to be removed
     * @return int - provide the removed item, null if the list is empty ... or returns -1 if the list is empty
     */
    @Override
    public int remove(int pos) {
        //If the list is empty, return nothing.
        if(items <= 0)
        {
            return -1; //Return a default number, or could throw an exception
        }
        //If the position is less than or equal to 0, get the first element
        else if(pos-1 <= 0)
        {
            pos = 1;
        }
        //If the position is larger than the number of items, get the last element
        else if(pos > items)
        {
            pos = items;
        }
        
        int temp = list[pos-1]; //temporary variable to hold the value at position 'pos'
        
        for(int i = pos-1; i < items; i++)
        {
            list[i] = list[i+1];
        }
        list[items-1] = 0; //removing the final element to account for moving every item down an index
        items--;
        
        return temp;
    }

    /**
     * Get item from a specific position
     * @param pos : int - position of the item to be removed
     * Zero and negative positions ill get from the front
     * Positions larger than the current greatest will get from the end
     * @return int - provide the gotten item, null if the list is empty ... or returns -1 if the list is empty
     */
    @Override
    public int getEntryAt(int pos) {
        //If the list is empty, return nothing.
        if(items <= 0)
        {
            return -1; //Return a default number, or could throw an exception
        }
        //If the position is less than or equal to 0, get the first element
        else if(pos-1 <= 0)
        {
            pos = 1;
        }
        //If the position is larger than the number of items, get the last element
        else if(pos > items)
        {
            pos = items;
        }
        
        return list[pos-1];
    }

    /**
     * Clears the list of all values
     */
    @Override
    public void clear() {     
        System.out.println("...Clearing The List...");
        for(int i = 0; i < items; i++)
        {
            list[i] = 0;
        }
        items = 0;
    }

    /**
     * Returns an array of all the items in the list
     * Preserves the order!
     * @return array : int[] - An array of the items in the list
     */
    @Override
    public int[] toArray() {
        int[] temp = new int[items];
        
        for(int i = 0; i < items; i++)
        {
            temp[i] = list[i];
        }
        return temp;
    }

    /**
     * Checks if a given target is in the list
     * @param target : int - target to be found
     * @return bool : boolean - true if target is in the list, false otherwise
     */
    @Override
    public boolean contains(int target) {
        //Loop through the array to see if something matches up with the target element
        for(int i = 0; i < items; i++)
        {
            if(list[i] == target)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * How many items are in the list?
     * @return items : int - the number of items in the list
     */
    @Override
    public int size() {
        return items;
    }

    /**
     * Returns whether the list is empty or not
     * @return bool : boolean - True if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return items <= 0;
    }
    
}
