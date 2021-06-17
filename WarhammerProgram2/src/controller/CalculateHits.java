package controller;

import model.RandomDice;

public class CalculateHits {
    private int bs;
    private int numOfShots;
    private int numOfHits;
    private boolean reRollHitOnes;
    private int diceNbrOne;

    RandomDice randomDice;

    public CalculateHits(int bs, int numOfShots, boolean reRollHitOnes){
        this.bs=bs;
        this.numOfShots=numOfShots;
        randomDice= new RandomDice();
        this.reRollHitOnes=reRollHitOnes;
    }

    public int calculateNumberOfHits() {

        System.out.print("hits: ");
        for (int i = 0; i < numOfShots; i++) {
            int diceRoll = randomDice.randomD6();

            System.out.print(diceRoll+ ",");
            if (diceRoll==1){
                diceNbrOne++;
            }

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
        reRollHit1(diceNbrOne);

        System.out.println();
      return numOfHits;
    }

    public void reRollHit1(int diceNbrOne){
        if (reRollHitOnes){
            for (int i = 0; i < diceNbrOne; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new "+ diceRoll+ ",");
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
        }
    }
}
