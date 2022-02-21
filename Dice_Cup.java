/*
Assignment 1:
OOP Yahtzee
Dice_Cup Class: Takes inputs for rerolls and if the player wants to keep the
same dice they originally rolled. This class also carries the toString method to
print out the rolled dice.

Patrick Wojcik
2/4/2022
 */

public class Dice_Cup
{

  private Die[] cup; //initilize Die array cup

  public Dice_Cup()
  {
    this.cup = new Die[5]; //sets Die array to 5
    initCup(); //calls initcup method
  }

  private void initCup()
  {
    for(int i = 0; i < cup.length; i++) //loops for the cups length
    {
      cup[i] = new Die(); //updates Die with the cups index
    }
  }

  public Die[] rollDiceCup()
  {
    for(int i = 0; i < cup.length; i++) //loops runs for the cups length
    {
      cup[i].roll(); //
    }

    return cup;
  }

  public Die[] getCup()
  {
    return cup;
  } //getter method for Cup


  public void keepDice(String userInput1, String userInput2, String userInput3, String userInput4, String userInput5)
  {
    if(userInput1.equals("Y")) //if the userinput is equal to Y
    {
      cup[0].setKeep(true); //this will set cup index 0 to true
    }


    if(userInput2.equals("Y"))
    {
      cup[1].setKeep(true); //cup index 1 set keep will be set to true
    }


    if(userInput3.equals("Y")) //same as previous
    {
      cup[2].setKeep(true);
    }


    if(userInput4.equals("Y"))
    {
      cup[3].setKeep(true);
    }


    if(userInput5.equals("Y"))
    {
      cup[4].setKeep(true);
    }

  }



  public void setValues(int index, int value) //index and value parameters
  {
    cup[index].setRollValue(value);
  }


  @Override //makes sure toString happens
  public String toString()
  {
    String str = "";

    for (int i = 0; i < 5; i++) //will loop for number of dice
    {
      str += (i + 1) + ":" + "["+ this.cup[i].getValue() + "] "; //str is set to increment based on dice number
    }

    System.out.println(str); //prints str
    return str;
  }


}


