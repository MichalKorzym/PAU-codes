package com.company.zadanie2;

public class MyException2 extends Exception{

    public MyException2() {
        System.out.println("BRAK ROZWIAZANIA");
    }
    public MyException2(String komunikat){
        super(komunikat);
    }

}
