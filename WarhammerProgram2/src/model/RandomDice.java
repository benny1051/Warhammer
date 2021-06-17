package model;

public class RandomDice {

    public int randomD6() {

        java.util.Random random = new java.util.Random();
        int diceRoll = random.nextInt(6);
        diceRoll++;

        return diceRoll;

    }
    public int randomD3() {

        java.util.Random random = new java.util.Random();
        int diceRoll = random.nextInt(3);
        diceRoll++;

        return diceRoll;

    }
}
