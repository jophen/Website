
import java.util.Random;

/**
 * This file shows the HeapSort sorting algorithm.
 * Semester 1 | Fall 2018
 * October 7, 2018
 * @author Joseph Hentges
 */

public class HeapSortAlgorithm {
    
    /**
     * Run the program methods from here.
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        
        int size = 100;
        int[] randomArray = createRandomIntArray(size); //create a new array and fill it with random integer values
        System.out.println(arrayToString(randomArray));
        HEAP_SORT(randomArray, randomArray.length);
        System.out.println(arrayToString(randomArray));
    }
    
    /**
     * Create and return an array filled with random integers
     * @param size : int - the size of the array to be created
     * @return array : int[] - the array with random integer values
     */
    public static int[] createRandomIntArray(int size)
    {
        int[] array = new int[size];
        Random gen = new Random();
        for(int i = 0; i < size; i++)
        {
           array[i] = gen.nextInt(1000)+1; 
        }
        return array;
    }
    
    
    /**
     * Get the parent index of the child in index i
     * @param i : int - index to find the parent of
     * @return int - the index of the child's parent
     */
    public static int Parent(int i)
    {
        return i / 2;
    }
    
    /**
     * Get the further left most index of a parents children
     * @param i : int - the parent index
     * @return int - the further left most index (child) of that parent
     */
    public static int Left(int i)
    {
        return i * 2 + 1;
    }
    
    /**
     * Get the further right most index of a parents children
     * @param i : int - the parent index
     * @return int - the further right most index (child) of that parent
     */
    public static int Right(int i)
    {
        return i * 2 + 2;
    }
    
    /**
     * Turn any normal array into a max heap.
     * @param A : int[] - The array to be sorted
     * @param n : int - The length of the array
     */
    public static void BUILD_MAX_HEAP(int[] A, int n)
    {       
        for(int i = n/2; i >= 0; i--)
        {
            MAX_HEAPIFY(A, i, n);
        }
    }
    
    /*
     * Move the node (element) to its correct positon, whether it should be the parent or child
     * @param A : int[] - array to be sorted
     * @param i : int - the index of the current child
     * @param n : int - the length of the array
     */
    public static void MAX_HEAPIFY(int[] A, int i,int n)
    { 
        int largest = i;
        int l = Left(i);
        int r = Right(i);
        if(l < n && A[l] > A[largest])
        {
            largest = l;
        }
        if(r < n && A[r] > A[largest])
        {
            largest = r;
        }
        if(largest != i)
        {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            MAX_HEAPIFY(A, largest, n);
        }
    }
    
    /**
     * Call this method to sort an array. 
     * This method calls all other methods to complete the sort.
     * @param A : int[] - the array to be sorted
     * @param n : int - the length of the array
     */
    public static void HEAP_SORT(int[] A, int n)
    {       
        BUILD_MAX_HEAP(A, n);
        for(int i = n-1; i >= 1; i--)
        {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            MAX_HEAPIFY(A, 0, i);
        }
    }
    
    /**
     * Get s String of all the values in a given array. Used in a print statement to show its elements.
     * @param array : int[] - The array to have its elements printed
     * @return output : String - A String of all the elements in the given array-Formated nice
     */
    public static String arrayToString(int[] array)
    {
        String output = "The elements in the array:\n";
        for(int i = 0; i < array.length; i++)
        {
            output += "\tElement " + i + ":\t " + array[i] + "\n";
        }       
        return output;
    }
}
