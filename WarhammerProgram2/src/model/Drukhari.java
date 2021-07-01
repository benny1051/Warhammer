package model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Drukhari {

    private int totalCost;
    private String[] HQ = {"Archon", "Succubus", "Haemonculus","Drazhar", "Kabalites", "Wyches",
            "Wracks","Beastmaster", "Grotesques","Incubi","Mandrakes", "Lhamean","Sslyth",
            "Ur-Ghul","Medusae","Clawed Fiends","Hellions","Reavers", "Scourges","Cronos",
            "Ravager","Raider","Reaper","Talos","Tantalus"};
    private ArrayList<String> unitList;
    private String[] descriptionArray = {"Power from pain\n2+ invuln that last until a 1 is rolled.(cant reroll)\nKabal and Incubi reroll 1 to hit",
    "Power from pain\nCombat Drugs\n4+invuln\n wych cult reroll 1 to wound within 6'\nEnemies must win rolloff to fall back",
    "Power from pain\n 5+ invuln\nAdd 1 to T for <coven> within 6'",
    "Power from Pain\n4+ invuln\nAlways fights twice(2 activations)\n +1 to wound to all Incubi(including himself)"};

    private String[] equipment = {"Husk blade","Splinter pistol","Power sword","Venom blade","Blast pistol","Agoniser","Archite glaive","Razorflails",
            "Hydra gauntlets","Shardnet and impaler","Impaler","Blaster","Dark lance","Phantasm grenade launcher","Shredder","Splinter cannon",
            "Demiklaives","Heat lance","Cluster caltrops","Grav-talon","Stunclaw","Drukhari haywire blaster","Shardcarbine","Power lance",
            "Disintegrator cannon","Chain snares","Grisly trophies","Shock prow","Twin splinter rifle","2 Dark Scythes","Voidraven missiles"};

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

    public void saveList() throws IOException{
            try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/DrukhariArmyList.txt"), StandardCharsets.UTF_8)))
            {for (int i = 0; i < unitList.size(); i++)
            {
                bos.write(unitList.get(i));
                bos.newLine();}
                bos.flush();}
            printArmyList();
        }

    private void printArmyList() {
        for(String s : unitList) {
            System.out.print(s + "\n ");
        }
        System.out.println();
    }
    }

