package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {


    private static final String COMMA_DELIMITER=",";
    private static final int CONDITION_INDEX=0;
    //Student attributes index
    private static final int TRAIN_NAME_IDX = 0;
    private static final int TRAIN_SEATS_AMOUNT_IDX = 1;
    private static final int TRAIN_CONDITION_IDX=2;



    public static void readCsvFile(){
        String fileName="Condition.csv";
        BufferedReader fileReader=null;

        try{
          List states =new ArrayList();
          String line= "";
          fileReader= new BufferedReader(new FileReader(fileName));
          fileReader.readLine();
          while((line=fileReader.readLine())!=null){
                String tokens[]=line.split(COMMA_DELIMITER);
                if(tokens.length>0)
                {
                    String readStates=new String(tokens[CONDITION_INDEX]);
                    convert(readStates);
                    states.add(readStates);
                }
            }
          for(Object index:states)
          {
              System.out.println(index.toString());
          }
        }
        catch(Exception e){
            System.out.println("Error filereader");
            e.printStackTrace();
        }finally {
            try{
                fileReader.close();
            }catch (IOException e)
            {
                System.out.println("Error closing ");
                e.printStackTrace();
            }
        }
    }
    public static void readStationContainerCSV() {


        String fileName="Trains.csv";

            BufferedReader fileReader = null;

            try {


                List<Train> trains = new ArrayList();

                String line = "";

                fileReader = new BufferedReader(new FileReader(fileName));
                fileReader.readLine();


                while ((line = fileReader.readLine()) != null) {

                    String[] tokens = line.split(COMMA_DELIMITER);
                    if (tokens.length > 0) {
                        //Create a new student object and fill his  data

                        Train train  = new Train(tokens[TRAIN_NAME_IDX],Integer.parseInt(tokens[TRAIN_SEATS_AMOUNT_IDX]),convert(tokens[TRAIN_CONDITION_IDX]) );
                        trains.add(train);
                    }
                }
                    for(Train train:trains)
                    {
                        System.out.println(train.toString());
                    }

            }
            catch (Exception e) {
                System.out.println("Error in CsvFileReader !!!");
                e.printStackTrace();
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error while closing fileReader !!!");
                    e.printStackTrace();
                }
            }

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

}
