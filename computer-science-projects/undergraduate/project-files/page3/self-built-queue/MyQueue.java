
/**
 * This is the interface file for a Queue.
 * CSC 210 Data Structures
 * Queues
 * Semester 1 | Fall 2018
 * October 12, 2018
 * @author Joseph Hentges
 */

public interface MyQueue<T>
{
    /**
     * Enqueues data at the back of the Queue
     * @param entry Data to enqueue into the Queue
     */
    void enqueue(T entry);

    /**
     * Dequeue data off the front of the Queue
     * @return Data which was at the front of the Queue. May be null if Queue is empty
     */
    T dequeue();
    
    /**
     * Peek at what data is at the front of the Queue
     * @return Data (does not remove) which is currently at the front of the Queue.  May be null if Queue is empty
     */
    T peek();
    
    /**
     * Retrieves the size of the Queue
     * @return An integer denoting how many items are currently in the Queue
     */
    int size();
    
    /**
     * Determines if the Queue is empty or not
     * @return Boolean indicating if the Queue is empty (true) or not (false)
     */
    boolean isEmpty();
}
