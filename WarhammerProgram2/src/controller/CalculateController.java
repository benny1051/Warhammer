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

        ArrayList<String> result;

        public CalculateController(int bs, int str, int tough, int save, int numOfShots, int AP, int damage) {
            randomDice= new RandomDice();
            calculateHits=new CalculateHits(bs,numOfShots);
            calculateWounds=new CalculateWounds();
            calculateSaves= new CalculateSaves();
            this.bs = bs;
            this.str = str;
            this.tough = tough;
            this.save = save;
            this.numOfShots = numOfShots;
            this.AP= AP;
            this.damage=damage;
            result=new ArrayList<String>();

        }

        public void start(){
            numOfHits= calculateHits.calculateNumberOfHits();
            numOfWounds= calculateWounds.CalculateNumOfWounds(numOfHits);
            savedWound= calculateSaves.calculateSaves(numOfWounds,AP,save);

            damageTaken = (numOfWounds - savedWound);
            
            result.add("Number of hits " + numOfHits);
            result.add("Number of wounds " + numOfWounds);
            result.add("saves made " + savedWound);
            result.add("Wounds taken " + damageTaken);
            changes.firePropertyChange("message", false, result.toArray());
        }

        public void addPropertyChangeListener(PropertyChangeListener listener){
            changes.addPropertyChangeListener(listener);
        }
        public void removePropertyChangeListener(PropertyChangeListener listener){
            changes.removePropertyChangeListener(listener);
        }







        }

