/*
Assignment 1:
OOP Yahtzee
Game Class: Responsible for the overall rules of the game. In this class
we take care of tracking turns and rounds of the players in the game.

Patrick Wojcik
2/4/2022
 */

import java.util.Scanner;

public class Game
{
    private Player[] gamePlayers; //creates array os gamePlayers

    public Game()
    {
        gamePlayers = new Player[1]; //sets the array to 1
        gamePlayers[0] = new Player();
    }

    public Game(int numPlayers)
    {
        gamePlayers = new Player[numPlayers]; //sets the array to numPlayers inputted

        for(int i = 0; i < numPlayers; i++) //loops for total num of players
        {
            gamePlayers[i] = new Player(); //Player set by current index of gamePlayers
        }
    }

    public static void main(String[] args) //main method
    {

        int playerTurn = 1;
        //Score_Sheet displayScore;

        Scanner scnr = new Scanner(System.in);

        System.out.println("How many players are playing (Max 6 Players)");
        String input = scnr.nextLine(); //scanner takes in users input

        Game yahtzee = new Game(Integer.parseInt(input)); //parses user int input for string parameter in Game

        do
        {

            for(int i = 0; i < yahtzee.gamePlayers.length; i++) //loops goes on for the amount of players playing
            {
                System.out.println("Turn #" + playerTurn +":");
                System.out.println("Player #" + (i + 1) + "'s turn");

                System.out.print("Roll Number 1  ");

                yahtzee.gamePlayers[i].rollDice(); //calls to rollDice method in Die class
                yahtzee.gamePlayers[i].pickKeep(); //index calls for pickKeep method

                System.out.print("Roll Number 2  ");

                yahtzee.gamePlayers[i].rollDice(); //calls to rollDice method in Die class
                yahtzee.gamePlayers[i].pickKeep(); //index calls for pickKeep method

                System.out.print("Roll Number 3  ");

                yahtzee.gamePlayers[i].rollDice(); //rolls dice for roll number 3

                yahtzee.gamePlayers[i].getSheet().displayScore(); //will display the scorebaord
                yahtzee.gamePlayers[i].keepScore();

                yahtzee.gamePlayers[i].getSheet().displayScore();
            }

            playerTurn++; //player turn will incriment at the end of the turn
        } while(playerTurn <= 13);



    }
}
