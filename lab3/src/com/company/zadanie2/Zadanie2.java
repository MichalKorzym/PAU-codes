package com.company.zadanie2;

import java.util.Random;
import java.util.Scanner;

public class Zadanie2 {
    public Zadanie2()
    {
        Random r = new Random();
        int array[]=new int[10];
        System.out.println("Podaj liczbe ktorej dla ktorej zostana znalezione indeksy ");
        int target;
        Scanner scan = new Scanner(System.in);
        target=scan.nextInt();
        int value;
        for(int i=0;i< array.length;i++)
            array[i]=scan.nextInt();  //r.nextInt(1001-1000);
        Spot tmp = new Spot();
        tmp.spot(array,target);


    }
}
