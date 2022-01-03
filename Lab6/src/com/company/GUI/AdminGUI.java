package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

   public AdminGUI(){

       int high=Toolkit.getDefaultToolkit().getScreenSize().height;
       int width=Toolkit.getDefaultToolkit().getScreenSize().width;
       this.setSize(width,high);
       int frameWidth= this.getSize().width;
       int frameHigh= this.getSize().height;
       this.setLocation((width-frameWidth)/2,(high-frameHigh)/2);
       initComponents();
      // this.pack();
       this.setDefaultCloseOperation(3);
   }
    public void initComponents()
    {
        this.setTitle("Admin GUI");
       //this.getContentPane().setLayout(layout);
        this.getContentPane().add(panel).setBackground(Color.YELLOW);
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);
        panel.add(tomTrain);
        panel.setLayout(new GridLayout(3,1));
        panel.add(addTrain);

        addTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


               new AddingTrainGUI().setVisible(true);

            }
        });



    }
    private GroupLayout layout= new GroupLayout(getContentPane());
    private JPanel panel= new JPanel();
    private JLabel label= new JLabel("Admin Panel");
    private JLabel tomTrain= new JLabel(new ImageIcon("D:\\PAU\\lab2\\A_10298507.jpg"));
    private JButton addTrain= new JButton("PKP panel");
    JButton add_train= new JButton("Add Train");
    JButton cancel= new JButton("Cancel");
    JTextField trainName= new JTextField("Enter train name");
}
