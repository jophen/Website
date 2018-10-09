
/**
 * This is the class for Lists | using Linked Lists
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 24, 2018
 * @author Joseph Hentges
 */

public class LinkBasedList implements HentgesList{
    
    //Variables used in the LinkedList
    private int items;
    private Node front;
    
    //Create a Node class
    private class Node
    {
        int data;
        Node next;
    }
    
    //Constructor for the linked list
    public LinkBasedList()
    {
        items = 0;
        front = null;
    }
    
    /**
     * Return a string of all the values in the List
     */
    public String toString()
    {        
        String output = "Data in the List (" + size() + "):\n";
        Node curr = front; //pointer for the nodes
        int i = 1;
        while(curr != null)
        {
            output += "\t" + (i) + ":\t" + curr.data + "\n";
            i++;
            curr = curr.next;
        }
        return output;
    }

    /**
     * Add item to the end of the list
     * @param item : int - item to be added
     * @return bool : boolean - true if add succeeded, false otherwise
     */
    @Override
    public boolean add(int item) {
        //Find the end of the list
        //Do we have a list?
        if(front == null)
        {
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = null;
            front = newNode;
            items++;
            return true;
        }
        //If the list is not empty
        //Need to find the end of the list
        Node curr = front;
        while(curr.next != null)
        {
            curr = curr.next;
        }
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;
        curr.next = newNode;
        items++;
        return true;
    }

    /**
     * Add an item to a particular position
     * @param pos : int - position for item to be added to | 1 as the front index
     * Any index lower than 0 will put the item at the front of the list
     * Any index greater than the current largest index will put the item at the end of the list
     * @param item : int - item to be added (int item)
     * @return bool : boolean - true if add succeeded, false otherwise
     */
    @Override
    public boolean add(int pos, int item) {
        //add to the end of the list
        if(pos >= items)
        {
            add(item);
        }
        //add to the middle or front of the list
        //if the position is less than or equal to 1, put it at the beggining of the list
        else if(pos <= 1)
        {
            //Add to the front
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = front;
            front = newNode;
            items++;
        }
        //if the position is in the middle of the list
        else
        {
            //Get to the location
            Node curr = front;
            for(int i = 1; i < pos-1; i++)
            {
                curr = curr.next;
            }
            //Curr is before hte new node position
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = curr.next;
            curr.next = newNode;
            items++;
        }
        return true;
    }

    /**
     * Remove item from a specific position
     * @param pos : int - position of the item to be removed
     * Zero and negative positions ill remove from the front
     * Positions larger than the current greatest will remove from the end
     * @return int - provide the removed item, null if the list is empty ... or returns -1 if the list is empty
     */
    @Override
    public int remove(int pos) {
        //If the list is empty, just throw out a default value or exception
        if(items <= 0)
        {
            return -1; //default value in this case
        }
        //get at the end of the list
        else if(pos >= items)
        {
            pos = items;
        }
        //get at the middle or front of the list
        //if the position is less than or equal to 1, put it at the beggining of the list
        else if(pos <= 1)
        {
            //point to the front of the list
            pos = 1;
        }
        //Special case. If the position is the front node. Remove & return the front value
        if(pos == 1)
        {
            int temp = front.data;
            front = front.next;
            items--;
            return temp;
        }
        //If the position is not the front node
        //Get to the location. Go to 1 postion BEFORE target position
        Node curr = front;
        for(int i = 1; i < pos - 1; i++)
        {
            curr = curr.next;
        }
        //curr is at the node before target position
        int temp = curr.next.data;
        curr.next = curr.next.next;
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
        //If the list is empty, just throw out a default value or exception
        if(items <= 0)
        {
            return -1; //default value in this case
        }
        //get at the end of the list
        else if(pos >= items)
        {
            pos = items;
        }
        //get at the middle or front of the list
        //if the position is less than or equal to 1, put it at the beggining of the list
        else if(pos <= 1)
        {
            //point to the front of the list
            pos = 1;
        }
        //Everything is in order. Now find the value
        //Have a valid position
        //Get to the location
        Node curr = front;
        for(int i = 1; i < pos; i++)
        {
            curr = curr.next;
        }
        //Curr is at the target position
        return curr.data;
    }

    /**
     * Clears the list of all values
     */
    @Override
    public void clear() {
        items = 0;
        front = null; //By setting front to null, nothing is pointing to the front of the list, therefore java will clear everything in memory.
    }

    /**
     * Returns an array of all the items in the list
     * Preserves the order!
     * @return array : int[] - An array of the items in the list
     */
    @Override
    public int[] toArray() {
        int[] output = new int[items]; //array to be returned. Will contain the data in each node
        Node curr = front;
        int i = 0;
        while(curr != null)
        {
            output[i] = curr.data;
            curr = curr.next;
            i++;
        }
        return output;
    }

    /**
     * Checks if a given target is in the list
     * @param target : int - target to be found
     * @return bool : boolean - true if target is in the list, false otherwise
     */
    @Override
    public boolean contains(int target) {
        Node curr = front;
        while(curr != null)
        {
            if(curr.data == target)
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * How many items are in the list?
     * @return size : int - the number of items in the list
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
