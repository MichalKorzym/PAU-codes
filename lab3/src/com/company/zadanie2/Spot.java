package com.company.zadanie2;

import java.util.*;

public class Spot {
    public void spot(int[] a, int target) {
        int s;

        for (int i = 0; i < a.length; i++) {
            s = target - a[i];
            for (int j = i + 1;j<a.length-1; j++)
                if(s==a[j])
                {
                    System.out.println("Indeksy to :"+i+" "+j);
                    return;
                }
        }
        try {
            throw new MyException2();
        } catch (MyException2 myException2) {
            myException2.printStackTrace();
        }

    }
}
