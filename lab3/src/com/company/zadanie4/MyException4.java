package com.company.zadanie4;

public class MyException4 extends  Exception{
    public MyException4()
    {
        System.out.println("WPISALES INNY ORDER NIZ ASC LUB DESC");
    }
    public MyException4(String message){
        super(message);
    }
}
