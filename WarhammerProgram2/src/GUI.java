import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.valueOf;

public class GUI extends JFrame {

    private JButton fire;
    private JTextField shots;
    private JLabel shotsLabel;
    private JRadioButton rerollOne;

    private ArrayList<String> saveArray;
    private ArrayList<String> ballisticSkillArray;
    private ArrayList<String> strengthArray;
    private ArrayList<String> toughnessArray;
    private ArrayList<String> armorPiercingArray;

    private JList saveList;
    private JList ballisticSkillList;
    private JList strengthList;
    private JList toughnessList;
    private JList armorPiercingList;
    public GUI() {
        setTitle("Client UI");
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

        addPanels();
        initListeners();
    }

    /**
     * Lägger till panelerna.
     */
    private void addPanels() {
        JPanel panel = new JPanel(new BorderLayout());
        fire=new JButton("Fire!");
        shotsLabel=new JLabel("Num Of Bullets?");
        shots= new JTextField();
        rerollOne=new JRadioButton("Reroll 1´s");// Finns ingen funktion på den än. Bara syns. 
        saveList = new JList();
        ballisticSkillList=new JList();
        strengthList=new JList();
        toughnessList=new JList();
        armorPiercingList= new JList();
        panel.add(midPanel(), BorderLayout.CENTER);
        panel.add(leftPanel(), BorderLayout.WEST);
        panel.add(savePanel(), BorderLayout.EAST);

        add(panel);

        pack();
    }


    private JPanel ballisticSkillPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Ballistic skill"));
        panel.setPreferredSize(new Dimension(300, 400));
        ballisticSkillList.setListData(ballisticSkillArray.toArray());
        panel.add(ballisticSkillList, BorderLayout.CENTER);
        panel.add(rerollOne,BorderLayout.SOUTH);
        return panel;
    }

    private JPanel numOfShotsPanel(){
        JPanel panel= new JPanel(new GridLayout(1,2));
        shotsLabel.setPreferredSize(new Dimension(100,30));
        shots.setPreferredSize(new Dimension(150,30));
        panel.add(shotsLabel,BorderLayout.WEST);
        panel.add(shots, BorderLayout.EAST);
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

    private JPanel armorPiercingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("armor Piercing"));
        panel.setPreferredSize(new Dimension(300, 400));
        armorPiercingList.setListData(armorPiercingArray.toArray());
        panel.add(armorPiercingList, BorderLayout.CENTER);
        return panel;
    }



    private void initListeners() {
        ActionListener listener = new ButtonListener();
        fire.addActionListener(listener);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void showResult(ArrayList<Integer> result) {

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

                CalculateWounds calculateWounds= new CalculateWounds(bs,str,tough,save,numOfShots,AP);
            }

        }
    }


}





