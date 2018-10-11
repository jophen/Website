
/**
 * This is the driver file to test run the methods in lists.
 * CSC 210L Data Structures Lab
 * Lab #5 - Recursive Linked Lists
 * Semester 1 | Fall 2018
 * October 10, 2018
 * @author Joseph Hentges
 */

public class Driver {
    
    
    public static void main(String[] args) 
    {
        createAndTestList();
        System.out.println("\n\nDone.");
    }
    
    public static void createAndTestList()
    {
        ListInterface<String> myList = new CircularLinkedList<>();
        
        //Add elements and display list
        System.out.println("Testing add to end: Add 15, 25, 35, 45");
        myList.add("15");
        myList.add("25");
        myList.add("35");
        myList.add("45");
        
        System.out.println("\nList should contain\n15 25 35 45 ");
	displayList(myList);
        
        //Test the isEmpty() method in the list
        System.out.println("\nIs List empty? " + myList.isEmpty());
        
        //Add some more elements to the list and display
        System.out.println("Add more entries to end: Add 55, 65, 75, 85, 95");
        myList.add("55");
        myList.add("65");
        myList.add("75");
        myList.add("85");
        myList.add("95");
        System.out.println("\nDisplay the list: ");
        displayList(myList);
        System.out.println("\nDisplay the list starting from the end:");
        myList.valuesFromEnd();
        System.out.println("\nDisplay the list in a circle:");
        myList.valuesInACircle();
        
        System.out.println("\nTesting the clear method in the list: ");
        myList.clear();
        System.out.println("Is List empty? " + myList.isEmpty());
        System.out.println("Display the list: ");
        displayList(myList);
        
        //Create a new list to test
        System.out.println("-------------------------\n");
        System.out.println("Create a new list.\n");
        myList = new CircularLinkedList<>();
        displayList(myList);
        
        //Add elements to the list using the add with posiiton method
        System.out.println("Add 15 at position 1:");
        myList.add(1, "15");
        System.out.println("Add 25 at position 2:");
        myList.add(2, "25");
        System.out.println("Add 35 at position 3:");
        myList.add(3, "35");
        System.out.println("Add 19 at position 1:");
        myList.add(1, "19");
        System.out.println("Add 39 at position 3:");
        myList.add(3, "39");
        System.out.println("Add 29 at position 2:");
        myList.add(2, "29");
	System.out.println("Add 55 at position 7:");
        myList.add(myList.getLength()+1, "55");
        displayList(myList);
	System.out.println("Add 65 at position 8:");
        myList.add(8, "65");
        displayList(myList);
        System.out.println("\nDisplay the list starting from the end:");
        myList.valuesFromEnd();
        System.out.println("\nDisplay the list in a circle:");
        myList.valuesInACircle();
        System.out.println("Is List empty? " + myList.isEmpty());
        
        //Testing the remove method in a list
        System.out.println("\n-------------------------");
        System.out.println("Testing remove() ");
        System.out.println("Removing 15 at position 3: returns " + myList.remove(3));  
        System.out.println("Removing 19 at position 1: returns " + myList.remove(1));
        System.out.println("Removing 65 at position 6: returns " + myList.remove(6));
        System.out.println("\nDisplay the list in a circle:");
        myList.valuesInACircle();
        System.out.println("\nList should contain\n29 39 25 35 55");
        displayList(myList);
        
        //Testing the replace method in a list
        System.out.println("\n-------------------------\n");
        System.out.println("Testing replace() ");
        System.out.println("Replace 29 at position 1 with 92 : returns " + myList.replace(1, "92"));
        System.out.println("Replace 39 at position 2 with 93 : returns " + myList.replace(2, "93"));
        System.out.println("Replace 25 at position 3 with 52 : returns " + myList.replace(3, "52"));
        System.out.println("Replace 35 at position 4 with 53 : returns " + myList.replace(4, "53"));
        System.out.println("Replace 55 at position 5 with 50 : returns " + myList.replace(5, "50"));

        System.out.println("\n\nList should contain\n92 93 52 53 50");
        displayList(myList);
        
        System.out.println("Is List empty? " + myList.isEmpty());
	
        //Testing the get entry method in a list
        System.out.println("\n-------------------------\n");
        System.out.println("Testing getEntry() ");
        int numberOfEntries = myList.getLength();

        System.out.println("\nThe list contains " + numberOfEntries +
                           " entries, as follows:");
        for (int position = 1; position <= numberOfEntries; position++)
           System.out.println(myList.getEntry(position) +
                              " is entry " + position);
        //Test the contains method in a list
        System.out.println();
        System.out.println("\n-------------------------\n");
        System.out.println("Testing contains() [results should be TRUE]");
        System.out.println("List contains 92: " + myList.contains("92"));
        System.out.println("List contains 52: " + myList.contains("52"));
        System.out.println("List contains 53: " + myList.contains("53"));
        System.out.println("List contains 50: " + myList.contains("50"));
        System.out.println("\n");

        System.out.println("Testing contains() [results should be FALSE]");
        System.out.println("List contains 91 returns : " + myList.contains("91"));
        System.out.println("List contains 55 returns : " + myList.contains("55"));
        System.out.println("List contains 4  returns : " + myList.contains("4"));
        System.out.println("List contains 12 returns : " + myList.contains("12"));
        
        //One final test to see if it all works
        System.out.println("\n------------------------The Final Test----------------------------\n");
        displayList(myList);
        System.out.println("\nDisplay the list starting from the end:");
        myList.valuesFromEnd();
        System.out.println("\nDisplay the list in a circle:");
        myList.valuesInACircle();
    }
    

    /**
     * Print the given list
     * @param list : a list
     */
    public static void displayList(ListInterface<String> list)
    {
        System.out.println("The list contains " + list.getLength() +
                           " string(s), as follows:");
        Object[] listArray = list.toArray();
        for (int index = 0; index < listArray.length; index++)
        {
           System.out.print(listArray[index] + " ");
        } // end for

        System.out.println();
    }
}
