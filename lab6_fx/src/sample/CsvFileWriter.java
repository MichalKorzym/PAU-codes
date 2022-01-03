package sample;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWriter {

    private static final String COMMA_DELIMITER=",";
    private static final String LINE_SEPARATOR="\n";

    //file reader
    private static final String headers="Train_Condition";
    private static final String HEADERS_TRAIN="Name,Seats,Condition";
    public static void writeCsvFile()
    {
        String fileName="Condition.csv";
        State s1=State.NEW;
        State s2=State.BROKEN;
        State s3=State.LATE;
        State s4=State.PASSED;

        List states=new ArrayList();
        states.add(s1);
        states.add(s2);
        states.add(s3);
        states.add(s4);

        FileWriter fileWriter=null;

        try
        {
            fileWriter= new FileWriter(fileName);
            fileWriter.append(headers.toString());
            fileWriter.append(LINE_SEPARATOR);


            for(Object index:states) {
                fileWriter.append(String.valueOf(index.toString()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(LINE_SEPARATOR);

            }
            System.out.println("ADDED TO CSV FILE");
        }catch(Exception e)
        {
            System.out.println("Error csv writter");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Error while flushing");
                e.printStackTrace();
            }
        }

    }
    public static void writeStationContainerCSV()
    {
            String fileName="Trains.csv";


        Train t1=new Train("TVW",100,State.LATE);
        Train t2=new Train("REGIO",420,State.BROKEN);
        Train t3= new Train("INTERCITY",321,State.LATE);

        List<Train> trains=new ArrayList();
        trains.add(t1);
        trains.add(t2);
        trains.add(t3);


        FileWriter fileWriter=null;


        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(HEADERS_TRAIN.toString());

            //Add a new line separator after the header
            fileWriter.append(LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Train train : trains) {
                fileWriter.append(train.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(train.getSeats_amount()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(train.getCondition()));
                fileWriter.append(LINE_SEPARATOR);
            }



            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }


    }





