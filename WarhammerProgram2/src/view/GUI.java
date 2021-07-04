package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import controller.*;

import static java.lang.String.valueOf;

public class GUI extends JFrame {

    private JButton fire;
    private JButton armybuilderButton;
    private JTextField shots;
    private JLabel shotsLabel;
    private JButton reset;
    private JRadioButton rerollOneToHit;
    private JRadioButton rerollOneToWound;
    private JRadioButton rerollAllHits;
    private JRadioButton rerollAllWounds;
    private JRadioButton exploding5;
    private JRadioButton exploding6;
    private JRadioButton teslaShots;
    private JRadioButton fnp5;
    private JRadioButton dakka;
    private JRadioButton autoWound;
    private JScrollPane ballisticScrollPane;

    private ArrayList<String> saveArray;
    private ArrayList<String> ballisticSkillArray;
    private ArrayList<String> strengthArray;
    private ArrayList<String> toughnessArray;
    private ArrayList<String> armorPiercingArray;
    private ArrayList<String> damageArray;

    private JList saveList;
    private JList ballisticSkillList;
    private JList strengthList;
    private JList toughnessList;
    private JList armorPiercingList;
    private JList damageList;



    public GUI() {
        setTitle("Kill calculator");
        setLocation(200, 150);
        setVisible(true);

        saveArray=new ArrayList<String>();
        for (int i = 0; i <= 6; i++) {
            saveArray.add(i+"+");
        }

        ballisticSkillArray=new ArrayList<String>();
        for (int i = 2; i <= 6 ; i++) {
            ballisticSkillArray.add(i+"+");
        }

        strengthArray=new ArrayList<String>();
        for (int i = 3; i <= 16; i++) {
            strengthArray.add("Strength " + i)          ;
        }

        toughnessArray=new ArrayList<String>();
        for (int i = 3; i <= 10; i++) {
            toughnessArray.add("Toughness " + i)          ;
        }

        armorPiercingArray= new ArrayList<String>();
        for (int i = 0; i <= 5; i++) {
            armorPiercingArray.add("AP - " + i);
        }

        damageArray= new ArrayList<String>();
        damageArray.add("D3");
        damageArray.add("1");
        damageArray.add("2");
        damageArray.add("3");
        damageArray.add("4");
        damageArray.add("5");
        damageArray.add("6");
        damageArray.add("D6");

        addPanels();
        initListeners();
    }

    /**
     * Lägger till panelerna.
     */
    private void addPanels() {
        JPanel panel = new JPanel(new BorderLayout());
        fire=new JButton("Fire!");
        armybuilderButton= new JButton("Armybuilder");
        shotsLabel=new JLabel("Num Of Bullets?");
        shots= new JTextField();
        reset=new JButton("Reset");
        rerollOneToHit = new JRadioButton("Reroll 1´s to hit");
        rerollOneToWound= new JRadioButton("Reroll 1´s to wound");
        rerollAllHits = new JRadioButton("Reroll all hits");
        rerollAllWounds = new JRadioButton("Reroll all wounds");
        exploding5 = new JRadioButton("expl 5");
        exploding6 = new JRadioButton("Expl 6");
        teslaShots = new JRadioButton("Tesla");
        fnp5 = new JRadioButton("5+ fnp");
        dakka= new JRadioButton("Dakka");
        autoWound= new JRadioButton("Autowound");

        saveList = new JList();
        ballisticSkillList=new JList();
        strengthList=new JList();
        toughnessList=new JList();
        armorPiercingList= new JList();
        damageList= new JList();
        panel.add(midPanel(), BorderLayout.CENTER);
        panel.add(leftPanel(), BorderLayout.WEST);
        panel.add(rightPanel(), BorderLayout.EAST);
        panel.add(specialPanel(), BorderLayout.SOUTH);

        add(panel);

        pack();
    }


    private JPanel ballisticSkillPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Ballistic skill"));
        panel.setPreferredSize(new Dimension(300, 400));

        ballisticSkillList.setListData(ballisticSkillArray.toArray());
        ballisticScrollPane=new JScrollPane(ballisticSkillList);
        ballisticScrollPane.setPreferredSize(new Dimension(300, 400));
        panel.add(ballisticScrollPane, BorderLayout.CENTER);
        panel.add(reset,BorderLayout.SOUTH);
        return panel;
    }

    private JPanel numOfShotsPanel(){
        JPanel panel= new JPanel(new GridLayout(1,2));
        shotsLabel.setPreferredSize(new Dimension(100,30));
        shots.setPreferredSize(new Dimension(150,30));
        panel.add(fire,BorderLayout.SOUTH);
        return panel;
    }

    private JPanel midPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        panel.add(strengthPanel());
        panel.add(toughnessPanel());
        return panel;
    }
    private JPanel leftPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        panel.add(ballisticSkillPanel());
        panel.add(armorPiercingPanel());
        return panel;
    }

    private JPanel rightPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        panel.add(savePanel());
        panel.add(damagePanel());
        return panel;
    }


    private JPanel strengthPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        strengthList.setListData(strengthArray.toArray());
        panel.add(strengthList, BorderLayout.CENTER);
        return panel;
    }

    private JPanel toughnessPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Toughness characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        toughnessList.setListData(toughnessArray.toArray());
        panel.add(toughnessList, BorderLayout.CENTER);
        return panel;
    }

    private JPanel savePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Save characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        saveList.setListData(saveArray.toArray());
        panel.add(saveList, BorderLayout.CENTER);
        panel.add(numOfShotsPanel(),BorderLayout.SOUTH);
        return panel;
    }
    private JPanel damagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Damage"));
        panel.setPreferredSize(new Dimension(300, 400));
        damageList.setListData(damageArray.toArray());
        panel.add(damageList, BorderLayout.CENTER);
        panel.add(numOfShotsPanel(),BorderLayout.SOUTH);
        return panel;
    }

    private JPanel armorPiercingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("armor Piercing"));
        panel.setPreferredSize(new Dimension(300, 400));
        armorPiercingList.setListData(armorPiercingArray.toArray());
        panel.add(armorPiercingList, BorderLayout.CENTER);
        return panel;
    }

    private JPanel specialPanel(){
        JPanel panel= new JPanel(new FlowLayout());
       // rerollOneToHit.setPreferredSize(new Dimension(200,30));
        // rerollOneToWound.setPreferredSize(new Dimension(200,30));
        panel.setPreferredSize(new Dimension(300,400));
        panel.add(rerollOneToHit);
        panel.add(rerollAllHits);
        panel.add(rerollOneToWound);
        panel.add(rerollAllWounds);
        panel.add(exploding5);
        panel.add(exploding6);
        panel.add(teslaShots);
        panel.add(fnp5);
        panel.add(armybuilderButton);
        panel.add(dakka);
        panel.add(autoWound);
        panel.add(shotsLabel);
        panel.add(shots);
        return panel;

    }



    private void initListeners() {
        ActionListener listener = new ButtonListener();
        fire.addActionListener(listener);
        reset.addActionListener(listener);
        armybuilderButton.addActionListener(listener);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }



    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fire) {
                int bs = ballisticSkillList.getSelectedIndex();
                int str = strengthList.getSelectedIndex();
                int tough = toughnessList.getSelectedIndex();
                int save = saveList.getSelectedIndex();
                int numOfShots = Integer.parseInt(shots.getText());
                int AP = armorPiercingList.getSelectedIndex();
                int damage = damageList.getSelectedIndex();
                boolean reRollHitOnes= rerollOneToHit.isSelected();
                boolean reRollWoundOnes=rerollOneToWound.isSelected();
                boolean reRollAllHits= rerollAllHits.isSelected();
                boolean reRollAllWounds= rerollAllWounds.isSelected();
                boolean explodingFive= exploding5.isSelected();
                boolean explodingSix=exploding6.isSelected();
                boolean teslaHits = teslaShots.isSelected();
                boolean feelNoPain5 = fnp5.isSelected();
                boolean dakkadakka= dakka.isSelected();
                boolean autoWoundingOn6= autoWound.isSelected();

                CalculateController calculateController = new CalculateController(bs, str, tough, save, numOfShots, AP, damage,reRollHitOnes,
                        reRollWoundOnes,reRollAllHits,reRollAllWounds,explodingSix,teslaHits,explodingFive,feelNoPain5,dakkadakka,autoWoundingOn6);
                calculateController.addPropertyChangeListener(new AlarmPrinter());
                calculateController.start();
            } else if (e.getSource() == reset) {

                ballisticSkillList.setListData(ballisticSkillArray.toArray());

            } else if (e.getSource() == armybuilderButton) {
                ArmybuilderGUI armybuilderGUI=new ArmybuilderGUI();
            }

        }
    }

        private class AlarmPrinter implements PropertyChangeListener {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("message")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            ballisticSkillList.setListData((Object[]) evt.getNewValue());

                        }
                    });

                }
            }
        }
    }








