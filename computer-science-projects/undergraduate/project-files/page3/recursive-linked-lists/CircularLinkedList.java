
/**
 * This is the class file for a Circular Linked List using recursion
 * CSC 210L Data Structures Lab
 * Lab #5 - Recursive Linked Lists
 * Semester 1 | Fall 2018
 * October 10, 2018
 * @author Joseph Hentges
 */

public class CircularLinkedList<T> implements ListInterface<T> {
    
    private Node firstNode;            // Reference to first node of chain
    private int numberOfEntries;

    /**
     * Traverse the list to a given position.
     * @param current : Node - The node the traverse method is currently on
     * @param position : int - The position number (index) the traverse is currently on
     * @return Node - A node that the traverse method moves to
     */
    public Node traverse(Node current, int position)
    {        
        if(position <= 1)
        {
            return current;
        }
        if(position > numberOfEntries)
        {
            position = numberOfEntries;
        }
        return traverse(current.getNextNode(), position-1);
        
    }
    
    /**
     * Add item to the end of the list
     * @param newEntry : T - item to be added
     */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        
        //If the list is empty set the first node pointer to this node
        if(numberOfEntries == 0)
        {
            firstNode = newNode;
        }
        else
        {
            Node lastNode = traverse(firstNode, numberOfEntries); //Get the last node in the list
            lastNode.setNextNode(newNode); //have the last node point to the new node
        }
        numberOfEntries++;
    }

    /**
     * Given a position, add the element to somewhere in the list
     * @param newPosition : int - a given position
     * @param newEntry : T - Some given data
     */
    @Override
    public void add(int newPosition, T newEntry) {
        Node newNode = new Node(newEntry);
        
        if(newPosition > numberOfEntries) //add to the end of the list
        {
            add(newEntry);
            return;
        }
        if(newPosition <= 1) //Add to the beggining of the list
        {
            Node nodeTemp = firstNode;
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
        else //Add the node to some place at the beginning or end of the list
        {
            Node lastNode = traverse(firstNode, newPosition-1);
            newNode.setNextNode(lastNode.getNextNode());
            lastNode.setNextNode(newNode);
        }
        numberOfEntries++;
    }

    /**
     * Remove the node at a given posiiton, and return its data
     * @param givenPosition : int - The given position to have its node removed
     * @return T : data - The data at the given position
     */
    @Override
    public T remove(int givenPosition) {
        T data;
        //Check and set position
        if(givenPosition >= numberOfEntries) //remove the last entry in the list
        {
            givenPosition = numberOfEntries;
        }
        if(givenPosition <= 1) //remove the first entry in the list
        {
            data = firstNode.getData();
            traverse(firstNode, numberOfEntries).setNextNode(firstNode.getNextNode()); //set the last nodes next pointer to point to firstNodes next node
            firstNode = firstNode.getNextNode(); //change the first pointer to point to firstNode's next
            numberOfEntries--;
            return data;
        }
        //Remove the last or a middle entry in the list
        Node theNode = traverse(firstNode, givenPosition-1); //Traverse to the node before the node to be removed and returned
        data = theNode.getNextNode().getData();
        theNode.setNextNode(theNode.getNextNode().getNextNode());
        numberOfEntries--;
        return data;
    }

    /**
     * Cleat the list of all data.
     * Set the numberOfEntries variable to 0
     */
    @Override
    public void clear() {
        initializeDataFields();
    }

    /**
     * Replace the data at a given position
     * @param givenPosition : int - given position
     * @param newEntry : T - Data to be changed to in the given positions node
     * @return dataHold : T - The data originally in the node
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        T dataHold;
        //Set the givenPosition if outside the list boundries
        if(givenPosition > numberOfEntries) //get the node's data
        {
            Node original = traverse(firstNode, numberOfEntries); //the node originally in the given position
            dataHold = original.getData();
            original.setData(newEntry);
        }
        if(givenPosition <= 1) //get first nodes data
        {
             dataHold = firstNode.getData();
             firstNode.setData(newEntry);
        }
        else //get somewhere in the middle of the lists data
        {
            Node original = traverse(firstNode, givenPosition); //the node originally in the given position
            dataHold = original.getData();
            original.setData(newEntry);
        }
        return dataHold;
    }

    /**
     * Get the data of a node in a given position in the list
     * @param givenPosition : int - index in the list
     * @return data - data from the node of the given position in the list
     */
    @Override
    public T getEntry(int givenPosition) {
        //Set the givenPosition if outside the list boundries
        if(givenPosition > numberOfEntries) //get the node's data
        {
            return traverse(firstNode, numberOfEntries).getData();
        }
        if(givenPosition <= 1) //get first nodes data
        {
            return firstNode.getData();
        }
        else //get somewhere in the middle of the lists data
        {
            return traverse(firstNode, givenPosition).getData();
        }
    }

    /**
     * Get an array of the elements from the list
     * @return output : T[] - an array of all the elements in the list
     */
    @Override
    public T[] toArray() {
        T[] output = (T[]) new Object[numberOfEntries]; //array to be returned. Will contain the data in each node      
        
        int index = 0;
        Node currentNode = firstNode;
        output = copy(output, currentNode, index);
        
        return output;
    }
    
    /**
     * This method recursively copies data from the linked list to an Array
     * @param newArray Array which will eventually contain the elements in the list
     * @param curr Node pointing to the current spot in the list
     * @param index value for where we are in the list
     * @return The updated array which now contains all the elements in the list
     */
    private T[] copy(T[] newArray, Node current, int index)
    {
        if (index == numberOfEntries)
        {
            return newArray;
        }
        
        newArray = copy(newArray, current.getNextNode(), index + 1);
        newArray[index] = current.getData();
        return newArray;
    }

    /**
     * Determine whether the list contains certain data
     * @param anEntry : Node - data to be found the in the list
     * @return found : boolean - whether the list contains certain data or not.
     */
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        if (find(anEntry, currentNode, 1) != null)
            found = true;
        
        return found;
    }
    
    /**
     * Recursively find a given data entry
     * @param entry Data to find
     * @param curr Current node to look at
     * @return the Data we found (or a null if not found)
     */
    private T find(T entry, Node curr, int count)
    {
        if (curr == null || count == numberOfEntries+1)
            return null;
        
        if (entry.equals(curr.getData()))
            return curr.getData();
        
        return find(entry,curr.getNextNode(), count+1);
    }

    /**
     * Get the length of the list
     * @return numberOfEntries : the length of the list
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * return whether the list is empty or not
     * @return boolean -  the list is empty or not
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries <= 0;
    }

    /**
     * Unused in this class
     * Only used in double linked lists
     */
    @Override
    public void valuesFromEnd() {
        System.out.println("NOT USED IN THIS TYPE OF LIST");
    }

    /**
     * Use this method to show the linked list is circular
     * Non-Recursive since it is only used for testing
     */
    @Override
    public void valuesInACircle() {
        System.out.println("Get values in a cirlce. Starting from the first node.");
        Node curr = firstNode;
        for(int i = 0; i < numberOfEntries*3; i++)
        {
            System.out.println("Current item data:" + curr.data);
            curr = curr.next;
        }
    }
    
    /**
     * This is the constructor for a Node.
     * It contains the node getter and setters for its variables (data and next)
     */
    private class Node
    {

        private T data; // Entry in list
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = firstNode;
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private T getData()
        {
            return data;
        } 

        private void setData(T newData)
        {
            data = newData;
        }

        private Node getNextNode()
        {
            return next;
        }

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    } 
    
    /**
     * Initializes the class data fields to indicate an empty list.
     */
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
}
