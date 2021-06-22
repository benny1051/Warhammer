package model;

import java.util.ArrayList;

public class Drukhari {

    private String[] HQ = {"Archon", "Succubus", "Homunculus", "Kabalites", "Wyches", "Wracks"};
    private ArrayList<String> unitList;
    private ArrayList<String> descriptionArray;

    public Drukhari() {
        descriptionArray = new ArrayList<String>();
        unitList=new ArrayList();
    }

    public String[] getHQ() {
        return HQ;
    }

    public void addtoList(int index) {
        unitList.add(HQ[index]);
    }

    public Object[] getUnitList(){
        return unitList.toArray();
    }
}
