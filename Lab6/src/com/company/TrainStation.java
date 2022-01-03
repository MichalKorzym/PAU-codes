package com.company;

import java.util.*;
class sortBySeatsComp implements Comparator<Train> {
    //sortowanie po ilosci miejsc malejaco
    @Override
    public int compare(Train t1, Train t2) {

        return t2.getSeats_amount()-t1.getSeats_amount();
    }
}

public class TrainStation  {

    private String station_name;
    public List<Train> trainList=new ArrayList<Train>();
    private int size;
    private int count;

    public TrainStation(String station_name,List<Train> trainList,int size,int count)
    {
        this.trainList=trainList;
        this.station_name=station_name;
        this.size =size;
        this.count=count;
    }

    public TrainStation()
    {
      this.count=0;
    }
    public void addTrain(Train t)
    {


            if(count<=size) {
                trainList.add(t);
                count++;
            System.out.println("Added train");
        }
        else
            System.err.println("Fail adding train");
    }
    public void removeTrain(Train t)
    {
        trainList.remove(t);
        count --;
        System.out.println("Removed train");
    }
    public void removeAllTrains(String deleted_name) {
                for(Train index: this.trainList)
                    if (index.getName().equals(deleted_name)) {
                        count--;
                        System.out.println("decrementation");
                    }
        trainList.removeIf(Train->Train.getName().equals(deleted_name));

    }
    public void removeTrainByName(String name)
    {
        trainList.removeIf(Train->Train.getName().equals(name));
        count --;
    }



    public int getCountByCondition(State condition){
        int tmp=0;
        for(Train index: this.trainList)
        {
            if(index.getCondition().equals(condition))
                tmp++;
        }
        return tmp;
    }
    public void showInfo()
    {
        for(Train index:this.trainList)
        {
            System.out.println("Nazwa pociagu: "+index.getName());
            System.out.println("Ilosc miejsc:  "+index.getSeats_amount());
            System.out.println("Stan: "+index.getCondition());

        }
    }
    public void  sortByName()
    {
        Collections.sort(trainList);
    }
   /* public Train search(Train t)
    {
                for(Train index:this.trainList)
                    if(index.compare())
    }
*/
    public void sortBySeats()
    {
        Collections.sort(trainList,new sortBySeatsComp());
    }

    public List<Train> getTrains(String name)
    {
        List<Train> matchingTrains=new ArrayList<>();
        for(Train index:this.trainList)
            if(index.getName().contains(name))
                matchingTrains.add(index);

            return matchingTrains;
    }
    public Train getMinSeats()
    {
       return Collections.max(trainList,new sortBySeatsComp());

    }
    public int getCountofCondition(State condition)
    {
        int tmp=0;
        for(Train index: this.trainList)
            if(index.getCondition().equals(condition))
                tmp++;
            return tmp;
    }
    public void changeTrainData(String oldName,String name,int seatsAmount,State state )
    {
        for(Train index: this.trainList)
            if(index.getName().equals(oldName))
            {
                index.setName(name);
                index.setSeats_amount(seatsAmount);
                index.setCondition(state);
            }
    }

    public String getStation_name() {
        return station_name;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }
}
