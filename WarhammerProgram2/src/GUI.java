import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.valueOf;

public class GUI extends JFrame {

    private JButton fire;
    private JTextField shots;
    private JLabel shotsLabel;

    private ArrayList<String> saveArray;
    private ArrayList<String> ballisticSkillArray;
    private ArrayList<String> strengthArray;
    private ArrayList<String> toughnessArray;

    private JList saveList;
    private JList ballisticSkillList;
    private JList strengthList;
    private JList toughnessList;

    private JLabel imageLabel = new JLabel(" ", JLabel.CENTER);

    private ImageIcon image;


    public GUI() {
        setTitle("Client UI");
        setLocation(200, 150);
        setVisible(true);

        saveArray=new ArrayList<String>();
        saveArray.add("0+");
        saveArray.add("1+");
        saveArray.add("2+");
        saveArray.add("3+");
        saveArray.add("4+");
        saveArray.add("5+");
        saveArray.add("6+");

        ballisticSkillArray=new ArrayList<String>();
        ballisticSkillArray.add("2+");
        ballisticSkillArray.add("3+");
        ballisticSkillArray.add("4+");
        ballisticSkillArray.add("5+");
        ballisticSkillArray.add("6+");

        strengthArray=new ArrayList<String>();
        strengthArray.add("Strength 3");
        strengthArray.add("Strength 4");
        strengthArray.add("Strength 5");
        strengthArray.add("Strength 6");
        strengthArray.add("Strength 7");
        strengthArray.add("Strength 8");
        strengthArray.add("Strength 9");
        strengthArray.add("Strength 10");
        strengthArray.add("Strength 11");
        strengthArray.add("Strength 12");
        strengthArray.add("Strength 13");
        strengthArray.add("Strength 14");
        strengthArray.add("Strength 15");
        strengthArray.add("Strength 16");

        toughnessArray=new ArrayList<String>();
        toughnessArray.add("Toughness 3");
        toughnessArray.add("Toughness 4");
        toughnessArray.add("Toughness 5");
        toughnessArray.add("Toughness 6");
        toughnessArray.add("Toughness 7");
        toughnessArray.add("Toughness 8");
        toughnessArray.add("Toughness 9");
        toughnessArray.add("Toughness 10");

        addPanels();
        initListeners();
    }

    /**
     * Lägger till panelerna.
     */
    private void addPanels() {
        JPanel panel = new JPanel(new BorderLayout());
        fire=new JButton("Fire!");
        shotsLabel=new JLabel("Number of Shots");
        shots= new JTextField();
        saveList = new JList();
        ballisticSkillList=new JList();
        strengthList=new JList();
        toughnessList=new JList();
        panel.add(midPanel(), BorderLayout.CENTER);
        panel.add(ballisticSkillPanel(), BorderLayout.WEST);
        panel.add(savePanel(), BorderLayout.EAST);

        add(panel);

        pack();
    }


    private JPanel imagePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel);
        return panel;
    }


    private JPanel ballisticSkillPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Ballistic skill"));
        panel.setPreferredSize(new Dimension(300, 400));
        ballisticSkillList.setListData(ballisticSkillArray.toArray());
        panel.add(ballisticSkillList, BorderLayout.CENTER);
        panel.add(numOfShotsPanel(),BorderLayout.SOUTH);
        return panel;
    }

    private JPanel numOfShotsPanel(){
        JPanel panel= new JPanel(new BorderLayout());
        shotsLabel.setPreferredSize(new Dimension(100,30));
        shots.setPreferredSize(new Dimension(150,30));
        panel.add(shotsLabel,BorderLayout.WEST);
        panel.add(shots, BorderLayout.EAST);
        return panel;
    }

    private JPanel midPanel() {
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));

        panel.add(strengthPanel());
        panel.add(toughnessPanel());
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
        panel.setBorder(BorderFactory.createTitledBorder("Strength characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        toughnessList.setListData(toughnessArray.toArray());
        panel.add(toughnessList, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Panelen för mottagare,
     *
     * @return panelen.
     */
    private JPanel savePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Save characteristic"));
        panel.setPreferredSize(new Dimension(300, 400));
        saveList.setListData(saveArray.toArray());
        panel.add(saveList, BorderLayout.CENTER);
        panel.add(fire, BorderLayout.SOUTH);

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
                CalculateWounds calculateWounds= new CalculateWounds(bs,str,tough,save,numOfShots);
            }

        }
    }


}





