package com.company.zadanie5;

import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie5 {
    public Zadanie5() {
        Kaprekar k = new Kaprekar();
        System.out.println("Podaj liczbe dla ktorej chcesz obliczyc liczbe iteracji");
        Scanner scan = new Scanner(System.in);
        int kaprekarNum = scan.nextInt();
        int tmp = kaprekarNum;
        ArrayList<Integer> test = new ArrayList<>();
        while (tmp > 0) {

            test.add(tmp % 10);
            tmp /= 10;
        }
       if(!ifDiff(test,kaprekarNum%10)) {
           try {
               throw new MyException5();
           } catch (MyException5 myException5) {
               myException5.printStackTrace();
           }
       }else {
           System.out.println(k.kaprekar(kaprekarNum));
       }
    }

    public boolean ifDiff(ArrayList<Integer> toSort, int tmp) {
        for (int Integer : toSort) {
            if (Integer != tmp)
                return true;
        }

        return false;
    }
}