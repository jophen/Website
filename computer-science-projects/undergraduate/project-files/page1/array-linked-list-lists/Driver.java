/**
 * This is the driver for Lists
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 24, 2018
 * @author Joseph Hentges
 */

public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //HentgesList myList = new LinkBasedList();
        HentgesList myList = new ArrayBasedList();
        
        //Java provided built in classes
        //Vector myList = new Vector();
        //ArrayList myList = new ArrayList();
        //LinkedList myList = new LinkedList();
        
        System.out.println(myList);
        
        //Add a few items to the list
        for(int i = 0; i < 20; i++)
        {
            myList.add(i*9);
        }
        myList.add(19, 520);
        System.out.println(myList);
        //Test isEmpty() method
        System.out.println("The list is empty: " + myList.isEmpty());
        
        //Use of getEntryAt() method
        System.out.println("Get the item at position 16: " + myList.getEntryAt(16));
        //Error testing, get item at position 0 (-1 in the array)
        System.out.println("Get the item at position 0: " + myList.getEntryAt(0));
        //Error testing, get item at position 24 (larger than the number of items in the array)
        System.out.println("Get the item at position 24: " + myList.getEntryAt(24));
        
        //Testing the contains() method. First element
        System.out.println("The list contains 0: " + myList.contains(0));
        //Testing the contains() method. Middle Element
        System.out.println("The list contains 10: " + myList.contains(10));
        //Testing the contains() method. Last element
        System.out.println("The list contains 19: " + myList.contains(19));
        //Testing the contains() method. Something not in the list
        System.out.println("The list contains 200: " + myList.contains(200));
        
        //Testing the remove() method. Last Element
        System.out.println("Removed item at position 21. The value removed is: " + myList.remove(21));
        //Testing the remove() method. First Element
        System.out.println("Removed item at position 1. The value removed is: " + myList.remove(1));
        //Testing the remove() method. Middle Element
        System.out.println("Removed item at position 10. The value removed is: " + myList.remove(10));
        //Testing the remove() method. Element off the Array | Too High
        System.out.println("Removed item at position 500. The value removed is: " + myList.remove(500));
        //Testing the remove() method. Element off the Array | Too Low
        System.out.println("Removed item at position -50. The value removed is: " + myList.remove(-50));
        System.out.println(myList);
        
        //Testing the toArray() method.
        int[] array = myList.toArray();
        for(int i = 0; i < array.length; i++)
        {
            System.out.println("Element in array at index " + i + " is: " + array[i]);
        }
        
        //Testing the clear method
        myList.clear();
        System.out.println(myList);
        
        //Testing get getEntryAt() when the list is empty
        System.out.println("Get the item at position 6: " + myList.getEntryAt(6));
        
        //Test isEmpty() method
        System.out.println("The list is empty: " + myList.isEmpty());
    }
    
}
