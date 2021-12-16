import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        try {
            // System.out.println("1");
            BingoCard testOne = new BingoCard();
            
            // System.out.println("2");
            ArrayList testArray = new ArrayList<Integer>();
            for(int i = 0; i<25; i++) {
                testArray.add(i);
            }
            BingoCard testTwo = new BingoCard(testArray);
            // Testing row
            testTwo.whenBingo(testArray);

            // Testing col
            ArrayList colWinner = new ArrayList<Integer>();
            for(int i = 0; i<20; i++) {
                colWinner.add(i*5);
            }
            testTwo.whenBingo(colWinner);

            // Testing right diag
            ArrayList diagRight = new ArrayList<Integer>();
            diagRight.add(3);
            for(int i = 0; i<20; i++) {
                diagRight.add(i*6);
            }
            testTwo.whenBingo(diagRight);


            // Testing left diag
            ArrayList diagLeft = new ArrayList<Integer>();
            for(int i = 0; i<20; i++) {
                diagLeft.add(i*4);
            }
            testTwo.whenBingo(diagLeft);


            
        } catch (Exception e) {
            System.out.println("caught an exception");
        }
    }
}