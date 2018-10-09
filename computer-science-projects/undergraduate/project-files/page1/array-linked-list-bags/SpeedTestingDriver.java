import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Testing Bags
 * @author kerlin
 */
public class SpeedTestingDriver
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Random gen = new Random();
        int size = 100000000;
        

        int[] data = new int[size];
        for (int i = 0; i < size; i++)
        {
            data[i] = gen.nextInt();
        }

        //Adds data
        System.out.println("-----Array Bag-------------------");
        long startTime = System.nanoTime();
        BagArray aBag = new BagArray(size);
        for (int x = 0; x < data.length; x++)
        {
            aBag.add(data[x]);
        }
        long endTime = System.nanoTime();
        long output = (endTime - startTime);
        System.out.println("\tAdd Time:\n\t\t" + output + " nano seconds");

        //Removes Data
        startTime = System.nanoTime();
        aBag.removeLessThanZero();
        endTime = System.nanoTime();
        output = (endTime - startTime);
        System.out.println("\tRemove Time:\n\t\t" + output + " nano seconds");
        
        //Adds data
        System.out.println("-----Linked Bag-------------------");
        startTime = System.nanoTime();
        BagLinked lBag = new BagLinked();
        for (int x = 0; x < data.length; x++)
        {
            lBag.add(data[x]);
        }
        endTime = System.nanoTime();
        output = (endTime - startTime);
        System.out.println("\tAdd Time:\n\t\t" + output + " nano seconds");

        //Removes Data
        startTime = System.nanoTime();
        lBag.removeLessThanZero();
        endTime = System.nanoTime();
        output = (endTime - startTime);
        System.out.println("\tRemove Time:\n\t\t" + output + " nano seconds");


    }
    
}
