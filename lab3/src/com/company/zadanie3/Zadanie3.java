package com.company.zadanie3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie3 {
    public Zadanie3()
    {
        MissingNum z3=new MissingNum();
        List<Integer> missing = new ArrayList<Integer>();
        System.out.println("Podaj max z przedzialu (1,max)");
        int max;
        Scanner scan = new Scanner(System.in);
        max=scan.nextInt();
        if(max<0) try {
            throw new MyException3();
        } catch (MyException3 myException3) {
            myException3.printStackTrace();
        }
        int array[]=new int[10];
        for(int i =0;i<array.length;i++)
            array[i]=scan.nextInt();
        missing=z3.missingNum(array,max);

        for(int index:missing)
            System.out.print(index+" ");
        System.out.println();
    }
}
