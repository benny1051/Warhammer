package controller;

import model.RandomDice;

public class CalculateHits {
    private int bs;
    private int numOfShots;
    private int numOfHits;
    private boolean reRollHitOnes;
    private int failedDice;
    private boolean reRollAllHits;
    private boolean explodingFive;
    private boolean explodingSix;
    private int diceNbrOne;
    private int diceNbrTwo;
    private int diceNbrThree;
    private int diceNbrFour;
    private int diceNbrFive;
    private int diceNbrSix;
    private boolean teslaHits;

    RandomDice randomDice;

    public CalculateHits(int bs, int numOfShots, boolean reRollHitOnes, boolean reRollAllHits, boolean explodingSix, boolean teslaHits, boolean explodingFive) {
        this.bs = bs;
        this.numOfShots = numOfShots;
        randomDice = new RandomDice();
        this.reRollHitOnes = reRollHitOnes;
        this.reRollAllHits = reRollAllHits;
        this.explodingFive=explodingFive;
        this.explodingSix = explodingSix;
        this.teslaHits=teslaHits;
    }

    public int calculateNumberOfHits() {

        System.out.print("Hits: ");
        for (int i = 0; i < numOfShots; i++) {
            int diceRoll = randomDice.randomD6();

            System.out.print(diceRoll + ",");
            if (diceRoll == 1) {
                diceNbrOne++;
            }
            if (diceRoll == 2) {
                diceNbrTwo++;
            }
            if (diceRoll == 3) {
                diceNbrThree++;
            }
            if (diceRoll == 4) {
                diceNbrFour++;
            }
            if (diceRoll == 5) {
                diceNbrFive++;
            }
            if (diceRoll == 6) {
                diceNbrSix++;
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
        explodingDiceFive(diceNbrFive, diceNbrSix);
        explodingDice(diceNbrSix);
        tesla(diceNbrSix);
        System.out.println();
        System.out.println("Hits: One: " + diceNbrOne + "      Two: " + diceNbrTwo + "        Three: " + diceNbrThree +
                "       Four: " + diceNbrFour + "      Five: " + diceNbrFive + "        Six: " + diceNbrSix);
        System.out.println();
        return numOfHits;
    }

    private void explodingDiceFive(int diceNbrFive, int diceNbrSix) {
        if (explodingFive) {
            int totalDice=(diceNbrFive+diceNbrSix);
            for (int i = 0; i < totalDice; i++) {
                System.out.print("Expl, ");
                numOfHits++;
            }
        }
    }

    public void reRollHit1(int diceNbrOne) {
        if (reRollHitOnes) {
            for (int i = 0; i < diceNbrOne; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new " + diceRoll + ",");
                if (diceRoll == 5) {
                    diceNbrFive++;
                }
                if (diceRoll == 6) {
                    diceNbrSix++;
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
        }
    }

    public void reRollall(int failedDice) {
        if (reRollAllHits) {
            for (int i = 0; i < failedDice; i++) {
                int diceRoll = randomDice.randomD6();
                System.out.print("new " + diceRoll + ",");
                if (diceRoll == 5) {
                    diceNbrFive++;
                }
                if (diceRoll == 6) {
                    diceNbrSix++;
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
        }
    }

    public void explodingDice(int diceNbrSix) {
        if (explodingSix) {
            for (int i = 0; i < diceNbrSix; i++) {
                System.out.print("Expl, ");
                    numOfHits++;
                }
            }
        }

    public void tesla(int diceNbrSix) {
        if (teslaHits) {
            for (int i = 0; i < diceNbrSix; i++) {
                System.out.print("Tesla, ");
                numOfHits= numOfHits+2;
            }
        }
    }
    }
