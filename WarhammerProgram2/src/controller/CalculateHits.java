package controller;

import model.RandomDice;

public class CalculateHits {
    int bs;
    int numOfShots;
    private int numOfHits;
    RandomDice randomDice;

    public CalculateHits(int bs, int numOfShots){
        this.bs=bs;
        this.numOfShots=numOfShots;
        randomDice= new RandomDice();
    }

    public int calculateNumberOfHits() {

        System.out.print("hits: ");
        for (int i = 0; i < numOfShots; i++) {
            int diceRoll = randomDice.randomD6();

            System.out.print(diceRoll+ ",");


            if (bs == 0 && diceRoll >= 2) {
                numOfHits++;
            }
            if (bs == 1 && diceRoll >= 3) {
                numOfHits++;
            }
            if (bs == 2 && diceRoll >= 4) {
                numOfHits++;
            }
            if (bs == 3 && diceRoll >= 5) {
                numOfHits++;
            }
            if (bs == 4 && diceRoll == 6) {
                numOfHits++;
            }
        }
        System.out.println();
      return numOfHits;
    }
}
