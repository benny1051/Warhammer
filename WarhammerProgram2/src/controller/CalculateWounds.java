package controller;

import model.RandomDice;

import java.util.Random;

public class CalculateWounds {
    private int str;
    private int tough;
    private int numOfWounds;

    RandomDice randomDice;

    public CalculateWounds(){
        randomDice = new RandomDice();


    }

    public int CalculateNumOfWounds(int numOfHits) {

        str++;
        tough++;
        System.out.print("Wounds: ");
        for (int i = 0; i < numOfHits; i++) {
            int diceRoll = randomDice.randomD6();
            System.out.print(diceRoll+ ",");


            if (str == tough && diceRoll >= 4) {
                numOfWounds++;
            }
            if (str > tough && str < (tough * 2) && diceRoll >= 3) {
                numOfWounds++;
            }
            if (tough > str && tough < (str * 2) && diceRoll >= 5) {
                numOfWounds++;
            }
            if (str >= (tough * 2) && diceRoll >= 2) {
                numOfWounds++;
            }
            if (tough >= (str * 2) && diceRoll >= 6) {
                numOfWounds++;
            }

        }
        System.out.println();

        return numOfWounds;
    }
}
