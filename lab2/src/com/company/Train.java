package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Train implements Comparable <Train>
{
    private String name;
   private  int seats_amount;
    private State condition;


public Train(String name, int seats_amount,State condition)
{
    this.name=name;
    this.seats_amount=seats_amount;
    this.condition=condition;
}
    public Train()
    {

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
}

