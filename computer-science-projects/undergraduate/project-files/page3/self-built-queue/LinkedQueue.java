
/**
 * This is the class file for a Queue using Linked Lists. 
 * This Queue is RESIZABLE
 * CSC 210 Data Structures
 * Queues
 * Semester 1 | Fall 2018
 * October 12, 2018
 * @author Joseph Hentges
 */

public class LinkedQueue<T> implements MyQueue<T> {

    private int count;
    private Node front;
    private Node back;
    
    //class for a Node
    private class Node
    {
        T data;
        Node next = null;
    }
    
    /**
     * Constructor for a Linked Queue
     */
    public LinkedQueue()
    {
        count = 0;
        front = null;
        back = null;
    }
    
    /**
     * This is a toString method to get (for display) the values in the queue
     * @return output : String - the string of the values
     */
    public String toString()
    {
        String output = "PRINTING QUEUE\n";
        Node curr = front;
        while (curr != null)
        {
            output += "\t" + curr.data + "\t";
            curr = curr.next;
        }
        output += "\nCurrent size is: " + size() + "\n";
        return output;
    }
    
    /**
     * Add an entry to the queue
     * @param entry : T - Some data (data type - any)
     */
    @Override
    public void enqueue(T entry) {
        Node newNode = new Node();
        newNode.data = entry;
        //if the queue is empty, place the node at the front of the queue
        if(isEmpty())
        {
            front = newNode;
        }
        //if the queue is not empty, place the node at the end of the queue
        else
        {
            back.next = newNode;
        }
        back = newNode; //point back to the new node
        count++;
    }

    /**
     * Remove an entry from the queue and return the data
     * @return temp : T - some data that was removed from the queue
     */
    @Override
    public T dequeue() {
        //if the queue is empty, return nothing
        if(isEmpty())
        {
            return null;
        }
        //if the queue is not empty, get the front data and move its pointer
        T temp = front.data;
        front.data = null;
        front = front.next;
        count--;
        //if we are empty after a removal, back will still be pointing to the node, so set that to null, to account for it
        if(isEmpty())
        {
            back = null;
        }
        return temp;
    }

    /**
     * Get the front data in the queue
     * @return T : the data (type not specified)
     */
    @Override
    public T peek() {
        if(isEmpty())
        {
            return null;
        }
        return front.data;
    }

    /**
     * Get the size of the queue
     * @return count : int  - the size of the queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * return whether the queue is empty or not
     * @return bool : boolean - whether the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
}
