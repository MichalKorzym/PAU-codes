package sample;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;






public class Train implements Comparable <Train> , Serializable
{
    public String name;
   private  int seats_amount;

   //****brak serializacji****//
    private transient State condition;
    private String startStation;
    private String endStation;
    private Time departureTime;
    private Time arrivalTime;
    private int ticketPrize;


    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Train(String name, int seats_amount, State condition)
{
    this.name=name;
    this.seats_amount=seats_amount;
    this.condition=condition;
}

    public Train(String name, int seats_amount,State condition,String startStation,String endStation,Time departureTime,Time arrivalTime)
    {
        this.name=name;
        this.seats_amount=seats_amount;
        this.condition=condition;
        this.startStation=startStation;
        this.endStation= endStation;
        this.departureTime=departureTime;
        this.arrivalTime= arrivalTime;
    }


    public Train()
    {

    }

    public Train(String name, int seats_amount,Time t1,Time t2,String start,String end,int ticketPrize,State condition)
    {
        this.name=name;
        this.seats_amount=seats_amount;
        this.arrivalTime=t1;
        this.departureTime=t2;
        this.startStation=start;
        this.endStation= end;
        this.ticketPrize=ticketPrize;
        this.condition=condition;

    }


    @Override
    public int compareTo(Train t) {
      int compareName=name.compareTo(t.name);
      //jesli te same nazwy porownanie stanu
      if(compareName==0)
          return condition.compareTo(t.condition);
      else
         return compareName;

    }
    @Override public String toString()
    {
        return "Nazwa pociagu: "+name+" ilosc miejsc: "+seats_amount+" stan: "+condition;
    }

    public String getName() {
        return name;
    }

    public int getSeats_amount() {
        return seats_amount;
    }

    public State getCondition() {
        return condition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeats_amount(int seats_amount) {
        this.seats_amount = seats_amount;
    }

    public void setCondition(State condition) {
        this.condition = condition;
    }




    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }
    public int getDepartureHour(){ return departureTime.getHour();}
    public String getDepartureTime() {

       return departureTime.toString();
    }



    public String getArrivalTime() {

        return arrivalTime.toString();
    }

    public int getTicketPrize() {
        return ticketPrize;
    }

    public void setTicketPrize(int ticketPrize) {
        this.ticketPrize = ticketPrize;
    }


    //serializacja

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
        stream.defaultReadObject();
        condition= (State) stream.readObject();


    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(State.NEW);
    }




}

