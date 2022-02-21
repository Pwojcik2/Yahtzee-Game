/*
Assignment 1:
OOP Yahtzee
Player Class: This classes main purpose is to make sure to keep score of the players
part of the game. We also have user inputs such for if they choose to keep the dice they
rolled or not. We also have inoputs for taking scores for the players rolls. This calcukates the
scores and they are called in other classes to update our score board.

Patrick Wojcik
2/4/2022
 */

import java.util.Scanner; //imports scanner
import java.util.Random;

public class Player //Player constructor
{
    Scanner scnr = new Scanner(System.in); //initilizes scanner

    private Dice_Cup gameDice; //initilized variables
    private Score_Sheet playerScores;
    private int[] count;

    public Player() //Player constructor
    {
        this.gameDice = new Dice_Cup(); //refers to the gameDice in Dice_Cup
        this.playerScores = new Score_Sheet();
        //rollDice();
    }

    public void rollDice() //rollDice method
    {
        gameDice.rollDiceCup(); //calls for rollDiceCup in Dice_Cup Class
        gameDice.toString(); //calls for Dice_Cup toString
    }

    public Score_Sheet getSheet()
    {
        return playerScores;
    } //returns playerScores from Score_Sheet class

    //public Dice_Cup getGameDice()
    //{
     // return gameDice;
    //}

    public void pickKeep() //pickKeep method: method is used to take the userInput choices for dice rolls and reroll is chosen to
    {
        String userInput1 = ""; //String variable for users inputs
        String userInput2 = "";
        String userInput3 = "";
        String userInput4 = "";
        String userInput5 = "";

        System.out.println("Which die would you like to keep?"); //print statements asking the user for their choice
        System.out.println("Please enter Y or N");
        System.out.println(">>");

        String input = "";

        System.out.print("Keep Dice 1?");
        input = scnr.nextLine(); //scanner takes users input

        if (input.equals("Y")) //if statements checks in the user inputs to keep the dice rolled
        {
            userInput1 = input; //saves the inputs as userInput1
        }

        System.out.print("Keep Dice 2?"); //prints statment
        input = scnr.nextLine(); //takes users input

        if (input.equals("Y")) //if statement checks for users input
        {
            userInput2 = input; //if input is equal to "Y" then userInput2 is saved as input
        }


        System.out.print("Keep Dice 3?"); //same as previous
        input = scnr.nextLine();

        if (input.equals("Y"))
        {
            userInput3 = input;
        }


        System.out.print("Keep Dice 4?");
        input = scnr.nextLine();

        if (input.equals("Y"))
        {
            userInput4 = input;
        }


        System.out.print("Keep Dice 5?");
        input = scnr.nextLine();

        if (input.equals("Y"))
        {
            userInput5 = input;
        }


        gameDice.keepDice(userInput1, userInput2, userInput3, userInput4, userInput5); //sets the values in each of the players dice cup
        System.out.println(); //empty space
    }

    public void keepScore() //method carries switch statement for the games Scoring
    {
        System.out.println("Where would you like to score this roll?");
        System.out.println("Choose 1 - 13 for scoring");
        System.out.println(); //empty space
        String input = scnr.nextLine(); //implements string
        int currentScore = 0;

        switch(input) //switch statment checks for input taken by the scanner
        {
            case "1":  //if case = 1 then will run the code below
                currentScore = getOnes(); //currentScore calls for getOne method to get score of Ones
                playerScores.setScoreArray(0, currentScore);//calls for setScore array and sets the score of the correct index
                break;

            case "2":
                currentScore = getTwos();
                playerScores.setScoreArray(1, currentScore);
                break;

            case "3": //if user inputs equals to 3 then will run the case
                currentScore = getThrees(); //currentScore calls for getThres method to calculate score
                playerScores.setScoreArray(2, currentScore); //calls for setScore array and sets the score of the correct index
                break;

            case "4":
                currentScore = getFours();
                playerScores.setScoreArray(3, currentScore); //same as previous
                break;

            case "5":
                currentScore = getFives();
                playerScores.setScoreArray(4, currentScore);
                break;

            case "6":
                currentScore = getSixes();
                playerScores.setScoreArray(5, currentScore);
                break;

            case "7":
                currentScore = getTriple();
                playerScores.setScoreArray(6, currentScore);
                break;

            case "8":
                currentScore = getQuad();
                playerScores.setScoreArray(7, currentScore);
                break;

            case "9":
                currentScore = getFullHouse();
                playerScores.setScoreArray(8, currentScore);
                break;

            case "10":
                currentScore = getSmallStraight();
                playerScores.setScoreArray(9, currentScore);
                break;

            case "11":
                currentScore = getLargeStraight();
                playerScores.setScoreArray(10, currentScore);
                break;

            case "12":
                currentScore = getYahtzee();
                playerScores.setScoreArray(11, currentScore);
                break;

            case "13":
                currentScore = getChance();
                playerScores.setScoreArray(12, currentScore); //same as previous cases
                break;

        }
    }

    //public int getDie(int dieNum)
    //{
      //  upCount();

        //return gameDice.getCup()[dieNum].getValue();

    //}

    private int countUp(int value)
    {
        int count = 0; //initlized with a starting value of 0

        for (int i = 0; i < 5; i++) //loops through for 4 times
        {
            if (gameDice.getCup()[i].getValue() == value) //calls for methods and checks is they equal the value
            {
                count++; //incriments count var by one
            }
        }
        return count;//returns number of dice rolls
    }

    public boolean upCount() //method updates count
    {
        int ones = countUp(1); //sets the value of each num for countUp
        int twos= countUp(2); //sets the value of twos value for countUp
        int threes= countUp(3);
        int fours= countUp(4);
        int fives= countUp(5);
        int sixes= countUp(6);

        if (ones == 5 || twos == 5 ||  threes == 5 || fours == 5 || fives == 5 || sixes == 5 ) //check if any equal to 5
        {
         return true; //will return true if there are 5 of a kind
        }

        return false;//if not then will be set to false
    }

    public int getOnes() //method of getOnes
    {
        return countUp(1);//returns to countup method to calculate score of Ones
    }

    public int getTwos()
    {

        return countUp(2) * 2; //returns countup with value of two to calculate score of getTwos
    }

    public int getThrees()
    {

        return countUp(3) * 3; //returns the value of calculated score to countUp
    }

    public int getFours()
    {

        return countUp(4) * 4; //calls and calculates the score of getting fours
    }

    public int getFives()
    {

        return countUp(5) * 5;
    }

    public int getSixes()
    {

        return countUp(6) * 6; //same as previous cases
    }

    public int getTriple()
    {
        int threeOfAKind = 0;

        int ones = countUp(1); //sets the base value of each num from countUp val
        int twos= countUp(2);
        int threes = countUp(3);
        int fours = countUp(4);
        int fives = countUp(5);
        int sixes = countUp(6);

        if (ones == 3 || twos == 3 ||  threes == 3 || fours == 3 || fives == 3 || sixes == 3 ) //if aany values match the val of 3
        {
            threeOfAKind = getOnes() + getTwos() + getThrees() + getFours() + getFives() + getSixes(); //if get three of a kind then add the sum of those

        }
        return threeOfAKind; //return the sum
    }

    public int getQuad()
    {

        int fourOfAKind = 0;

        int ones = countUp(1); //initilize value of ones with countUp val 1
        int twos= countUp(2);
        int threes= countUp(3);
        int fours= countUp(4);
        int fives= countUp(5);
        int sixes= countUp(6);

        if (ones == 4 || twos == 4 ||  threes == 4 || fours == 4 || fives == 4 || sixes == 4 ) //checks if any of the values are 4 of a kind
        {
            fourOfAKind = getOnes() + getTwos() + getThrees() + getFours() + getFives() + getSixes(); //finds the sum of those 4 of a kind

        }
        return fourOfAKind; //returns sum
    }

    public int getFullHouse() //method checks to have 3 of a kind as well as a pair
    {

        int fullHouse = 0;

        for (int i = 0; i < 6; i++) //loops goes through all of the die
        {

            if (count[i] == 3) //checks for 3 of the same time of dice
            {

                for (int j = 0; j < 6; j++)
                {

                    if (count[j] == 2) //checks for the pair of dice
                    {
                        fullHouse += 25; //if both statements pass then fullHouse is 25 points
                    }
                }
            }
        }

        return fullHouse; //points of fullHouse are updated and returned
    }

    public int getSmallStraight()
    {

        int smallScore = 0;
        int min = gameDice.getCup()[0].getValue();
        int max = gameDice.getCup()[0].getValue();


        if(getLargeStraight() == 40) //if the largeStraight equals to 40 set the smallscore to 30 and return the score
        {
            smallScore = 30; //sets smallScore to 30 points
            return smallScore;
        }

        /*
        for (int i = 1; i < 5; i++)
        {

            if(gameDice.getCup()[i].getValue()>max)
            {
                max=gameDice.getCup()[i].getValue();
            }

            if(gameDice.getCup()[i].getValue()<min)
            {
                min=gameDice.getCup()[i].getValue();
            }
        }

        if((max-min+1)==4)
        {
            smallScore +=30;
        } */

        return smallScore; //returns the updated Score


    }

    public int getLargeStraight() //checks for 5 die faces
    {

        int largeScore = 0;
        int min = gameDice.getCup()[0].getValue();
        int max = gameDice.getCup()[0].getValue();

        for (int i = 1; i < 5; i++)
        {

            if(gameDice.getCup()[i].getValue()>max)
            {
                max=gameDice.getCup()[i].getValue(); //sets max too
            }

            if(gameDice.getCup()[i].getValue()<min)
            {
                min=gameDice.getCup()[i].getValue(); //set min to
            }
        }

        if((max-min+1)==5)
        {
            largeScore +=40; //sets the score to 40
        }

        return largeScore; //returns the updated score
    }

    public int getYahtzee()
    {
        int scoreYahtzee = 0;

        boolean yahtzee = upCount(); //calls for upCount

        if(yahtzee) //if true then run
        {
            scoreYahtzee = 50; //sets the score to 50
        }

        return scoreYahtzee; //returns and updates the points

    }

    public int getChance()
    {
        int value = getOnes() + getTwos() + getThrees() + getFours() + getFives() + getSixes(); //adds up and gets total of die faces

        return value;

    }


}
