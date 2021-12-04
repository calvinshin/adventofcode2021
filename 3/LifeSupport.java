import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class LifeSupport {
    public static void main(String[] args) {
        try {
            // Import file and data
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            ArrayList<String> rawArray = new ArrayList<String>();

            // Create first an array of strings
            while (reader.hasNextLine()) {
                String nextLine =  reader.nextLine();
                rawArray.add(nextLine);
            }

            int col = rawArray.get(0).length();
            int row = rawArray.size();
            Character zero = new Character('0');
            Character one = new Character('1');

            int oxygenBaseTen = 0;
            int carbonDioxideBaseTen = 0;

            ArrayList<String> oxygenArray = new ArrayList(rawArray);
            ArrayList<String> carbonDioxideArray = new ArrayList(rawArray);

// O2
            for(int j = 0; j < col; j++) {
                int countOfZero = 0;
                int countOfOne = 0;

                for(int i = 0; i < row; i++) {
                    if(zero == oxygenArray.get(i).charAt(j)) {
                        countOfZero += 1;
                    }
                    else {
                        countOfOne += 1;
                    }
                }
                // Remove the rows if the value is not the majority
                if(countOfOne >= countOfZero) {
                    for(int i = row-1; i >= 0; i--) {
                        if(oxygenArray.get(i).charAt(j) == zero) {
                            oxygenArray.remove(i);
                        }
                    }
                }
                else {
                    for(int i = row-1; i >= 0; i--) {
                        if(oxygenArray.get(i).charAt(j) == one) {
                            oxygenArray.remove(i);
                        }
                    }
                }

                row = oxygenArray.size();
                if(row == 1) {
                    oxygenBaseTen = Integer.parseInt(oxygenArray.get(0), 2);
                    System.out.println("Final Oxygen: " + oxygenBaseTen);
                }
            }

            // Create CO2 Array
            for(int j = 0; j < col; j++) {
                int countOfZero = 0;
                int countOfOne = 0;
                row = carbonDioxideArray.size();

                for(int i = 0; i < row; i++) {
                    if(zero == carbonDioxideArray.get(i).charAt(j)) {
                        countOfZero += 1;
                    }
                    else {
                        countOfOne += 1;
                    }
                }
                // Remove the rows if the value is not the majority
                if(countOfOne >= countOfZero) {
                    for(int i = row-1; i >= 0; i--) {
                        if(carbonDioxideArray.get(i).charAt(j) == one) {
                            carbonDioxideArray.remove(i);
                        }
                    }
                }
                else {
                    for(int i = row-1; i >= 0; i--) {
                        if(carbonDioxideArray.get(i).charAt(j) == zero) {
                            carbonDioxideArray.remove(i);
                        }
                    }
                }

                row = carbonDioxideArray.size();
                if(row == 1) {
                    carbonDioxideBaseTen = Integer.parseInt(carbonDioxideArray.get(0), 2);
                    System.out.println("Final CarbonDioxide: " + carbonDioxideBaseTen);
                    System.out.println("Final Product: " + carbonDioxideBaseTen * oxygenBaseTen);
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}