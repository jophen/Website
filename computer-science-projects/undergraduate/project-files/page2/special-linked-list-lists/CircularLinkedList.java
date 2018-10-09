/**
 * A class demonstrates the use of a circular linked linked list
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * October 3, 2018
 * @author Joseph Hentges
 */
public class CircularLinkedList<T> implements ListInterface<T> {
    
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    //Create a Node class
    private class Node<T>
    {
        T data;
        Node next;
    }
    
    //Constructor for the linked list
    public CircularLinkedList()
    {
        numberOfEntries = 0;
        firstNode = null;
    }
    
    /**
     * Return a string of all the values in the List
     */
    @Override
    public String toString()
    {        
        String output = "Data in the List (" + getLength() + "):\n";
        Node curr = firstNode; //pointer for the nodes
        for(int i = 1; i <= numberOfEntries; i++)
        {
            output += "\t" + (i) + ":\t" + curr.data + "\n";
            curr = curr.next;
        }
        return output;
    }

    /**
     * Add item to the end of the list
     * @param newEntry : T - item to be added
     */
    @Override
    public void add(T newEntry) {
        //Find the end of the list
        //Do we have a list?
        if(firstNode == null)
        {
            Node newNode = new Node();
            newNode.data = newEntry;
            firstNode = newNode;
            newNode.next = firstNode;
            numberOfEntries++;
            return;
        }
        //If the list is not empty
        //Need to find the end of the list
        Node curr = firstNode;
        for(int count = 1; count < numberOfEntries; count++)
        {
            curr = curr.next;
        }
        Node newNode = new Node();
        newNode.data = newEntry;
        newNode.next = firstNode;
        curr.next = newNode;
        numberOfEntries++;
    }

    /**
     * Add an item to a particular position
     * @param newPosition : int - position for item to be added to | 1 as the front index
     * Any index lower than 0 will put the item at the front of the list
     * Any index greater than the current largest index will put the item at the end of the list
     * @param newEntry : T - item to be added
     */
    @Override
    public void add(int newPosition, T newEntry) {
        //add to the end of the list
        if(newPosition > numberOfEntries)
        {
            add(newEntry);
        }
        //add to the middle or front of the list
        //if the position is less than or equal to 1, put it at the beggining of the list
        else if(newPosition <= 1)
        {
            //Add to the front
            Node newNode = new Node();
            newNode.data = newEntry;
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
        }
        //if the position is in the middle of the list
        else
        {
            //Get to the location
            Node curr = firstNode;
            for(int i = 1; i < newPosition-1; i++)
            {
                curr = curr.next;
            }
            //Curr is before hte new node position
            Node newNode = new Node();
            newNode.data = newEntry;
            newNode.next = curr.next;
            curr.next = newNode;
            numberOfEntries++;
        }
    }

    /** 
    Removes the entry at a given position from this list.
    Entries originally at positions higher than the given
    position are at the next lower position within the list,
    and the list's size is decreased by 1.
    @param givenPosition  An integer that indicates the position of the entry to be removed.
    @return  A reference to the removed entry.
    @throws  IndexOutOfBoundsException if either 
    givenPosition < 1 or givenPosition > getLength(). 
    */
    @Override
    public T remove(int givenPosition) {
        //If the list is empty, just throw out a default value or exception
        if(numberOfEntries <= 0)
        {
            return null; //default value in this case
        }
        //get at the end of the list
        else if(givenPosition >= numberOfEntries)
        {
            givenPosition = numberOfEntries;
        }
        //get at the middle or front of the list
        //if the position is less than or equal to 1, put it at the beggining of the list
        else if(givenPosition <= 1)
        {
            //point to the front of the list
            givenPosition = 1;
        }
        //Special case. If the position is the front node. Remove & return the front value
        if(givenPosition == 1)
        {
            Object temp = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            return (T)temp;
        }
        //If the position is not the front node
        //Get to the location. Go to 1 postion BEFORE target position
        
        Node curr = firstNode;
        for(int i = 1; i < givenPosition - 1; i++)
        {
            curr = curr.next;
        }
        //curr is at the node before target position
        Object temp = curr.next.data;
        curr.next = curr.next.next;
        numberOfEntries--;
        return (T)temp;
    }

    /**
     * Clears the list of all values
     */
    @Override
    public void clear() {
        numberOfEntries = 0;
        firstNode = null; //By setting front to null, nothing is pointing to the front of the list, therefore java will clear everything in memory.
    }

    /** 
    Replaces the entry at a given position in this list.
    @param givenPosition  An integer that indicates the position of the entry to be replaced.
    @param newEntry  The object that will replace the entry at the position givenPosition.
    @return  The original entry that was replaced.
    @throws  IndexOutOfBoundsException if either
    givenPosition < 1 or givenPosition > getLength(). 
    */
    @Override
    public T replace(int givenPosition, T newEntry) {
        //If the given position is less than or equal to 1, replace the first node
        if(givenPosition <= 1)
        {
            Object temp = firstNode.data;
            firstNode.data = newEntry;
            return (T)temp;
        }
        //if the given position is too large, set it to go to the last node
        if(givenPosition > numberOfEntries)
        {
            givenPosition = numberOfEntries;
        }
        //loop through the list, to get to the right position
        Node curr = firstNode;
        for(int i = 1; i < givenPosition; i++)
        {
            curr = curr.next;
        }
        Object temp = curr.data;
        curr.data = newEntry;
        return (T)temp;
    }

    /**
     * Get data at a given position
     * @param givenPosition : int - the poisiton number to be retrieved from
     * @return T - The data at the given position
     */
    @Override
    public T getEntry(int givenPosition) {
        //If the list is empty, just throw out a default value or exception
        if(numberOfEntries <= 0)
        {
            return null; //default value in this case
        }
        //get at the end of the list
        else if(givenPosition >= numberOfEntries)
        {
            givenPosition = numberOfEntries;
        }
        //get at the middle or front of the list
        //if the position is less than or equal to 1, put it at the beggining of the list
        else if(givenPosition <= 1)
        {
            //point to the front of the list
            givenPosition = 1;
        }
        //Everything is in order. Now find the value
        //Have a valid position
        //Get to the location
        Node curr = firstNode;
        for(int i = 1; i < givenPosition; i++)
        {
            curr = curr.next;
        }
        //Curr is at the target position
        return (T)curr.data;
    }

    /**
     * Returns an array of all the items in the list
     * Preserves the order!
     * @return array : int[] - An array of the items in the list
     */
    @Override
    public T[] toArray() {
        T[] output = (T[]) new Object[numberOfEntries]; //array to be returned. Will contain the data in each node
        Node curr = firstNode;
        int i = 0;
        while(i != numberOfEntries)
        {
            output[i] = (T) curr.data;
            curr = curr.next;
            i++;
        }
        return output;
    }

    /**
     * Checks if a given target is in the list
     * @param anEntry : int - target to be found
     * @return bool : boolean - true if target is in the list, false otherwise
     */
    @Override
    public boolean contains(T anEntry) {
        Node curr = firstNode;
        for(int i = 1; i < numberOfEntries; i++)
        {
            if(curr.data == anEntry)
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * Get the length of the list, and return it.
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * Returns whether the list is empty or not
     * @return bool : boolean - True if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries <= 0;
    }
    
    /**
     * This method is not used in this List Type.
     * Only Used in double linked lists.
     */
    @Override
    public void valuesFromEnd()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
    * Get values in a circle. Runs through the list multiple times over.
    * This shows the list is connected from front to back.
    */
    @Override
    public void valuesInACircle()
    {
        System.out.println("Get values in a cirlce. Starting from the first node.");
        Node curr = firstNode;
        for(int i = 0; i < numberOfEntries*3; i++)
        {
            System.out.println("Current item data:" + curr.data);
            curr = curr.next;
        }
    }
    
}
