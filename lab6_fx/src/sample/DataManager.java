package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {


    public void saveData(TrainStationContainer  tSc)
    {
        try (ObjectOutputStream output =new ObjectOutputStream(new FileOutputStream("StationContainer.txt"))){
            output.writeObject(tSc);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public TrainStationContainer writeData(TrainStationContainer tSc)
    {
        try (ObjectInputStream input =new ObjectInputStream(new FileInputStream("StationContainer.txt")))
        {
            TrainStationContainer  stationContainer= (TrainStationContainer) input.readObject();
            List<TrainStation> stationList= new ArrayList<>();
           stationList=stationContainer.getAllStations();
           for(TrainStation index:stationList)
               tSc.addStation(index);





        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return tSc;


    }

    public void saveTSlist(List<Train> trains)
    {
        try (ObjectOutputStream output =new ObjectOutputStream(new FileOutputStream("StationContainerFX.txt"))){
            for(Train index: trains)
                output.writeObject(index);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        }

    public ObservableList<Train> writeDataFX(ObservableList<Train> trains)
    {

        try {
            FileInputStream stream= new FileInputStream("StationContainerFX.txt");
            ObjectInputStream input =new ObjectInputStream(stream);

            while (stream.available() != -1) {
                Train t = (Train) input.readObject();
                trains.add(t);


            }
        }catch (EOFException ex)
        {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return trains;
    }




    }







