
/**
 * This is the class for Bags using LinkedLists
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 21, 2018
 * @author Joseph Hentges
 */

public class BagLinked<T> implements Bag
{
    private int items; //A counter for the amount of items in the bag
    private Node front;
    private class Node
    {
        T value; //The value of the node | some sort of data
        Node next; //The next node in the linkedList | Either some address or null
    }
    
    //Create a Bag of linkedList
    public BagLinked()
    {
        items = 0;
        front = null;
    }
    
    /**
     * Return a string of all the values in the linkedList (Bag)
     * @return list : String - String of all the values in the bag
     */
    public String toString()
    {
        String output = "LinkedBag:\n";
        Node curr = front;
        while(curr != null)
        {
            output += "\t"+curr.value+"\n";
            curr = curr.next;
        }
        return output;
    }
    
    /**
     * @return size : int - The size of the array 
     */
    @Override
    public int size() {
        return items;
    }

    /**
     * Add data to the bag
     * @param data : T - The data we want to add
     * @return true/false : boolean - If the value was successfully added
     */ 
    @Override
    public boolean add(Object data) {
        // 1 Build node
        // 2 Fill node | value & next
        // 3 move front
        
        Node newNode = new Node();
        newNode.value = (T)data;
        newNode.next = front;
        front = newNode;
        items++;
        return true;
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

    @Override
    public void removeLessThanZero() {
        while (front != null && front.value.hashCode() <= 0)
        {
            front = front.next;
        }
        Node curr = front;
        while(curr.next != null)
        {
            if (curr.next.value.hashCode() <= 0)
            {
                curr.next = curr.next.next;
            }
            else
            {
                curr = curr.next;
            }
        }
    }

    /**
     * Remove a random data from the bag
     * @return T : data - A random data from the bag
     */ 
    @Override
    public Object remove() {
        //unfil the node
        //move front
        //return data
        
        // if there are no items in the bag, return null
        if(front == null)
        {
            return null;
        }
        
        Object temp = front.value;
        front = front.next;
        items--;
        
        //if the node doesn't have anything pointing to it, it will be automatically removed
        
        return temp;
    }

    /**
     * Return an array of all the data in the bag
     * @return T[] : array of data
     */
    @Override
    public Object[] removeAll() {
        Object[] temp = toArray(); //get an array of all the data in the bag (linkedList)
        
        clear(); //remove all the items in the bag
        
        items = 0;
        
       return temp;
    }

    /**
     * Clears all data from the bag
     */
    @Override
    public void clear() {
        //Remove the front pointer is pointing to nothing, java will automatically remove the whole linkedList
        front = null;
        items = 0;
    }

    /**
     * Get how many of a certain piece of data the bag contains
     * @param value : int - The id of some data in the bag
     * @return value : int - The number of how many there are
     */ 
    @Override
    public int howMany(int value) {
        int counter = 0;
        Node curr = front;
        while(curr != null)
        {
            if(curr.value.hashCode() == value)
            {
                counter++;
            }
            curr = curr.next;
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
        return (howMany(value) >= 1);
    }

    /**
     * Return an array of all the data in the bag
     * @return T : array - An array of all the data the bag contains
     */ 
    @Override
    public Object[] toArray() {
        Object[] temp = new Object[items];
        Node curr = front; //pointer to walk through the linkedList
        int i = 0;
        while(curr != null)
        {
            temp[i] = curr.value;
            curr = curr.next;
            i++;
        }
        return temp;
    }
    
}
