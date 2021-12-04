import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;



// Imports a file input.txt and then determines the number of numbers where the immediate previous number is smaller than the current number
public class DepthFinder {
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
            
            // In an array,
            // Determine if index n-1 < n, and count the number of times this is true
            // return the result
            for (int i = 1; i<array.size(); i++) {
                if(array.get(i)>array.get(i-1)) {
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