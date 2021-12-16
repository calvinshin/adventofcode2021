import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class PopGrowth {
    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);

            ArrayList<Integer> rawData = new ArrayList<Integer> ();
            String nextLine =  reader.nextLine();
            String[] splitLine = nextLine.split(",");
            for(int i = 0; i < splitLine.length; i++) {
                rawData.add(Integer.parseInt(splitLine[i]));
            }

            ArrayList<Integer> population = new ArrayList<Integer> ();
            for (int i = 0; i < 9; i++) {
                population.add(0);
            }

            for(int i = 0; i < rawData.size(); i++) {
                int location = rawData.get(i);
                population.set(location, population.get(location) + 1);
                // System.out.println(population);
            }

            for(int i = 1; i < 81; i++) {
                int newFish = population.get(0);
                population.remove(0);
                population.add(newFish);
                population.set(6, population.get(6) + newFish);
                System.out.println(population);
            }            
            // System.out.println(population);
            int totalPopulation = 0;
            for(int i = 0; i < population.size(); i++) {
                totalPopulation += population.get(i);
            }
            System.out.println(totalPopulation);

        } catch (Exception e) {
            System.out.println("caught an exception");
        }
    }
}