
import java.util.ArrayList;
import java.util.Arrays;


/**
 * This is the class for the ArrayBag. It implements BagInterface
 * CSC 210 Data Structures Lab
 * September 26, 2018
 * @author Joseph Hentges
 */
public final class ResizableArrayBag<T> implements BagInterface<T>
{

    private T[] bag; // Cannot be final due to doubling
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param initialCapacity The integer capacity desired.
     */
    public ResizableArrayBag(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[initialCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    } // end constructor

    /**
     * Creates a bag containing given entries.
     *
     * @param contents An array of objects.
     */
    public ResizableArrayBag(T[] contents)
    {
        //Create an arrayList to hold onto the values that are not duplicates of any other in the contents array
        ArrayList<T> holdArrayList = new ArrayList<T>();
        for(int i = 0; i < contents.length; i++)
        {
            //Check for duplicates
            if(!holdArrayList.contains(contents[i]))
            {
                holdArrayList.add(contents[i]);
            }
        }
        contents = (T[])holdArrayList.toArray(); //make contents equal the new values from holdArrayList
        checkCapacity(contents.length);
        bag = Arrays.copyOf(contents, contents.length);
        numberOfEntries = contents.length;
        initialized = true;
    } // end constructor
    
    /**
     * Creates a new bag that combines the contents of this bag and anotherBag.
     * No duplicates
     * @param anotherBag The bag that is to be added.
     * @return A combined bag.
     */
    public BagInterface<T> union(BagInterface<T> anotherBag)
    {
        //Check if the testBag is an instance of a ResizableArrayBag, if it's not return null
        if(!(anotherBag instanceof ResizableArrayBag))
        {
           return null;
        }

        //Create an set a max size. This is used in the for loop to determine how many times I need to run through the arrays
        int maxSize = 0;
        if(numberOfEntries > anotherBag.getCurrentSize())
        {
            maxSize = numberOfEntries;
        }
        else
        {
            maxSize = anotherBag.getCurrentSize();
        }
        
        //Create a new bag to be returned with the correct values
        BagInterface<T> unionBag = new ResizableArrayBag<>(); //create a new bag to be returned
        
        //Add all values from the two bags
        //Don't add duplicates
        for(int i = 0; i < maxSize; i++)
        {
            if(maxSize == numberOfEntries)
            {
                unionBag.add(bag[i]);
                if(!unionBag.contains(anotherBag.toArray()[i]))
                {
                    unionBag.add(anotherBag.toArray()[i]);
                }
            }
            else
            {
                if(i < numberOfEntries)
                {
                    unionBag.add(bag[i]);
                }
                if(!(unionBag.contains(anotherBag.toArray()[i])))
                {
                    unionBag.add(anotherBag.toArray()[i]);
                }
            }
        }
        return unionBag;
    }
    
    /**
     * Creates a new bag that contains those objects that are present in both this bag
     * and anotherBag.
     * @param anotherBag The bag that is to be compared.
     * @return A combined bag.
     */
    public BagInterface<T> intersection(BagInterface<T> anotherBag)
    {
        //Check if the testBag is an instance of a ResizableArrayBag, if it's not return null
        if(!(anotherBag instanceof ResizableArrayBag))
        {
           return null;
        }

        //if both bags already contain the same values, just return anotherBag
        if(bag.equals(anotherBag))
        {
            return anotherBag;
        }

        //A minSize used in a for loop below. Used to determine how many times I need to run through the arrays
        int minSize = 0;
        if(numberOfEntries < anotherBag.getCurrentSize())
        {
            minSize = numberOfEntries;
        }
        else
        {
            minSize = anotherBag.getCurrentSize();
        }
        
        //Create a new bag to be returned with the correct values
        BagInterface<T> intersectionBag = new ResizableArrayBag<>();
        
        //If each bag contains the same value, add it to the intersectionBag
        for(int i = 0; i < minSize; i++)
        {
            if(anotherBag.contains(bag[i]))
            {
                intersectionBag.add(bag[i]);
            } 
        }
        return intersectionBag;
    }
    
    /**
     * Creates a new bag of objects appeared in both bags.
     * But are not shared by the both of them. 
     * @param anotherBag The bag that is to be removed.
     * @return A combined bag.
     */
    public BagInterface<T> difference(BagInterface<T> anotherBag)
    {
        //Check if the testBag is an instance of a ResizableArrayBag, if it's not return null
        if(!(anotherBag instanceof ResizableArrayBag))
        {
           return null;
        }

        //Create an set a max size. This is used in the for loop to determine how many times I need to run through the arrays
        int maxSize = 0;
        if(numberOfEntries > anotherBag.getCurrentSize())
        {
            maxSize = numberOfEntries;
        }
        else
        {
            maxSize = anotherBag.getCurrentSize();
        }
        
        //Create a new bag, to be returned with the correct values
        BagInterface<T> differenceBag = new ResizableArrayBag<>();
        
        for(int i = 0; i < maxSize; i++)
        {
            if(maxSize == numberOfEntries)
            {
                if(!anotherBag.contains(bag[i]))
                {
                    differenceBag.add(bag[i]);
                }
                if(i < anotherBag.getCurrentSize())
                {
                    if(!this.contains(anotherBag.toArray()[i]))
                    {
                        differenceBag.add(anotherBag.toArray()[i]);
                    }
                }
            }
            else
            {
                if(!this.contains(anotherBag.toArray()[i]))
                {
                    differenceBag.add(anotherBag.toArray()[i]);
                }  
                if(i < numberOfEntries)
                {
                    if(!anotherBag.contains(bag[i]))
                    {
                        differenceBag.add(bag[i]);
                    }
                }
            }
        }
        return differenceBag;
    }
    
    /**
     * Test two bags to see if they contain the same values
     * @param testBag : BagInterface - A bag to be tested against the current bag
     * @return boolean - whether the two bags are equal
     */
    public boolean equal(BagInterface<T> testBag)
    {
        //Check if the testBag is an instance of a ResizableArrayBag
        if(!(testBag instanceof ResizableArrayBag))
        {
           return false; 
        }
        //Check if the bags lenth are equal
        if(!(bag.length == testBag.getCurrentSize()))
        {
            return false;
        }
        //Use a for loop to see if the testBag contains all values in the bag
        for(int i = 0; i < numberOfEntries; i++)
        {
            //Return false if the bag does not contain a certain value
            //Ex if the bag does not contain the value at bag[2], return false
            if(!testBag.contains(bag[i]))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Used in the add() method. This tests the entry for duplicates in the bag.
     * return true if the entry does already appear in the bag, false if otherwise
     * @param newEntry : T - a possible entry to the bag
     * @return boolean - whether it is okay or not to add this entry to the bag
     */
    public boolean checkDuplicate(T newEntry)
    {
        //For loop to run through all the values in bag. Checks for equal values
        for(int i = 0; i < numberOfEntries; i++)
        {
            if(newEntry == bag[i])
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True.
     */
    public boolean add(T newEntry)
    {
        checkInitialization();
        if (isArrayFull())
        {
            doubleCapacity();
        } // end if
        
        //Check if the newEntry is a duplicate of any other entry
        if(checkDuplicate(newEntry))
        {
            return false;
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;

        return true;
    } // end add

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray()
    {
        checkInitialization();

        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        } // end for

        return result;
    } // end toArray

    /**
     * Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end getCurrentSize

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this ba.
     */
    public int getFrequencyOf(T anEntry)
    {
        checkInitialization();
        int counter = 0;

        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter++;
            } // end if
        } // end for

        return counter;
    } // end getFrequencyOf

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if this bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry)
    {
        checkInitialization();
        return getIndexOf(anEntry) > -1; // or >= 0
    } // end contains

    /**
     * Removes all entries from this bag.
     */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    } // end clear

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove()
    {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    } // end remove

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry)
    {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    } // end remove

    // Locates a given entry within the array bag.
    // Returns the index of the entry, if located,
    // or -1 otherwise.
    // Precondition: checkInitialization has been called.
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            } // end if
            index++;
        } // end while

        // Assertion: If where > -1, anEntry is in the array bag, and it
        // equals bag[where]; otherwise, anEntry is not in the array.
        return where;
    } // end getIndexOf

    // Removes and returns the entry at a given index within the array.
    // If no such entry exists, returns null.
    // Precondition: 0 <= givenIndex < numberOfEntries.
    // Precondition: checkInitialization has been called.
    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];          // Entry to remove
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
            bag[lastIndex] = null;             // Remove reference to last entry
            numberOfEntries--;
        } // end if

        return result;
    } // end removeEntry

    // Returns true if the array bag is full, or false if not.
    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    } // end isArrayFull

    // Doubles the size of the array bag.
    // Precondition: checkInitialization has been called.
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    } // end doubleCapacity

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds "
                    + "allowed maximum of " + MAX_CAPACITY);
        }
    } // end checkCapacity

    // Throws an exception if receiving object is not initialized.
    private void checkInitialization()
    {
        if (!initialized)
        {
            throw new SecurityException("Uninitialized object used "
                    + "to call an ArrayBag method.");
        }
    } // end checkInitialization
} // end ResizableArrayBag

