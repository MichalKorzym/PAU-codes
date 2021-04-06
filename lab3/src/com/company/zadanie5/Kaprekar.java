package com.company.zadanie5;

import java.util.*;

public class Kaprekar {

    public int kaprekar(int a) {
        int num ;
        int numAsc=0;
        int numDsc=0;
        int kaprekarNum = a;
        int count = 0;
        int outNum = 0;

        while (kaprekarNum != 6174) {
            num=kaprekarNum;
           int numLength= (String.valueOf(num)).length();
            ArrayList<Integer> toSort = new ArrayList<>();
           while(numLength<4) {
               toSort.add(0);
               numLength++;
           }
            while (num > 0) {

                toSort.add(num % 10);
                num /= 10;
            }
            Collections.sort(toSort);
            int n = toSort.size();
            outNum=0;
            for (int j = 0; j < n; j++) {
                outNum = outNum * 10 + toSort.get(j);
                if (j == n - 1)
                    numAsc = outNum;
            }
            Collections.sort(toSort, Collections.reverseOrder());
            outNum = 0;
            for (int j = 0; j < n; j++) {
                outNum = outNum * 10 + toSort.get(j);
                if (j == n - 1)
                    numDsc = outNum;
            }
            System.out.println(numAsc+"-"+numDsc+" dla:"+kaprekarNum);
            kaprekarNum = numDsc - numAsc;
            count++;
        }
        return count;
    }

}


