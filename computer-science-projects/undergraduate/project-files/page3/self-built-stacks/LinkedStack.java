
/**
 * This is the class file for a Stack using Linked Lists.
 * This stack IS RESIZABLE
 * CSC 210 Data Structures
 * Stacks
 * Semester 1 | Fall 2018
 * October 12, 2018
 * @author Joseph Hentges
 */

public class LinkedStack<T> implements MyStack<T> {
    
    private int count;
    private Node top;
    
    /**
     * This is the class for a Node, for the linked list
     */
    private class Node
    {
        T data;
        Node next;
    }
    
    /**
     * This is the constructor for the LinkedStack
     */
    public LinkedStack()
    {
        count = 0;
        top = null;
    }

    /**
     * This is a toString method to get (for display) the values in the stack
     * @return output : String - the string of the values
     */
    public String toString()
    {
        String output = "PRINTING STACK\n";
        Node curr = top;
        while (curr != null)
        {
            output += "\t" + curr.data + "\n";
            curr = curr.next;
        }
        output += "Current size is: " + size() + "\n";
        return output;
    }
    
    /**
     * Add (push on) some entry to the stack
     * @param entry : T - Some data (type not specified)
     */
    @Override
    public void push(T entry) {
        Node newNode = new Node();
        newNode.data = entry;
        newNode.next = top;
        top = newNode;
        count++;
    }

    /**
     * Remove (pop off) some entry from the queue
     * @return temp : T - Some data (type not specified)
     */
    @Override
    public T pop() {
        if (isEmpty())
            return null;
        T temp = top.data;
        top.data = null;
        top = top.next;
        count--;
        return temp;
    }

    /**
     * Peek, not remove, the first value in the stack
     * @return T - some data (type not specified)
     */
    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return top.data;
    }

    /**
     * Get the size of the stack
     * @return count : int - the size of the stack
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * return whether the stack is empty or not
     * @return bool : boolean - the stack empty or not.
     */
    @Override
    public boolean isEmpty() {
        if (count == 0)
            return true;
        return false;
    }
    
}
