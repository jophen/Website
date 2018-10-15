
/**
 * This is the class file for a Stack using arrays. 
 * This stack is NOT RESIZABLE
 * CSC 210L Data Structures Lab
 * Stacks
 * Semester 1 | Fall 2018
 * October 12, 2018
 * @author Joseph Hentges
 */

/**
 * Stack using Arrays NOT RESIZABLE
 * @author kerlin
 */
public class ArrayStack<T>  implements MyStack<T>
{

    private T[] stack;
    private int count;
    
    /**
     * the constructor for this file
     * @param size 
     */
    public ArrayStack(int size)
    {
        count = 0;
        stack = (T[]) new Object[size];
    }
    
    /**
     * This is a toString method to get (for display) the values in the stack
     * @return output : String - the string of the values
     */
    public String toString()
    {
        String output = "PRINTING STACK\n";
        for (int i = count - 1; i >= 0; i--)
        {
            output += "\t" + stack[i] + "\n";
        }
        output += "There are " + size() + " items.\n";
        return output;
    }
    
    /**
     * Add (push on) some data to the stack
     * @param entry : T - some data (type not specified)
     */
    @Override
    public void push(T entry) {
        if (count == stack.length) //Check if full!
        {
            System.err.println("Stack full, did not push!");
            return;
        }
        
        stack[count] = entry;
        count++;
        
    }

    /**
     * Remove (pop off) the first value in the stack
     * @return temp : T - the data that was removed (type not specified)
     */
    @Override
    public T pop() {
        if (isEmpty())
        {
            return null;
        }
        count--;
        T temp = stack[count];
        stack[count] = null;
        return temp;
    }

    /**
     * Look (peek) at the first value in the stack
     * @return temp : T - the first data in the stack
     */
    @Override
    public T peek() {
        if (isEmpty())
        {
            return null;
        }
        return stack[count - 1];
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
     * @return bool : boolean - the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        if (count == 0)
            return true;
        return false;
    }
    
}







