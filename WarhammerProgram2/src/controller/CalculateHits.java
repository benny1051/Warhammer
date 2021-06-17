package controller;

import model.RandomDice;

public class CalculateHits {
    private int bs;
    private int numOfShots;
    private int numOfHits;
    private boolean reRollHitOnes;
    private int diceNbrOne;
    private int failedDice;
    boolean reRollAllHits;

    RandomDice randomDice;

    public CalculateHits(int bs, int numOfShots, boolean reRollHitOnes, boolean reRollAllHits) {
        this.bs = bs;
        this.numOfShots = numOfShots;
        randomDice = new RandomDice();
        this.reRollHitOnes = reRollHitOnes;
        this.reRollAllHits = reRollAllHits;
    }

    public int calculateNumberOfHits() {

        System.out.print("hits: ");
        for (int i = 0; i < numOfShots; i++) {
            int diceRoll = randomDice.randomD6();

            System.out.print(diceRoll + ",");
            if (diceRoll == 1) {
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
        failedDice = (numOfShots - numOfHits);
        reRollall(failedDice);
        System.out.println();
        return numOfHits;
    }

    public void reRollHit1(int diceNbrOne) {
        if (reRollHitOnes) {
            for (int i = 0; i < diceNbrOne; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new " + diceRoll + ",");
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

    public void reRollall(int failedDice) {
        if (reRollAllHits) {
            for (int i = 0; i < failedDice; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new " + diceRoll + ",");
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
