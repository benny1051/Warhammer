package controller;

public class CalculateDamage {

    public String calculateTheDamage(int damage) {
        if (damage == 1 || damage == 2 || damage == 3 || damage == 4 || damage == 5 || damage == 6) {
            return "Damage " + damage;

        }
        return "";
    }
}
