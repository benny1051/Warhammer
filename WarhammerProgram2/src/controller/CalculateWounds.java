package controller;

import model.RandomDice;

import java.util.Random;

public class CalculateWounds {

    private int numOfWounds;
    private int diceNbrOne;

    RandomDice randomDice;

    public CalculateWounds() {
        randomDice = new RandomDice();


    }

    public int CalculateNumOfWounds(int numOfHits, int str, int tough, boolean reRollWoundOnes, boolean reRollAllWounds) {

        str = str + 3;
        tough = tough + 3;
        System.out.print("Wounds: ");

        for (int i = 0; i < numOfHits; i++) {
            int diceRoll = randomDice.randomD6();
            System.out.print(diceRoll + ",");

            if (diceRoll == 1) {
                diceNbrOne++;
            }

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
        reRollWound1(diceNbrOne, reRollWoundOnes, str, tough);
        int failedWounds = (numOfHits-numOfWounds);
        reRollAll(str, tough, reRollAllWounds,failedWounds);
        System.out.println();

        return numOfWounds;
    }


    public void reRollWound1(int diceNbrOne, boolean reRollWoundOnes, int str, int tough) {
        if (reRollWoundOnes) {
            for (int i = 0; i < diceNbrOne; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new " + diceRoll + ",");
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
        }
    }

    public void reRollAll(int str, int tough, boolean reRollAllWounds, int failedWounds) {
        if (reRollAllWounds) {
            for (int i = 0; i < failedWounds; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new " + diceRoll + ",");

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
        }
    }
}
