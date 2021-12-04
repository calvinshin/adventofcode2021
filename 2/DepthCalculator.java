import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DepthCalculator {
    public static void main(String[] args) {
        try {
            // Import file and data
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Integer horizontal = new Integer(0);
            Integer depth = new Integer(0);
            Integer product = new Integer(0);

            while (reader.hasNextLine()) {
                String nextLine = reader.nextLine();
                String[] splitLine = nextLine.split(" ");
                int i = Integer.parseInt(splitLine[1]);

                switch(splitLine[0]) {
                    case "forward":
                        horizontal += i;
                        break;
                    case "down":
                        depth += i;
                        break;
                    case "up":
                        depth -= i;
                        break;
                }
            }
            // create case with 3 options that updates horizontal/depth

            product = horizontal * depth;
            System.out.println("horizontal(" + horizontal + ") * depth(" + depth + ") = " + product);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}