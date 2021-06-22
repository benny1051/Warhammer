package model;

import java.util.ArrayList;

public class Drukhari {

    private int totalCost;
    private String[] HQ = {"Archon", "Succubus", "Haemonculus","Drazhar", "Kabalites", "Wyches",
            "Wracks","Beastmaster", "Grotesques","Incubi","Mandrakes", "Lhamean","Sslyth",
            "Ur-Ghul","Medusae","Clawed Fiends","Hellions","Reavers", "Scourges","Cronos",
            "Ravager","Reaper","Talos","Tantalus"};
    private ArrayList<String> unitList;
    private String[] descriptionArray = {"Power from pain\n2+ invuln that last until a 1 is rolled.(cant reroll)\nKabal and Incubi reroll 1 to hit",
    "Power from pain\nCombat Drugs\n4+invuln\n wych cult reroll 1 to wound within 6'\nEnemies must win rolloff to fall back",
    "Power from pain\n 5+ invuln\nAdd 1 to T for <coven> within 6'",
    "Power from Pain\n4+ invuln\nAlways fights twice(2 activations)\n +1 to wound to all Incubi(including himself)"};

    private String[] equipment = {"Husk blade","Splinter pistol","Blast pistol","Agonizer","Archite Glaive","Razorflails","Hydra gauntlets","Shardnet and impaler","Impaler"};
    public Drukhari() {

        unitList = new ArrayList();
    }

    public String[] getHQ() {
        return HQ;
    }
    public String[] getEquipment() {
        return equipment;
    }

    public void addtoList(int index) {
        unitList.add("- - - - - - - - - - - - - - - - - - - - ");
        unitList.add(HQ[index]);
        if (index==0){
            totalCost=totalCost+70;
        }if (index==1){
            totalCost=totalCost+60;
        }if (index==2){
            totalCost=totalCost+80;
        }if (index==3){
            totalCost=totalCost+145;
        }

    }

    public Object[] getUnitList() {
        return unitList.toArray();
    }

    public String getDescription(String name) {
        if (name.equals("Archon")) {
            return descriptionArray[0];
        }if (name.equals("Succubus")) {
                return descriptionArray[1];
            }
        if (name.equals("Haemonculus")) {
            return descriptionArray[2];
        }
        if (name.equals("Drazhar")) {
            return descriptionArray[3];
        }

        return "none";
        }

    public int getTotalCost() {
        return totalCost;
    }

    public void addequipmentToList(String name) {
        unitList.add("-"+name);
    }
}
