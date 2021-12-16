import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class CrabAverage {
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
            // System.out.println(rawData);

            // Average does not work; checking median
            // double average = 0;
            // for(int i = 0; i < rawData.size(); i++) {
            //     average += rawData.get(i);
            // }
            // average = average/rawData.size();

            // System.out.println("Average : " + average);


            // Likely that median is close to where the numbers should converge, given sku of the numbers being normalized.
            Collections.sort(rawData);
            Integer median = rawData.get(rawData.size()/2);
            System.out.println(median);

            Integer fuelTotal = 0;
            for(int i = 0; i < rawData.size(); i++) {
                fuelTotal += Math.abs(rawData.get(i) - median);
            }
            System.out.println(fuelTotal);

        } catch (Exception e) {
            System.out.println("caught an exception");
        }
    }
}