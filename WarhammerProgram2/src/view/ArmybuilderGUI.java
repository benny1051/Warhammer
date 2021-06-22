package view;

import model.Drukhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class ArmybuilderGUI extends JFrame {
    private JList unitsList;
    private JList chosenUnitsList;
    private JList descriptionList;
    private JList equipmentList;
    private JLabel totalCost;

    private JButton addToList;
    private JButton next;
    private JTextArea decriptionArea;
    private Drukhari drukhari;


    public ArmybuilderGUI() {
        setTitle("Army builder");
        setLocation(200, 150);
        setVisible(true);


        drukhari = new Drukhari();


        addPanels();
        //initListeners();
    }

    private void addPanels() {
        JPanel panel = new JPanel(new BorderLayout());
        addToList = new JButton("Add");
        next = new JButton("Next");
        decriptionArea= new JTextArea();
        totalCost= new JLabel();

        unitsList = new JList();
        chosenUnitsList = new JList();
        equipmentList = new JList();

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
        //chosenUnitsList.setListData();
        panel.add(chosenUnitsList);

        return panel;
    }

    private JPanel leftPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 600));
        unitsList.setListData(drukhari.getHQ());
        equipmentList.setListData(drukhari.getEquipment());
        panel.add(unitsList);
        panel.add(equipmentList);
        return panel;
    }

    private JPanel rightPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 600));
        panel.add(decriptionArea,BorderLayout.CENTER);
        panel.add(totalCost,BorderLayout.SOUTH);

        return panel;
    }

    private void initListeners() {
        ActionListener listener = new armyListener();
        addToList.addActionListener(listener);
        next.addActionListener(listener);
        unitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    String hej = (String) unitsList.getSelectedValue();
                    decriptionArea.setText(drukhari.getDescription(hej));
                }
                if (e.getClickCount() > 1) {
                    int selectedIndex = unitsList.getSelectedIndex();
                    drukhari.addtoList(selectedIndex);
                    chosenUnitsList.setListData(drukhari.getUnitList());
                    totalCost.setText("Total Cost: " + String.valueOf(drukhari.getTotalCost()));
                }
            }
        });
        chosenUnitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    String selectedIndex = (String) chosenUnitsList.getSelectedValue();
                    System.out.println(selectedIndex);
                    decriptionArea.setText(drukhari.getDescription(selectedIndex));
                }
            }
        });

        equipmentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    String name = (String) equipmentList.getSelectedValue();
                    drukhari.addequipmentToList(name);
                    equipmentList.setListData(drukhari.getEquipment());
                    chosenUnitsList.setListData(drukhari.getUnitList());
                    totalCost.setText("Total Cost: " + String.valueOf(drukhari.getTotalCost()));
                }
            }
        });
    }



    private class armyListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==next){
           //     unitsList.setListData(drukhari.getEquipment());
            }
        }
    }
}
