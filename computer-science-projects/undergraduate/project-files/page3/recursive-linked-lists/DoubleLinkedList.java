
/**
 * This is the class file for a Double Linked List using recursion
 * CSC 210L Data Structures Lab
 * Lab #5 - Recursive Linked Lists
 * Semester 1 | Fall 2018
 * October 10, 2018
 * @author Joseph Hentges
 */

public class DoubleLinkedList<T> implements ListInterface<T> {
    
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
        //If the list is not empty
        //Need to find the end of the list
        Node newNode = new Node(newEntry);
        
        //If the list is empty set the first node pointer to this node
        if(numberOfEntries == 0)
        {
            firstNode = newNode;
        }
        else
        {
            Node lastNode = traverse(firstNode, numberOfEntries);
            newNode.setLastNode(lastNode);
            lastNode.setNextNode(newNode);           
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
        
        if(newPosition > numberOfEntries)
        {
            add(newEntry);
            return;
        }
        if(newPosition <= 1) //Add to the beggining of the list
        {
            Node nodeTemp = firstNode;
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            nodeTemp.setLastNode(firstNode);
        }
        else //Add the node to some place at the beginning or end of the list
        {
            Node lastNode = traverse(firstNode, newPosition-1);
            newNode.setLastNode(lastNode);
            newNode.setNextNode(lastNode.getNextNode());
            lastNode.setNextNode(newNode);
            newNode.getNextNode().setLastNode(newNode);
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
        //Check and set position entry
        if(givenPosition >= numberOfEntries)
        {
            givenPosition = numberOfEntries;
        }
        if(givenPosition <= 1)
        {
            data = firstNode.getData();
            firstNode = firstNode.getNextNode();
            firstNode.setLastNode(null);
            numberOfEntries--;
            return data;
        }
        Node theNode = traverse(firstNode, givenPosition); //Traverse to the node to be removed and returned
        Node nextNode = theNode.getNextNode();
        Node lastNode = theNode.getLastNode();
        data = theNode.getData();
        lastNode.setNextNode(nextNode);
        //Check to make sure nextNode is not null, will error if it tries to set the next node's last
        if(nextNode != null)
            nextNode.setLastNode(lastNode);
        numberOfEntries--;
        return data;
    }

    /**
     * reset the list, clear of all nodes and set numberOfEntries to 0
     */
    @Override
    public void clear() {
        initializeDataFields(); //call the methods that resets the list, and sets everything to 0
    }

    /**
     * Replace the data at a given position
     * @param givenPosition : int - given position
     * @param newEntry : T - Data to be changed to in the given poistions node
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

        if (find(anEntry, currentNode) != null)
            found = true;
        
        return found;
    }
    
    /**
     * Recursively find a given data entry
     * @param entry Data to find
     * @param curr Current node to look at
     * @return the Data we found (or a null if not found)
     */
    private T find(T entry, Node curr)
    {
        if (curr == null)
            return null;
        
        if (entry.equals(curr.getData()))
            return curr.getData();
        
        return find(entry,curr.getNextNode());
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * Return whether the list is empty or not.
     * @return result : boolean - whether the list is empty or not 
     */
    @Override
    public boolean isEmpty() {
        boolean result = false;

        if (numberOfEntries == 0) // Or getLength() == 0
        {
            result = true;
        }

        return result;
    }

    /**
     * Unused in this class
     * Only used in circular linked lists
     */
    @Override
    public void valuesInACircle() {
        System.out.println("NOT USED IN THIS TYPE OF LIST");
    }
    
    /**
     * This is the constructor for a Node.
     * It contains the node getter and setters for its variables (data, next and last)
     */
    private class Node
    {

        private T data; // Entry in list
        private Node next; // Link to next node
        private Node last;

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
            last = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode, Node lastNode)
        {
            data = dataPortion;
            next = nextNode;
            last = lastNode;
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
        
        private Node getLastNode()
        {
            return last;
        }
        
        private void setLastNode(Node lastNode)
        {
            last = lastNode;
        }
    } 
    
    /**
     * Initializes the class data fields to indicate an empty list.
     */
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields
    
    /**
     * Go to the last node/element in the list, and read there data backwards.
     * This shows the list is double linked.
     * Non-Recursive since it is only used for testing
     */
    @Override
    public void valuesFromEnd()
    {
        System.out.println("The number of elements: " + numberOfEntries);
        Node curr = firstNode;
        for(int i = 0; i < numberOfEntries-1; i++)
        {
            curr = curr.getNextNode();
        }
        System.out.println("The list is currently on the last item. Item data: " + curr.getData());
        System.out.println("Going backwards in the list now...");
        for(int i = 0; i < numberOfEntries; i++)
        {
            System.out.println("Current item data: " + curr.getData());
            curr = curr.getLastNode();
        }
    } 
}
