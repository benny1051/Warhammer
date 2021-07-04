/*
package controller;

import model.RandomDice;

import java.util.Random;

public class CalculateAverage {
    private double averageHits;
    private double averageWounds;
    private double averageDamage;
    private int bajs;
    private int numOfWounds;
    private int savedWound;
    private int damageTaken;
    private CalculateHits calculateHits;
    private CalculateWounds calculateWounds;
    private CalculateSaves calculateSaves;



    public CalculateAverage(int bs, int numOfShots, int str, int tough, boolean reRollHitOnes, boolean reRollAllHits, boolean explodingSix, boolean teslaHits,
                            boolean explodingFive, boolean reRollWoundOnes, boolean reRollAllWounds,
                            int AP, int save, boolean feelNoPain5,boolean dakka) {



        for (int i = 0; i < 10000; i++) {
            calculateHits= new CalculateHits(bs,numOfShots, reRollHitOnes,reRollAllHits,explodingSix,teslaHits,explodingFive,dakka);
            calculateWounds= new CalculateWounds();
            calculateSaves =new CalculateSaves();
            bajs = calculateHits.calculateNumberOfHits();
            numOfWounds = calculateWounds.CalculateNumOfWounds(bajs, str, tough, reRollWoundOnes, reRollAllWounds);
            savedWound = calculateSaves.calculateSaves(numOfWounds, AP, save, feelNoPain5);


            damageTaken = (numOfWounds - savedWound);
            averageHits = (averageHits + bajs);
            averageWounds=(averageWounds+numOfWounds);
            averageDamage=(averageDamage+damageTaken);

        }
       averageHits= averageHits/10000;
        averageWounds=averageWounds/10000;
        averageDamage=averageDamage/10000;
        System.out.println("Average hits "+ averageHits);
        System.out.println("Average wounds "+ averageWounds);
        System.out.println("Average Wounds taken: "+ averageDamage);
    }
}


*/
