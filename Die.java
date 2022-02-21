/*
Assignment 1:
OOP Yahtzee
Die Class: The die class is mostly resonsible for the rolling of the dice.


Patrick Wojcik
2/4/2022
 */

import java.util.Random;

public class Die
{
     //initilize variables
    private Random randomDie;
    private int rollValue;
    private boolean keep;

    public Die() //Die constructor
    {

        randomDie = new Random(); //sets randomDir with Random class
        this.keep = false; //keep is set to be false
    }

    public void roll()
    {
        if(!keep)  //if doesnt equal false then roll
        {
            rollValue = randomDie.nextInt(6) + 1; //roll value is calucated by being randomized
        }
    }

    public int getValue()
    {
        return rollValue;
    } //getting for values

    /*
    public boolean isKeep()
    {
        return keep;
    }
     */

    public void setKeep(boolean keep)
    {
        this.keep = keep; //set keep to false
    }

    public void setRollValue(int rollValue)
    {
        this.rollValue = rollValue; //set value for rollValue for what is rolled
    }
}
