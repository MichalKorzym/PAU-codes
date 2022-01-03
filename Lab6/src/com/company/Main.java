package com.company;

import com.company.GUI.AdminGUI;
import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main extends JFrame {

    public static void main(String[] args) {
	// write your code here
        /*
        List<Train> TrainList=new ArrayList<Train>();
        List<TrainStation>  TrainSt1=new ArrayList<TrainStation>();
        Train t1=new Train("ABBBBBCK",100,State.NEW);
        Train t2=new Train("AATOFO",50,State.PASSED);
        Train t3=new Train("CKSAOW",125,State.NEW);
        Train t4=new Train("ZODSAPDSA",200,State.LATE);
        Train t5=new Train("QQQQQLDASD",175,State.NEW);
        Train t6=new Train("BLSAPLPSA",10,State.LATE);
        Train t7=new Train("AATOFO",300,State.NEW);

        TrainStation ts=new TrainStation("MDA KRAKOW",new ArrayList<Train>(),7,0);
        ts.addTrain(t1);
        ts.addTrain(t2);
        ts.addTrain(t3);
        ts.addTrain(t4);
        ts.addTrain(t5);
        ts.addTrain(t6);
        ts.addTrain(t7);
        System.out.println(ts.getCount());
        ts.showInfo();
        System.out.println();

        ts.removeTrain(t4);
        ts.showInfo();
        System.out.println(ts.getCount());
        System.out.println();

        System.out.println(ts.getCountByCondition(State.NEW));
        System.out.println();

        ts.removeAllTrains("AATOFO");
        ts.showInfo();
        System.out.println(ts.getCount());
        System.out.println();

        ts.sortByName();
        ts.showInfo();
        System.out.println();

        ts.sortBySeats();
        ts.showInfo();
        System.out.println();


        List<Train> matchTrain= ts.getTrains("CK");
        for(Train index: matchTrain)
            System.out.println(index.getName());
        System.out.println();

        System.out.println(ts.getCountofCondition(State.LATE));
        System.out.println();

        System.out.println(ts.getMinSeats().getSeats_amount());
        System.out.println();

    TrainStationContainer C1=new TrainStationContainer(new HashMap<String,TrainStation>() );
    C1.addStation(ts);
    C1.addStation(new TrainStation("MDA NOWY SACZ",new ArrayList<Train>(),20,0));
    C1.addStation(new TrainStation());
    C1.printStations();
        System.out.println();
    List<TrainStation> emptyStations=C1.getStations();
    for(TrainStation index:emptyStations)
        System.out.println(index.getStation_name());

        System.out.println();
        C1.removeStation("MDA NOWY SACZ");
        C1.printStations();
        System.out.println();
*/

        new AdminGUI().setVisible(true);

    }




}
