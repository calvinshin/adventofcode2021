import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class GammaEpsilonProductNoMatrix {
    public static void main(String[] args) {
        try {
            // Import file and data
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            ArrayList<String> rawArray = new ArrayList<String>();

            // Create a matrix given the length/width of an input
            // Create first an array of strings
            while (reader.hasNextLine()) {
                String nextLine =  reader.nextLine();
                rawArray.add(nextLine);
            }

            int col = rawArray.get(0).length();
            int row = rawArray.size();

            // Creating matrix, gamma, and epsilon
            String gammaString = new String();
            String epsilonString = new String();
            Character zero = new Character('0');
            Character one = new Character('1');

            for(int j = 0; j<col; j++) {
                int countOfZero = 0;
                int countOfOne = 0;

                for(int i = 0; i<row; i++) {
                    if(rawArray.get(i).charAt(j) == zero) {
                        countOfZero += 1;
                    }
                    else {
                        countOfOne += 1;
                    }
                }

                if(countOfZero > countOfOne) {
                    gammaString += "0";
                    epsilonString += "1";
                }
                else {
                    gammaString += "1";
                    epsilonString += "0";
                }
            }

            // Convert Gamma/Epsilon into integers
                // Convert numbers into binary

            Integer gammaBaseTen = Integer.parseInt(gammaString, 2);
            Integer epsilonBaseTen = Integer.parseInt(epsilonString, 2);

            System.out.println(gammaBaseTen * epsilonBaseTen);
            // Find the product of the gamma/epsilon in base 10
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}