package com.company;

import java.util.*;

public class TrainStationContainer
{

    private HashMap<String,TrainStation> Stations=new HashMap<String,TrainStation>();
    public TrainStationContainer(HashMap<String, TrainStation> stations) {
        Stations = stations;
    }
    public TrainStationContainer() {

    }


   public void addStation(TrainStation ts)
    {
        Stations.put(ts.getStation_name(),ts);
        System.out.println("Station added");
    }
    void removeStation(String name)
    {
        Stations.remove(name);
        System.out.println("Station removed");
    }


   public List<TrainStation> getStations()
    {
        List< TrainStation> emptyStations=new ArrayList<TrainStation>();
       for(TrainStation station: this.Stations.values())
       {
           if(station.getCount()==0)
               emptyStations.add(station);

       }
       return emptyStations;

    }

   public void printStations() {
        for(Map.Entry<String,TrainStation> entry: Stations.entrySet()) {
            System.out.println("Station name:" + entry.getKey());
            System.out.println("Obciazenie stacji:" + entry.getValue().getCount());
        }

    }
    public TrainStation getSelectedStation(String name)
    {
        TrainStation ts =new TrainStation();
        for(TrainStation station: this.Stations.values())
            if(station.getStation_name().equals(name))
                   ts= station;

            return ts;
    }




}
