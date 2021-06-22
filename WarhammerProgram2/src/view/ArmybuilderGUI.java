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

    private JButton addToList;
    private JButton next;
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


        unitsList = new JList();
        chosenUnitsList = new JList();

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
        panel.setPreferredSize(new Dimension(300, 400));
        //chosenUnitsList.setListData();
        panel.add(chosenUnitsList);

        return panel;
    }

    private JPanel leftPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        unitsList.setListData(drukhari.getHQ());
        panel.add(unitsList);
        return panel;
    }

    private JPanel rightPanel() {
        JPanel panel = new JPanel(new GridLayout());
        //panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        panel.add(addToList);
        panel.add(next);

        return panel;
    }

    private void initListeners() {
        ActionListener listener = new armyListener();
        addToList.addActionListener(listener);
        next.addActionListener(listener);
        unitsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                  int selectedIndex = unitsList.getSelectedIndex();
                  drukhari.addtoList(selectedIndex);
                    chosenUnitsList.setListData(drukhari.getUnitList());

                }
            }
        });
    }



    private class armyListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==next){
              //  unitsList.setListData(drukhari.getTroops());
            }
        }
    }
}
