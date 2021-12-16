import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DangerVents {
    public static void main(String[] args) {
        try {
            // Read the first line as the inserted array into each bingo card.

            File input = new File("input.txt");
            Scanner reader = new Scanner(input);

            ArrayList<Integer> twoPlus = new ArrayList<Integer>();
            ArrayList<Integer> oneInstance = new ArrayList<Integer>();
            int dangerVolume = 0;

            while (reader.hasNextLine()) {
                String nextLine =  reader.nextLine();
                String[] splitLine = nextLine.split("[, ]+");
                // System.out.println(splitLine[0]);
                Integer tempO = Integer.parseInt(splitLine[0]) * 1000 + Integer.parseInt(splitLine[1]);
                Integer tempT = Integer.parseInt(splitLine[3]) * 1000 + Integer.parseInt(splitLine[4]);
                
                Integer tempOne = 0;
                Integer tempTwo = 0;
                
                if(tempO > tempT) {
                    tempOne = tempT;
                    tempTwo = tempO;
                }
                else {
                    tempOne = tempO;
                    tempTwo = tempT;
                }

                // System.out.println(dangerVolume);

                if(tempOne/1000 == tempTwo/1000) {
                    // System.out.println("Same first 3: " + tempOne);
                    int length = tempTwo%1000 - tempOne%1000 + 1;

                    for(int i = 0; i < length; i++) {
                        if(twoPlus.contains(tempOne + i)) {
                        }
                        else if(oneInstance.contains(tempOne + i)) {
                            oneInstance.remove(new Integer(tempOne + i));
                            twoPlus.add(tempOne + i);
                            dangerVolume += 1;
                        }
                        else {
                            oneInstance.add(tempOne + i);
                        }
                    }
                }
                else if(tempOne%1000 == tempTwo%1000) {
                    // System.out.println("Same last 3: " + tempOne);
                    int length = tempTwo/1000 - tempOne/1000 + 1;

                    for(int i = 0; i < length; i++) {
                        if(twoPlus.contains(tempOne + i*1000)) {
                        }
                        else if(oneInstance.contains(tempOne + i*1000)) {
                            oneInstance.remove(new Integer(tempOne + i*1000));
                            twoPlus.add(tempOne + i*1000);
                            dangerVolume += 1;
                        }
                        else {
                            oneInstance.add(tempOne + i*1000);
                        }
                    }
                }
                // Nothing happens if neither of these numbers match
            }

            // System.out.println(twoPlus);
            // System.out.println(oneInstance);
            System.out.println(dangerVolume);

        } catch (Exception e) {
            System.out.println("caught an exception");
        }
    }
}