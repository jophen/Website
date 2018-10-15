
/**
 * This is the class file for a Queue using Arrays. 
 * This Queue is NOT RESIZABLE
 * CSC 210 Data Structures
 * Queues
 * Semester 1 | Fall 2018
 * October 12, 2018
 * @author Joseph Hentges
 */

public class ArrayQueue<T> implements MyQueue<T> {
    private int count;
    private int front;
    private int back;
    private T[] queue;
    
    /**
     * This is the constructor
     * @param size : int - the size of the array
     */
    public ArrayQueue(int size)
    {
        count = 0;
        queue = (T[]) new Object[size];
        front = 0;
        back = 0;
    }
    
    /**
     * This is a toString method to get (for display) the values in the queue
     * @return output : String - the string of the values
     */
    public String toString()
    {
        String output = "PRINTING QUEUE\n";
        //if the queue is empty, don't do anything
        if(isEmpty())
        {
            //DO NOTHING
        }
        // the queue is not wrapping
        else if(front <= back)
        {
            for(int i = front; i <= back; i++)
            {
                output += "\t" + queue[i] + "\t";
            }
        }
        // the queue is wrapping
        else
        {
            // go from front to end of array
            for(int i = front; i < queue.length; i++)
            {
                output += "\t" + queue[i] + "\t";
            }
            // pick the front (0 to back)
            for(int i = 0; i <= back; i++)
            {
                output += "\t" + queue[i] + "\t";
            }
        }
        output += "\nThere are " + size() + " items.\n";
        return output;
    }

    /**
     * Add an entry to the queue
     * @param entry : T - Some data (data type - any)
     */
    @Override
    public void enqueue(T entry) {
        //if the queue is full, let the user know, and don't insert any values.
        if (count == queue.length)
        {
            System.err.println("Queue is FULL!!!");
            return;
        }
        //if the queue is empty, place the value in the first index of the array (0)
        if (isEmpty())
        {
            front = 0;
            back = 0;
            queue[front] = entry;
            count++;
            return;
        }
        //if back is less than the length of the queue (meaning the array filling from left to right, and not full). Place the value at index back
        if(back < queue.length - 1)
        {
            back++;
            queue[back] = entry;
            count++;
            return;
        }
        //at the end of the array, but not FULL, do a wrap around. Meaning we place the values at the front rather than the back
        back = 0;
        queue[back] = entry;
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
        T temp = queue[front];
        queue[front] = null;
        count--;
        front++;
        //If the front index is now out of bounds (front larger than the size of the array, set it back to 0
        if(front == queue.length)
        {
            front = 0;
        }
        return temp;
    }

    /**
     * Look (peek) at the next value in the queue
     * @return T - some data, the front of the queue
     */
    @Override
    public T peek() {
        return queue[front];
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
     * Return whether the queue is empty or not
     * @return bool : boolean - the queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
}
