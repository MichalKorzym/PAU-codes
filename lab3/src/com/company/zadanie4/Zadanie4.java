package com.company.zadanie4;

import java.util.Random;
import java.util.Scanner;

public class Zadanie4 {
    public Zadanie4()
    {
        ReorderDigits rd=new ReorderDigits();
        Random r= new Random();
        int array[]=new int[10];
        for(int i=0;i<array.length;i++)
            array[i]=r.nextInt(1001);
        System.out.println("asc porzadkowanie rosnaco , desc porzadkowanie malejaco");
        Scanner scan = new Scanner(System.in);
        String order;
        order=scan.nextLine();
        if(!order.equals("asc")&&!order.equals("desc"))
            try {
                throw new MyException4();
            } catch (MyException4 myException4) {
                myException4.printStackTrace();

            }
        rd.reorderDigits(array,order);

    }
}
