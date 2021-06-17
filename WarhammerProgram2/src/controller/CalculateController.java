package controller;

import model.RandomDice;

import java.beans.PropertyChangeEvent;
    import java.beans.PropertyChangeListener;
    import java.beans.PropertyChangeSupport;
    import java.util.ArrayList;
import java.util.Random;

    public class CalculateController {
        private final PropertyChangeSupport changes= new PropertyChangeSupport(this);
        private int bs;
        private int str;
        private int tough;
        private int save;
        private int numOfShots;
        private int numOfHits;
        private int numOfWounds;
        private int savedWound;
        private int AP;
        private int damageTaken;
        private int damage;
        RandomDice randomDice;
        CalculateHits calculateHits;
        CalculateWounds calculateWounds;
        CalculateSaves calculateSaves;
        CalculateDamage calculateDamage;

        ArrayList<String> result;

        public CalculateController(int bs, int str, int tough, int save, int numOfShots, int AP, int damage) {
            randomDice= new RandomDice();
            calculateHits=new CalculateHits(bs,numOfShots);
            calculateWounds=new CalculateWounds();
            calculateSaves= new CalculateSaves();
            calculateDamage= new CalculateDamage();
            this.bs = bs;
            this.str = str;
            this.tough = tough;
            this.save = save;
            this.numOfShots = numOfShots;
            this.AP= AP;
            this.damage=damage;
            result=new ArrayList<String>();

        }

        public void start() {
            numOfHits = calculateHits.calculateNumberOfHits();
            numOfWounds = calculateWounds.CalculateNumOfWounds(numOfHits,str,tough);
            savedWound = calculateSaves.calculateSaves(numOfWounds, AP, save);

            damageTaken = (numOfWounds - savedWound);
            result.add("Nbr of hits " + numOfHits);
            result.add("Nbr of wounds " + numOfWounds);
            result.add("saves made " + savedWound);
            result.add("Wounds taken " + damageTaken);
            result.add(calculateDamage.calculateTheDamage(damage));
            if (damage == 0) {
                for (int i = 0; i < damageTaken; i++) {
                    int randomD3 = randomDice.randomD3();
                    result.add("D3 Damage = " + randomD3);
                }
            } else if (damage == 7) {
                for (int i = 0; i < damageTaken; i++) {
                    int randomD6 = randomDice.randomD6();
                    result.add("D6 Damage = " + randomD6);
                }
            }
            changes.firePropertyChange("message", false, result.toArray());
        }

        public void addPropertyChangeListener(PropertyChangeListener listener){
            changes.addPropertyChangeListener(listener);
        }
        public void removePropertyChangeListener(PropertyChangeListener listener){
            changes.removePropertyChangeListener(listener);
        }







        }

