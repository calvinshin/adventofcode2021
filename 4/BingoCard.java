import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class BingoCard {
    ArrayList<Integer> numbers;   

    public BingoCard() {
        numbers = new ArrayList<Integer>();
    }

    public BingoCard(String[] array) {
        numbers = new ArrayList<Integer>();
    }

    public BingoCard(ArrayList<Integer> list) {
        numbers = new ArrayList<Integer>();

        for(int i = 0; i < 25; i++) {
            numbers.add(list.get(i));
        }
    }

    public void readCard() {
        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

    public boolean isBingo(ArrayList<Integer> calledNumbers) {
        // check horizontal
        for(int i = 0; i < 5; i++) {
 
        }
        // check vertical
        // check diagonal \ and / 
        return false;
    }

    // Or we should just find how many number it takes for bingo to happen on a card
    // then return the resulting number and the score as an array[2]
    public int[] whenBingo(ArrayList<Integer> calledNumbers) {
        int[] returnedInformation = new int[3];
        boolean bingo = false;
        ArrayList<Integer> activeNumbers = new ArrayList<Integer>();

        readCard();

        // Adding from calledNumbers to determine when the 
        for(int i = 0; i < calledNumbers.size(); i++) {
            activeNumbers.add(calledNumbers.get(i));
                if(numbers.contains(activeNumbers.get(i))) {
                    // Check which row
                    int location = numbers.indexOf(activeNumbers.get(i));
                    int row = location/5;
                    int rowChecker = 0;
                    for(int j = 0; j < 5; j++) {
                        if(activeNumbers.contains(numbers.get(row*5+j)) == false) {
                            // System.out.println("j is at " + j + " and i is at " + i);
                            break;
                        }
                        else {
                            rowChecker += 1;
                            // System.out.println("Added a number; rowChecker at " + rowChecker);
                        }

                    }
                    if(rowChecker == 5) {
                        // System.out.println("Bingo was found at row " + row);
                        // System.out.println("activeNumbers is at " + i);
                        bingo = true;
                        break;
                    }

                    // Check which column
                    int col = location%5;
                    int colChecker = 0;
                    for(int j = 0; j < 5; j++) {
                        // System.out.println("Checking j " + j + " at activeNumbers");
                        // System.out.println("col at " + col);
                        if(activeNumbers.contains(numbers.get(col+j*5)) == false) {
                            break;
                        }
                        else {
                            colChecker += 1;
                            // System.out.println("Added a number; colChecker at " + colChecker);
                            // System.out.println("activeNumbers is at " + location);
                        }
                    }
                    if(colChecker == 5) {
                        // System.out.println("Bingo was found at col " + col);
                        // System.out.println("activeNumbers is at " + i);
                        bingo = true;
                        break;
                    }

                    // // Check if in diagonal
                    // int rightChecker = 0;
                    // if(location%6 == 0) {
                    //     for(int j = 0; j < 5; j++) {
                    //         if(activeNumbers.contains(numbers.get(j*6)) == false) {
                    //             break;
                    //         }
                    //         else {
                    //             rightChecker += 1;
                    //         }
                    //         // System.out.println("Bingo was found at rightward slash diagonal ");
                    //         // System.out.println("activeNumbers is at " + location);
                    //     }
                    // }
                    // if(rightChecker == 5) {
                    //     // System.out.println("Bingo was found at rightDiag");
                    //     // System.out.println("activeNumbers is at " + i);
                    //     bingo = true;
                    //     break;
                    // }
                    
                    // int leftChecker = 0;
                    // if(location%4 == 0 && location != 0 && location != 24) {
                    //     for(int j = 1; j < 6; j++) {
                    //         if(activeNumbers.contains(numbers.get(j*4)) == false) {
                    //             break;
                    //         }
                    //         else {
                    //             leftChecker += 1;
                    //         }
                    //         // System.out.println("Bingo was found at leftward slash diagonal ");
                    //         // System.out.println("activeNumbers is at " + location);
                    //     }
                    // }
                    // if(leftChecker == 5) {
                    //     // System.out.println("Bingo was found at leftDiag");
                    //     // System.out.println("activeNumbers is at " + i);
                    //     bingo = true;
                    //     break;
                    // }
                }
        }

        if(bingo == true) {
            // System.out.println("checking bingo now");
            // use activeNumbers to determine last number called
            int lastNumber = activeNumbers.get(activeNumbers.size()-1);
            // use activeNumbers to check each value of the bingo card to determine
            //  which numbers were already called for score
            ArrayList<Integer> remainingScore = new ArrayList<Integer>(numbers);
            for(int i = 0; i < activeNumbers.size(); i++) {
                remainingScore.remove(new Integer(activeNumbers.get(i)));
            }
            int remainingNumberTotal = 0;
            for(int i = 0; i < remainingScore.size(); i++) {
                remainingNumberTotal += remainingScore.get(i);
            }
            System.out.println(remainingNumberTotal + " * " + lastNumber);
            
            returnedInformation[0] = activeNumbers.size();
            returnedInformation[1] = lastNumber * remainingNumberTotal;
            returnedInformation[2] = numbers.get(0);
            // multiply the two
            // return the first number of array as the length of the activeNumbers array
            // return the second number of array as the score
        }
        System.out.println("Number " + returnedInformation[0] + " && score : " + returnedInformation[1]);
        return returnedInformation;
    }
    // when you add a number, you just check the relevant row/column/diagonal
}