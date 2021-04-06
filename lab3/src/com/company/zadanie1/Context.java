package com.company.zadanie1;

public class Context {


    public  void setSortStrategy(Strategy sortStrategy) {
        Context.sortStrategy = sortStrategy;
    }

    private static Strategy sortStrategy;


public void executeStrategy()
{
    sortStrategy.sort();
}

}
