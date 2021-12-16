import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DayFourAnalysis {
    public static void main(String[] args) {
        try {
            // Read the first line as the inserted array into each bingo card.

            File input = new File("input.txt");
            Scanner reader = new Scanner(input);

            String arrayLine = reader.nextLine();
            String[] arrayStringList = arrayLine.split(",");
            ArrayList<Integer> calledNumbers = new ArrayList<Integer>();

            for(int i = 0; i < arrayStringList.length; i++) {
                calledNumbers.add(Integer.parseInt(arrayStringList[i]));
            }
            System.out.println("Size of calledNumbers " + calledNumbers.size());
            
            ArrayList<Integer> tempBingoList = new ArrayList<Integer>();
            int[] winnerDetails = new int[3];
            winnerDetails[0] = 1000;
            int[] tempDetails = new int[3];
            while(reader.hasNext()) {
                tempBingoList.add(reader.nextInt());

                if(tempBingoList.size() == 25) {
                    // create bingo card, check it out, etc.
                    // System.out.println("Size is 25!");
                    BingoCard bingo = new BingoCard(tempBingoList);
                    tempDetails = bingo.whenBingo(calledNumbers);
                    // System.out.println(tempDetails[0]);
                    if(winnerDetails[0] > tempDetails[0]) {
                        winnerDetails[0] = tempDetails[0];
                        winnerDetails[1] = tempDetails[1];
                        winnerDetails[2] = tempDetails[2];
                    }
                    tempBingoList.clear();
                }
            }
            System.out.println("Winner # " + winnerDetails[0] + " | Score : " + winnerDetails[1] + " | First# : " + winnerDetails[2]);
        } catch (Exception e) {
            System.out.println("caught an exception");
        }
    }
}