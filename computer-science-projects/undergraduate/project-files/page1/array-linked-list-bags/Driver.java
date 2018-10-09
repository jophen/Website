/**
 * This is the Driver for Bags
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * September 19, 2018
 * @author Joseph Hentges
 */

public class Driver {
    
    /**
     * @param args : String -  the command line arguments 
     */
    public static void main(String args[])
    {
        //Create a new bag (of integers), that holds 10 integers
        //Bag<Integer> myBag = new BagArray<Integer>(10);
        Bag<Integer> myBag = new BagLinked<Integer>();
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        myBag.add(123);
        myBag.add(9521);
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        for(int i = 0; i < 12; i++)
        {
            myBag.add(i);
        }
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        Integer myobj = myBag.remove();
        System.out.println(myBag);
        System.out.println("There are: " + myBag.size() + " items.");
        System.out.println("We removed: " + myobj);
        
        myBag.clear();
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        for(int i = 0; i < 12; i++)
        {
            myBag.add(i);
        }
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        //Test the removeAll() method. Place the removed data into an array
        Object[] temp = myBag.removeAll();
        Integer[] data2 = new Integer[temp.length];
        for(int i = 0; i < temp.length; i++)
        {
            data2[i] = (Integer) temp[i];
        }
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        for(int i = 0; i < temp.length; i++)
        {
            System.out.println(data2[i]);
        }
        
        //Fill the bag to test the methods: howMany() and contains()
        for(int i = 0; i < 12; i++)
        {
            myBag.add(i);
        }
        
        System.out.println(myBag);
        
        System.out.println("There are: " + myBag.size() + " items.");
        
        System.out.println("The number of: " + 8 + " in the bag is: " + myBag.howMany(8));
        
        System.out.println("The bag does contain: " + 9 + " | " + myBag.contains(9));
    }
}
