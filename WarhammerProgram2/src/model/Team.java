package model;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Team {

    private int totalCost;
    private String[] HQ= new String[40];

    private ArrayList<String> unitList;
    private String[] descriptionArray = {"Power from pain\n2+ invuln that last until a 1 is rolled.(cant reroll)\nKabal and Incubi reroll 1 to hit",
    "Power from pain\nCombat Drugs\n4+invuln\n wych cult reroll 1 to wound within 6'\nEnemies must win rolloff to fall back",
    "Power from ance","Cluster caltrops","Grav-talon","Stunclaw","Drukhari haywire blaster","Shardcarbine","Power lance",
            "Disintegrator cannon","Chain snares","Grisly trophies","Shock prow","Twin splinter rifle","2 Dark Scythes","Voidraven missiles"};

    private String[] equipment = new String[40];

    private String[] traitList = new String[40];


    public Team(String team) {

        unitList = new ArrayList();

        if (Integer.parseInt(team) == 1) {
            try {
                readHQFile("DrukhariHQ");
                readTraitsFile("DrukhariTraits");
                readEquipmentFile("DrukhariEquipment");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public String[] getHQ() {
        return HQ;
    }
    public String[] getEquipment() {
        return equipment;
    }


    public Object[] getUnitList() {
        return unitList.toArray();
    }

    public Object[] getTraitsList() {
        return traitList;
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

    public void addtoList(int index, String selectedName) {
        unitList.add("- - - - - - - - - - - - - - - - - - - - ");
        String nbrOfUnits= JOptionPane.showInputDialog("How many?");
        unitList.add(nbrOfUnits+"X"+HQ[index]);
        if (selectedName.equals("Archon")){
            unitList.add("M:8, WS:2+, BS:2+, S:3, T:3, W:5, A:5, LD:9, SV:4+/2++");
            totalCost=totalCost+70;
        }if (index==1){
            totalCost=totalCost+60;
        }if (index==2){
            totalCost=totalCost+80;
        }if (index==3){
            totalCost=totalCost+145;
        }

    }

    public void addequipmentToList(String name) {
        unitList.add("-"+name);
    }

    public void addTraitsToList(String name) {
        unitList.add("-"+name);
    }

    public void saveList() throws IOException{
            try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/Drukhari.txt"), StandardCharsets.UTF_8)))
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

    public Object[] readArmyList(String filename) throws IOException {
        unitList.clear();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files/"+filename+".txt"), StandardCharsets.UTF_8)) ) {
            String unit = br.readLine();
            while(unit!=null) {
                unitList.add(unit);
                unit = br.readLine();
            }
        }
        return unitList.toArray();
    }

    public void readHQFile(String filename) throws IOException {
        int i=0;
        try( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files/"+filename+".txt"), StandardCharsets.UTF_8)) ) {
            String unit = br.readLine();
            while(unit!=null) {
                HQ[i]=unit;
                i++;
                unit = br.readLine();
            }
        }
    }

    public void readTraitsFile(String filename) throws IOException {
        int i=0;
        try( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files/"+filename+".txt"), StandardCharsets.UTF_8)) ) {
            String unit = br.readLine();
            while(unit!=null) {
                traitList[i]=unit;
                i++;
                unit = br.readLine();
            }
        }
    }

    private void readEquipmentFile(String filename) throws IOException {
        int i=0;
        try( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files/"+filename+".txt"), StandardCharsets.UTF_8)) ) {
            String unit = br.readLine();
            while(unit!=null) {
                equipment[i]=unit;
                i++;
                unit = br.readLine();
            }
        }
    }

    public Object[] deleteFromUnitList(int index) {
        unitList.remove(index);
        return unitList.toArray();
    }


}

