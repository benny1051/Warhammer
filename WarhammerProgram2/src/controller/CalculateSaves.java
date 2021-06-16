package controller;

import model.RandomDice;

import java.util.Random;

public class CalculateSaves {

    RandomDice randomDice;
    private int savedWound;


    public CalculateSaves() {
        randomDice = new RandomDice();

    }


    public int calculateSaves(int numOfWounds, int AP, int save) {
        System.out.print("Saves: ");
        for (int i = 0; i < numOfWounds; i++) {
            int diceRoll = randomDice.randomD6();
            System.out.print(diceRoll + ",");

            if (AP == 0) {
                if (save == 0 && diceRoll >= 2) {
                    savedWound++;
                }

                if (save == 1 && diceRoll >= 2) {
                    savedWound++;
                }

                if (save == 2 && diceRoll >= 2) {
                    savedWound++;
                }

                if (save == 3 && diceRoll >= 3) {
                    savedWound++;
                }

                if (save == 4 && diceRoll >= 4) {
                    savedWound++;
                }

                if (save == 5 && diceRoll >= 5) {
                    savedWound++;
                }

                if (save == 6 && diceRoll == 6) {
                    savedWound++;
                }
            }

            if (AP == 1) {
                if (save == 0 && diceRoll >= 2) {
                    savedWound++;
                }

                if (save == 1 && diceRoll >= 2) {
                    savedWound++;
                }

                if (save == 2 && diceRoll >= 3) {
                    savedWound++;
                }

                if (save == 3 && diceRoll >= 4) {
                    savedWound++;
                }

                if (save == 4 && diceRoll >= 5) {
                    savedWound++;
                }

                if (save == 5 && diceRoll >= 6) {
                    savedWound++;


                }
            }
            if (AP == 2) {
                if (save == 0 && diceRoll >= 2) {
                    savedWound++;
                }

                if (save == 1 && diceRoll >= 3) {
                    savedWound++;
                }

                if (save == 2 && diceRoll >= 4) {
                    savedWound++;
                }

                if (save == 3 && diceRoll >= 5) {
                    savedWound++;
                }

                if (save == 4 && diceRoll >= 6) {
                    savedWound++;
                }

            }
            if (AP == 3) {
                if (save == 0 && diceRoll >= 3) {
                    savedWound++;
                }

                if (save == 1 && diceRoll >= 4) {
                    savedWound++;
                }

                if (save == 2 && diceRoll >= 5) {
                    savedWound++;
                }

                if (save == 3 && diceRoll >= 6) {
                    savedWound++;
                }
            }
            if (AP == 4) {
                if (save == 0 && diceRoll >= 4) {
                    savedWound++;
                }

                if (save == 1 && diceRoll >= 5) {
                    savedWound++;
                }

                if (save == 2 && diceRoll >= 6) {
                    savedWound++;
                }
            }
            if (AP == 5) {
                if (save == 0 && diceRoll >= 5) {
                    savedWound++;
                }

                if (save == 1 && diceRoll >= 6) {
                    savedWound++;
                }
            }
        }
        System.out.println();
        return savedWound;
    }
}
