package controller;

import model.RandomDice;

public class CalculateWounds {

    private int numOfWounds;
    private int diceNbrOne;
    private int diceNbrSix;


    RandomDice randomDice;

    public CalculateWounds() {
        randomDice = new RandomDice();


    }

    public int CalculateNumOfWounds(int numOfHits, int str, int tough, boolean reRollWoundOnes, boolean reRollAllWounds, boolean autoWound6, int sixesFromHitsClass, boolean devWounds) {

        str = str + 3;
        tough = tough + 3;
       // System.out.print("Wounds: ");
       numOfHits= autoWoundSixes(sixesFromHitsClass, autoWound6,numOfHits);
        for (int i = 0; i < numOfHits; i++) {
            int diceRoll = randomDice.randomD6();
           // System.out.print(diceRoll + ",");

            if (diceRoll == 1) {
                diceNbrOne++;
            }
            if (diceRoll == 6 && devWounds) {
                diceNbrSix++;
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
                if (devWounds) {
                    numOfWounds =numOfWounds+ 2;
                }
            }

        }

        reRollWound1(diceNbrOne, reRollWoundOnes, str, tough);
        int failedWounds = (numOfHits-numOfWounds);
        reRollAll(str, tough, reRollAllWounds,failedWounds);

       // System.out.println();
            if (devWounds){
                numOfWounds=numOfWounds-diceNbrSix;
            }
        return numOfWounds;
    }


    public void reRollWound1(int diceNbrOne, boolean reRollWoundOnes, int str, int tough) {
        if (reRollWoundOnes) {
            for (int i = 0; i < diceNbrOne; i++) {
                int diceRoll = randomDice.randomD6();
              //  System.out.print("new " + diceRoll + ",");
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
               // System.out.print("new " + diceRoll + ",");

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
    public int autoWoundSixes(int diceNbrSix, boolean autoWound6, int numOfHits) {
        if (autoWound6) {

            for (int i = 0; i < diceNbrSix; i++) {
                    numOfWounds++;
                    numOfHits--;
                }
            }
        return numOfHits;
        }

         public int getDiceNbrSix() {
        return diceNbrSix;
    }

}
