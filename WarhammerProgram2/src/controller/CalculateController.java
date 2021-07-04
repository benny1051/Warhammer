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
        private boolean rerollHitOnes;
        private boolean reRollWoundOnes;
        private boolean reRollAllWounds;
        private boolean reRollAllHits;
        private boolean explodingSix;
        private boolean teslaHits;
        private boolean explodingFive;
        private boolean feelNoPain5;
        private boolean dakka;
        private double averageHits;
        private double averageWounds;
        private double averageDamage;
        private ArrayList plotHits;
        RandomDice randomDice;
        CalculateHits calculateHits;
        CalculateWounds calculateWounds;
        CalculateSaves calculateSaves;
        CalculateDamage calculateDamage;
        //CalculateAverage calculateAverage;


        ArrayList<String> result;

        public CalculateController(int bs, int str, int tough, int save, int numOfShots, int AP, int damage, boolean reRollHitOnes,
                                   boolean reRollWoundOnes, boolean reRollAllHits, boolean reRollAllWounds, boolean explodingSix,
                                   boolean teslaHits, boolean explodingFive, boolean feelNoPain5, boolean dakkadakka) {
            randomDice= new RandomDice();
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
            this.rerollHitOnes=reRollHitOnes;
            this.reRollWoundOnes=reRollWoundOnes;
            this.reRollAllHits=reRollAllHits;
            this.reRollAllWounds=reRollAllWounds;
            this.explodingFive= explodingFive;
            this.explodingSix=explodingSix;
            this.teslaHits= teslaHits;
            this.feelNoPain5= feelNoPain5;
            this.dakka=dakkadakka;
            result=new ArrayList<String>();
            calculateHits=new CalculateHits(bs,numOfShots, reRollHitOnes,reRollAllHits,explodingSix,teslaHits,explodingFive,dakkadakka);
            //calculateAverage=new CalculateAverage(bs,numOfShots,str,tough,reRollHitOnes,reRollAllHits,explodingSix,teslaHits,
              //      explodingFive,reRollWoundOnes,reRollAllWounds,AP, save,feelNoPain5,dakkadakka);
        }

        public void start() {

            numOfHits = calculateHits.calculateNumberOfHits();
            numOfWounds = calculateWounds.CalculateNumOfWounds(numOfHits,str,tough,reRollWoundOnes,reRollAllWounds);
            savedWound = calculateSaves.calculateSaves(numOfWounds, AP, save,feelNoPain5);

            damageTaken = (numOfWounds - savedWound);
            result.add("Nbr of hits " + numOfHits);
            result.add("Nbr of wounds " + numOfWounds);
            result.add("saves made " + savedWound);
            result.add("Wounds taken " + damageTaken);
            averageMethod();
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

    public void averageMethod(){
        for (int i = 0; i < 10000; i++) {
            calculateHits=new CalculateHits(bs,numOfShots, rerollHitOnes,reRollAllHits,explodingSix,teslaHits,explodingFive,dakka);
            calculateWounds= new CalculateWounds();
            calculateSaves =new CalculateSaves();
            numOfHits = calculateHits.calculateNumberOfHits();
            numOfWounds = calculateWounds.CalculateNumOfWounds(numOfHits, str, tough, reRollWoundOnes, reRollAllWounds);
            savedWound = calculateSaves.calculateSaves(numOfWounds, AP, save, feelNoPain5);


            int averageDamageTaken = (numOfWounds - savedWound);
            averageHits = (averageHits + numOfHits);
            averageWounds=(averageWounds+numOfWounds);
            averageDamage=(averageDamage+averageDamageTaken);

        }
        averageHits= averageHits/10000;
        averageWounds=averageWounds/10000;
        averageDamage=averageDamage/10000;
        result.add("Average hits "+ averageHits);
        result.add("Average wounds "+ averageWounds);
        result.add("Average Wounds taken: "+ averageDamage);
    }
    }


