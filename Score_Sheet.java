/*
Assignment 1:
OOP Yahtzee
Score Sheet Class: This class keeps track of the items that have been scored.
We used arrays for this and implemented them in the print methods. So this
prints a scoreboard depending on the player.

Patrick Wojcik
2/4/2022
 */

import java.util.Scanner;
import java.util.Random;

public class Score_Sheet
{
    private int[] scoreArray; //creates scoreArray

    public Score_Sheet()
    {
        this.scoreArray = new int[13];
    } //sets array to 13 total number of scoring options

    public int[] getScore_Sheet()
    {
        return scoreArray;
    }

    public void displayScore() //display of the games scoreboard
    {
            System.out.println("-----------------------------");
            System.out.println("1 - Ones:                  " + "[" + scoreArray[0] + "]"); //print statement calls for scoreArray index with score of Ones
            System.out.println("2 - Twos:                  " + "[" + scoreArray[1] + "]");
            System.out.println("3 - Threes:                " + "[" + scoreArray[2] + "]");
            System.out.println("4 - Fours:                 " + "[" + scoreArray[3] + "]");
            System.out.println("5 - Fives:                 " + "[" + scoreArray[4] + "]");
            System.out.println("6 - Sixes:                 " + "[" + scoreArray[5] + "]");

            System.out.println();
            System.out.println("7 - Triple:                " + "[" + scoreArray[6] + "]");
            System.out.println("8 - Quad:                  " + "[" + scoreArray[7] + "]");
            System.out.println("9 - Full House:            " + "[" + scoreArray[8] + "]");
            System.out.println("10 - Small Straight:        " + "[" + scoreArray[9] + "]");
            System.out.println("11 - Large Straight:        " + "[" + scoreArray[10] + "]");
            System.out.println("12 - Yahtzee:               " + "[" + scoreArray[11] + "]");
            System.out.println("13 - Chance:                " + "[" + scoreArray[12] + "]");
            System.out.println("-----------------------------");
            System.out.println(" Total:                 " + "[" + getTotal() + "]"); //calls for the getTotal method
            System.out.println("-----------------------------");

    }

    public void setScoreArray(int i, int score)//score array with parameters of index and score
    {
        scoreArray[i] = score; //score array updates with corresponding index and score
    }

    public int getTotal() //finds the sum of points
    {
        int sumTotal = 0;

        for(int i = 0; i < scoreArray.length; i++) //loops for the length of the scoreArray
        {
            sumTotal += scoreArray[i]; //the sum total is the sum of all indexs of scoreArray
        }
        return sumTotal;

    }
}

