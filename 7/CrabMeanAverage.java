import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class CrabMeanAverage {
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

            double average = 0;
            for(int i = 0; i < rawData.size(); i++) {
                average += rawData.get(i);
            }
            average = average/rawData.size();
            // Issue with average is that it is between two numbers so both numbers should technically be checked
            average = Math.round(average);
            System.out.println("Average : " + average);

            Long fuelTotal = new Long(0);
            for(int i = 0; i < rawData.size(); i++) {
                double distance = Math.abs(rawData.get(i) - average) + 1;
                Double newDistance = new Double(distance);
                int distanceInt = newDistance.intValue();
                fuelTotal += distanceInt*(distanceInt-1)/2;
                // System.out.println("Number: " + rawData.get(i) + " Distance: " + distance);
                // System.out.println("Fuel : " + fuelTotal);
            }
            System.out.println("Average: " + average + " Fuel Total: " + fuelTotal);

            average = 478;
            fuelTotal = new Long(0);
            for(int i = 0; i < rawData.size(); i++) {
                double distance = Math.abs(rawData.get(i) - average) + 1;
                Double newDistance = new Double(distance);
                int distanceInt = newDistance.intValue();
                fuelTotal += distanceInt*(distanceInt-1)/2;
                // System.out.println("Number: " + rawData.get(i) + " Distance: " + distance);
                // System.out.println("Fuel : " + fuelTotal);
            }
            System.out.println("Average: " + average + " Fuel Total: " + fuelTotal);

        } catch (Exception e) {
            System.out.println("caught an exception");
        }
    }
}