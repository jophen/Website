
/**
 * This is the interface file for a Stack.
 * CSC 210 Data Structures
 * Stacks
 * Semester 1 | Fall 2018
 * October 12, 2018
 * @author Joseph Hentges
 */

public interface MyStack<T>
{
    /**
     * Pushes data onto the top of the Stack
     * @param entry Data to push onto the Stack
     */
    void push(T entry);

    /**
     * Pop data off the top of the Stack.
     * @return Data which was on the top of the Stack. May be null if Stack is empty
     */
    T pop();
    
    /**
     * Peek at what data is on top of the Stack
     * @return Data (does not remove) which is currently on top of the Stack.  May be null if Stack is empty
     */
    T peek();
    
    /**
     * Retrieves the size of the Stack
     * @return An integer denoting how many items are currently in the Stack
     */
    int size();
    
    /**
     * Determines if the Stack is empty or not
     * @return Boolean indicating if the Stack is empty (true) or not (false)
     */
    boolean isEmpty();
}
