/**
 * A driver that demonstrates the class List.
 * CSC 210 Data Structures
 * Semester 1 | Fall 2018
 * October 3, 2018
 * @author Joseph Hentges
 */
public class Driver
{
	public static void main(String[] args) 
	{
            testStringDoubleLinkedList();
            //testStringCircularLinkedList();
            //testStringCircularDoubleLinkedList();
            System.out.println("\n\nDone.");
	}  // end main
        
        public static void testStringCircularDoubleLinkedList()
        {
            ListInterface<String> myList = new CircularDoubleLinkedList<>();
            System.out.println("Testing add to end: Add 15, 25, 35, 45");
            myList.add("15");
            myList.add("25");
            myList.add("35");
            myList.add("45");
            System.out.println("\n\nList should contain\n15 25 35 45 ");
            displayList(myList);
            
            System.out.println("\nIs List empty? " + myList.isEmpty());

            System.out.println("Add more entries to end: Add 55, 65, 75, 85, 95");
            myList.add("55");
            myList.add("65");
            myList.add("75");
            myList.add("85");
            myList.add("95");
            
            System.out.println("-------------------------\n");
            System.out.println("\n\nList should contain 15 25 35 45 55 65 75 85 95");
            displayList(myList);
            
            System.out.println("\n------------------------\n");
            System.out.println("Testing clear() ");
            myList.clear();
            
            System.out.println("List should be empty: ");
            System.out.println("Is list empty? " + myList.isEmpty());
            
            System.out.println("\n\nList should contain ");
            displayList(myList);
            
            System.out.println("Add 15 at position 1:");
            myList.add(1, "15");
            System.out.println("Add 25 at position 2:");
            myList.add(2, "25");
            System.out.println("Add 35 at position 3:");
            myList.add(3, "35");
            System.out.println("Add 35 at position 3:");
            myList.add(3, "45");
            
            System.out.println("\n\nList should contain 15 25 45 35");
            displayList(myList); 
            
            myList.valuesFromEnd();
            
            System.out.println();
            
            myList.valuesInACircle();
            
            System.out.println("\nPrint an Array of the list.");
            Object[] arr = myList.toArray();
            for(int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            
            System.out.println("\nThe list contains 25: " + myList.contains("25"));
            
            System.out.println("Get elements from the list: ");
            System.out.println("Element at position 3 is: " + myList.getEntry(3));
            
            System.out.println("Replace the 2nd element in the list...");
            System.out.println("The element we replaced is: " + myList.replace(2, "99"));
            displayList(myList);
            
            System.out.println("Remove the 3rd element.");
            System.out.println("The element we removed is: " + myList.remove(3));
            displayList(myList);
            myList.valuesFromEnd();
            myList.valuesInACircle();
        }
        
        public static void testStringCircularLinkedList()
        {
            ListInterface<String> myList = new CircularLinkedList<>();
            System.out.println("Testing add to end: Add 15, 25, 35, 45");
            myList.add("15");
            myList.add("25");
            myList.add("35");
            myList.add("45");
            System.out.println("\n\nList should contain\n15 25 35 45 ");
            displayList(myList);
            
            System.out.println("\nIs List empty? " + myList.isEmpty());

            System.out.println("Add more entries to end: Add 55, 65, 75, 85, 95");
            myList.add("55");
            myList.add("65");
            myList.add("75");
            myList.add("85");
            myList.add("95");
            
            System.out.println("-------------------------\n");
            System.out.println("\n\nList should contain 15 25 35 45 55 65 75 85 95");
            displayList(myList);
            
            System.out.println("\n------------------------\n");
            System.out.println("Testing clear() ");
            myList.clear();
            
            System.out.println("List should be empty: ");
            System.out.println("Is list empty? " + myList.isEmpty());
            
            System.out.println("\n\nList should contain ");
            displayList(myList);
            
            System.out.println("Add 15 at position 1:");
            myList.add(1, "15");
            System.out.println("Add 25 at position 2:");
            myList.add(2, "25");
            System.out.println("Add 35 at position 3:");
            myList.add(3, "35");
            System.out.println("Add 35 at position 3:");
            myList.add(3, "45");
            
            System.out.println("\n\nList should contain 15 25 45 35");
            displayList(myList); 
            
            myList.valuesInACircle();
            
            System.out.println("\nPrint an Array of the list.");
            Object[] arr = myList.toArray();
            for(int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            
            System.out.println("\nThe list contains 25: " + myList.contains("25"));
            
            System.out.println("Get elements from the list: ");
            System.out.println("Element at position 3 is: " + myList.getEntry(3));
            
            System.out.println("Replace the 2nd element in the list...");
            System.out.println("The element we replaced is: " + myList.replace(2, "99"));
            displayList(myList);
            
            System.out.println("Remove the 3rd element.");
            System.out.println("The element we removed is: " + myList.remove(3));
            displayList(myList);
            myList.valuesInACircle();
        }
        
        public static void testStringDoubleLinkedList()
        {
            ListInterface<String> myList = new DoubleLinkedList<>();
            System.out.println("Testing add to end: Add 15, 25, 35, 45");
            myList.add("15");
            myList.add("25");
            myList.add("35");
            myList.add("45");
            System.out.println("\n\nList should contain\n15 25 35 45 ");
            displayList(myList);
            
            System.out.println("\nIs List empty? " + myList.isEmpty());

            System.out.println("Add more entries to end: Add 55, 65, 75, 85, 95");
            myList.add("55");
            myList.add("65");
            myList.add("75");
            myList.add("85");
            myList.add("95");
            
            System.out.println("-------------------------\n");
            System.out.println("\n\nList should contain 15 25 35 45 55 65 75 85 95");
            displayList(myList);
            
            myList.valuesFromEnd();
            
            System.out.println("\n------------------------\n");
            System.out.println("Testing clear() ");
            myList.clear();
            
            System.out.println("List should be empty: ");
            System.out.println("Is list empty? " + myList.isEmpty());
            
            System.out.println("\n\nList should contain ");
            displayList(myList);
            
            System.out.println("Add 15 at position 1:");
            myList.add(1, "15");
            System.out.println("Add 25 at position 2:");
            myList.add(2, "25");
            System.out.println("Add 35 at position 3:");
            myList.add(3, "35");
            System.out.println("Add 45 at position 3:");
            myList.add(3, "45");
            
            System.out.println("\n\nList should contain 15 25 45 35");
            displayList(myList); 
            
            myList.valuesFromEnd();
            
            System.out.println("\nPrint an Array of the list.");
            Object[] arr = myList.toArray();
            for(int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            
            System.out.println("\nThe list contains 25: " + myList.contains("25"));
            
            System.out.println("Get elements from the list: ");
            System.out.println("Element at position 3 is: " + myList.getEntry(3));
            
            System.out.println("Replace the 2nd element in the list...");
            System.out.println("The element we replaced is: " + myList.replace(2, "99"));
            displayList(myList);
            
            System.out.println("Remove the 3rd element.");
            System.out.println("The element we removed is: " + myList.remove(3));
            displayList(myList);
            myList.valuesFromEnd();
        }

   public static void displayList(ListInterface<String> list)
   {
      System.out.println(list.toString());
   }
}