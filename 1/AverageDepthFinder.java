import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;



// Imports a file input.txt and then determines the number of numbers where the immediate previous number is smaller than the current number
public class AverageDepthFinder {
    public static void main(String[] args) {
        try {
            // Import file and data
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            ArrayList<Integer> array = new ArrayList<Integer>();
            Integer total = new Integer(0);
            
            // Create array
            while (reader.hasNextLine()) {
                String nextLine = reader.nextLine();
                Integer i = Integer.parseInt(nextLine);
                array.add(i);
            }
            // System.out.println("Test compile");
            // System.out.println(array);
            
            // for average depthfinder, there is a 'aggregate' of 3 numbers.
            // However, since two of the numbers are shared between the comparisons,
            // what ultimately is being checked is if (n-3) is less than n. 
            for (int i = 3; i<array.size(); i++) {
                if(array.get(i)>array.get(i-3)) {
                    total += 1;
                }
            }

            System.out.println("Total is " + total);
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}