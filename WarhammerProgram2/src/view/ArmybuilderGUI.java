package view;

import model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ArmybuilderGUI extends JFrame {
    private JList unitsList;
    private JList chosenUnitsList;
    private JList descriptionList;
    private JList equipmentList;
    private JList traitsList;
    private JLabel totalCost;

    private JButton addToList;
    private JButton save;
    private JButton readList;
    private JButton deleteFromUnitList;
    private JTextArea decriptionArea;
    private Team team;


    public ArmybuilderGUI() {
        setTitle("Army builder");
        setLocation(200, 150);
        setVisible(true);

        String team= JOptionPane.showInputDialog("Print 1 for Drukhari");
        this.team = new Team(team);

        addPanels();
        //initListeners();
    }

    private void addPanels() {
        JPanel panel = new JPanel(new BorderLayout());
        addToList = new JButton("Add");
        save = new JButton("Save");
        readList= new JButton("Read file");
        deleteFromUnitList=new JButton("Delete");
        decriptionArea= new JTextArea();
        totalCost= new JLabel();

        unitsList = new JList();
        chosenUnitsList = new JList();
        equipmentList = new JList();
        traitsList= new JList();

        panel.add(midPanel(), BorderLayout.CENTER);
        panel.add(leftPanel(), BorderLayout.WEST);
        panel.add(rightPanel(), BorderLayout.EAST);

        add(panel);
        initListeners();

        pack();
    }

    private JPanel midPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 600));
        traitsList.setListData(team.getTraitsList());
        panel.add(traitsList);
        panel.add(chosenUnitsList);

        return panel;
    }

    private JPanel leftPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 600));
        unitsList.setListData(team.getHQ());
        equipmentList.setListData(team.getEquipment());
        panel.add(unitsList);
        panel.add(equipmentList);
        return panel;
    }

    private JPanel rightPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 600));
        panel.add(decriptionArea);
        panel.add(totalCost);
        panel.add(save);
        panel.add(readList);
        panel.add(deleteFromUnitList);

        return panel;
    }

    private void initListeners() {
        ActionListener listener = new armyListener();
        addToList.addActionListener(listener);
        save.addActionListener(listener);
        readList.addActionListener(listener);
        deleteFromUnitList.addActionListener(listener);
        unitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    String hej = (String) unitsList.getSelectedValue();
                    decriptionArea.setText(team.getDescription(hej));
                }
                if (e.getClickCount() > 1) {
                    int selectedIndex = unitsList.getSelectedIndex();
                    String selectedName= (String) unitsList.getSelectedValue();
                    team.addtoList(selectedIndex,selectedName);
                    chosenUnitsList.setListData(team.getUnitList());
                    totalCost.setText("Total Cost: " + String.valueOf(team.getTotalCost()));
                }
            }
        });
        chosenUnitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    String selectedIndex = (String) chosenUnitsList.getSelectedValue();
                    System.out.println(selectedIndex);
                    decriptionArea.setText(team.getDescription(selectedIndex));
                }
            }
        });

        equipmentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    String name = (String) equipmentList.getSelectedValue();
                    team.addequipmentToList(name);
                    equipmentList.setListData(team.getEquipment());
                    chosenUnitsList.setListData(team.getUnitList());
                    totalCost.setText("Total Cost: " + String.valueOf(team.getTotalCost()));
                }
            }
        });

        traitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    String name = (String) traitsList.getSelectedValue();
                    team.addTraitsToList(name);
                    traitsList.setListData(team.getTraitsList());
                    chosenUnitsList.setListData(team.getUnitList());
                    totalCost.setText("Total Cost: " + String.valueOf(team.getTotalCost()));
                }
            }
        });
    }



    private class armyListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==save){
                try {
                    team.saveList();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if (e.getSource()==readList){
                String fileName= JOptionPane.showInputDialog("File name");
                try {
                    chosenUnitsList.setListData(team.readArmyList(fileName));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else if (e.getSource()==deleteFromUnitList) {
                int index = chosenUnitsList.getSelectedIndex();

                chosenUnitsList.setListData(team.deleteFromUnitList(index));
            }
        }

    }
}
