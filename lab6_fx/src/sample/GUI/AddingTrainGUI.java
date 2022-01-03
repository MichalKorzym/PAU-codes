package sample.GUI;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sample.DataManager;
import sample.State;
import sample.Train;
import sample.TrainStation;
import sample.TrainStationContainer;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

public class AddingTrainGUI extends JFrame  {
        public AddingTrainGUI() throws IOException, ClassNotFoundException
        {

            int high=Toolkit.getDefaultToolkit().getScreenSize().height;
            int width=Toolkit.getDefaultToolkit().getScreenSize().width;
            this.setSize(new Dimension(1000,600));
            int frameWidth= this.getSize().width;
            int frameHigh= this.getSize().height;
            this.setLocation((width-frameWidth)/2,(high-frameHigh)/2);
            this.setResizable(false);
           // this.pack();
            try {
                initComponents();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

    public void initComponents() throws IOException, ClassNotFoundException, NoSuchFieldException {
        this.setTitle("Conf GUI");
        this.getContentPane().add(addingPanel).setBackground(Color.PINK);
        setSizeTextField(trainName);
        setSizeTextField(trainSize);
        setSizeTextField(trainState);
        addingPanel.add(trainName);
        addingPanel.add(trainSize);
        addingPanel.add(trainState);
        addingPanel.add(addTrain);
        addingPanel.add(displayTrain);
        TrainStationContainer trainStationContainerDataBase= new TrainStationContainer(new HashMap<String,TrainStation>());

        TrainStationContainer trainStationContainer= new TrainStationContainer(new HashMap<String,TrainStation>());
        DataManager dataManager= new DataManager();
        dataManager.writeData(trainStationContainerDataBase);
         JScrollPane scrollPaneStation= new JScrollPane();
         JScrollPane scrollPaneTrains= new JScrollPane();

        DefaultTableModel model = new DefaultTableModel();
        JTable table1 = new JTable();
        TrainStation trainStation=new TrainStation();

        //refleksje
        Class clTS=trainStation.getClass();
        Train train= new Train();
        Class  clT=train.getClass();
        Object [] columns = new Object[]{clT.getDeclaredField("name").getName(),clT.getDeclaredField("seats_amount").getName(),clT.getDeclaredField("condition").getName()};
        model.setColumnIdentifiers(columns);


        table1.setModel(model);
        scrollPaneTrains.setViewportView(table1);
        addingPanel.add(scrollPaneTrains);

        DefaultTableModel model2 = new DefaultTableModel();
        JTable stationTable = new JTable(model);
        scrollPaneStation.setViewportView(stationTable);
        //refleksje
        model2.addColumn(clTS.getDeclaredField("station_name").getName());
        model2.addColumn(clTS.getDeclaredField("size").getName());
        stationTable.setModel(model2);
        addingPanel.add(scrollPaneStation);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Object[] options= {"Yes, please","No, thanks"};
                int opt= JOptionPane.showOptionDialog(null,"Are you sure??","Warning!",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
                if(opt==0) {

                   JOptionPane.showMessageDialog(null,"Saved");
                }else
                {
                    dataManager.saveData(trainStationContainerDataBase);
                    JOptionPane.showMessageDialog(null,"you resign ");
                }
            }
        });

        displayTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String n=(String) model2.getDataVector().elementAt(stationTable.getSelectedRow()).elementAt(0);
                int rowsCount = model.getRowCount();
                if(rowsCount>0){
                    for(int i=rowsCount-1;i>=0;i--) model.removeRow(i);
                }



                TrainStation tmp;
                 tmp=trainStationContainer.getSelectedStation(n);
                System.out.println(tmp.getStation_name());
                for(Train index: tmp.trainList)
                    model.addRow(new Object[]{ index.getName(),index.getSeats_amount(),index.getCondition()});
                addingPanel.revalidate();
                addingPanel.repaint();


            }
        });

        addTrain.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                model.addRow(new Object[]{ trainName.getText(),Integer.parseInt(trainSize.getText()),trainState.getText()});
                String n=(String) model2.getDataVector().elementAt(stationTable.getSelectedRow()).elementAt(0);

               TrainStation foundedStation=trainStationContainer.getSelectedStation(n);
                Train trainTmp= new Train(trainName.getText(),Integer.parseInt(trainSize.getText()),convert(trainState.getText()));



                foundedStation.addTrain(trainTmp);
                dataManager.saveData(trainStationContainer);
                addingPanel.revalidate();
                addingPanel.repaint();
            }
        });


        addingPanel.add(removeTrain);

        removeTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options= {"Yes, please","No, thanks"};
                int opt= JOptionPane.showOptionDialog(null,"Are you sure??","Warning!",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);

                if(opt==0) {

                    String n = (String) model2.getDataVector().elementAt(stationTable.getSelectedRow()).elementAt(0);
                    String m = (String) model.getDataVector().elementAt(table1.getSelectedRow()).elementAt(0);
                    model.removeRow(table1.getSelectedRow());

                    TrainStation removedTrainStation = trainStationContainer.getSelectedStation(n);
                    removedTrainStation.removeTrainByName(m);
                    dataManager.saveData(trainStationContainer);
                    addingPanel.revalidate();
                    addingPanel.repaint();
                }else
                {
                    JOptionPane.showMessageDialog(null,"you resign ");
                }
            }
        });
        //addingPanel.setLayout(new BorderLayout());

        setSizeTextField(stationName);
        setSizeTextField(stationSize);
        addingPanel.add(stationName);
        addingPanel.add(stationSize);
        addingPanel.add(addStation);
        addingPanel.add(SortbyName);
        addingPanel.add(SortbySeats);

        addingPanel.add(changeData);
        addingPanel.add(RefreshData);


        addStation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainStation   station= new TrainStation(stationName.getText(),new ArrayList<Train>(),Integer.parseInt(stationSize.getText()),0);
                trainStationContainer.addStation(station);
                model2.addRow(new Object[]{ stationName.getText(),Integer.parseInt(stationSize.getText())});

                dataManager.saveData(trainStationContainer);
                addingPanel.revalidate();
                addingPanel.repaint();


            }
        });
        SortbyName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=(String) model2.getDataVector().elementAt(stationTable.getSelectedRow()).elementAt(0);
                int rowsCount = model.getRowCount();
                if(rowsCount>0){
                    for(int i=rowsCount-1;i>=0;i--) model.removeRow(i);
                }

                TrainStation tmp;
                tmp=trainStationContainer.getSelectedStation(n);
                tmp.sortByName();
                for(Train index: tmp.trainList)
                    model.addRow(new Object[]{ index.getName(),index.getSeats_amount(),index.getCondition()});
                addingPanel.revalidate();
                addingPanel.repaint();

            }
        });
        SortbySeats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n=(String) model2.getDataVector().elementAt(stationTable.getSelectedRow()).elementAt(0);
                int rowsCount = model.getRowCount();
                if(rowsCount>0){
                    for(int i=rowsCount-1;i>=0;i--) model.removeRow(i);
                }

                TrainStation tmp;
                tmp=trainStationContainer.getSelectedStation(n);
                tmp.sortBySeats();
                for(Train index: tmp.trainList)
                    model.addRow(new Object[]{ index.getName(),index.getSeats_amount(),index.getCondition()});
                addingPanel.revalidate();
                addingPanel.repaint();
            }
        });



        changeData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame dataFrame= new JFrame();
                JPanel dataPanel = new JPanel();
                dataFrame.add(dataPanel);
                dataFrame.setVisible(true);
                //dataFrame.setResizable(false);
                JTextField newTrainName= new JTextField("Enter new train name");
                JTextField newTrainSize= new JTextField("Enter new train seats amount");
                JTextField newTrainState= new JTextField("Enter new train state");
                JButton confirmButton= new JButton("Confirm");
                dataPanel.add(newTrainName);
                dataPanel.add(newTrainSize);
                dataPanel.add(newTrainState);
                dataPanel.add(confirmButton);
                dataFrame.pack();
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String m=(String)model.getDataVector().elementAt(table1.getSelectedRow()).elementAt(0);
                        String n=(String) model2.getDataVector().elementAt(stationTable.getSelectedRow()).elementAt(0);
                        int selectedRow= table1.getSelectedRow();
                        table1.setValueAt(newTrainName.getText(),selectedRow,0);
                        table1.setValueAt(Integer.parseInt(newTrainSize.getText()),selectedRow,1);
                        table1.setValueAt(newTrainState.getText(),selectedRow,2);


                        TrainStation changingTraingStation=trainStationContainer.getSelectedStation(n);
                       changingTraingStation.changeTrainData(m,newTrainName.getText(),Integer.parseInt(newTrainSize.getText()),convert(newTrainState.getText()));
                        dataManager.saveData(trainStationContainer);
                       addingPanel.revalidate();
                        addingPanel.repaint();
                    }
                });

            }
        });

RefreshData.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dataManager.writeData(trainStationContainer);
        if(trainStationContainer.getAllStations().stream().count()==0)
            JOptionPane.showMessageDialog(null,"DATA BASE IS EMPTY!!!,fill it");
        for(TrainStation index: trainStationContainer.getAllStations())
        model2.addRow(new Object[]{index.getStation_name(),index.getSize()});
        addingPanel.revalidate();
        addingPanel.repaint();


    }
});

    }



        void setSizeTextField(JTextField jt)
        {
          jt.setPreferredSize(new Dimension(110,20));
        }
    public static State convert(String state)
    {
        if(state.equals("NEW"))
            return(State.NEW);
            else if(state.equals("PASSED"))
                return(State.PASSED);
                else if(state.equals("LATE"))
                    return (State.LATE);
                else
                    return(State.BROKEN);

    }



    private JPanel addingPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JButton addTrain= new JButton("Add Train");
    private JButton cancelButton=  new JButton("Cancel");
    private JTextField trainName= new JTextField("Enter the name");
    private JTextField trainSize= new JTextField("Enter the size");
    private JTextField trainState= new JTextField("Enter the state");
    private JButton removeTrain= new JButton("Remove train");
    private JTextField stationName= new JTextField("Enter station name");
    private JTextField stationSize= new JTextField("Enter station size");
    private JButton addStation= new JButton("Add Station");
    private JButton displayTrain= new JButton("Display trains");
    private JButton changeData = new JButton("Change train data");
    private List<Train> trainList=new ArrayList<Train>();
    private JButton SortbyName= new JButton("Sort by Name");
    private JButton SortbySeats= new JButton("Sort by Seats");
    private JButton RefreshData= new JButton("Refresh data");

}
