package com.company.zadanie3;

public class MyException3 extends Exception{
    public MyException3()
    {
        System.out.println("MAX NIE MOZE BYC LICZBA UJEMNA !!!");
    }
    public MyException3(String message){
        super(message);
    }
}
