package com.company.zadanie3;

import java.util.ArrayList;
import java.util.List;

public class MissingNum {
    public List<Integer> missingNum(int[] a, int max)
    {
        int index;
        int i;
        int k=0;
        boolean tmp;
        List<Integer> missing=new ArrayList<Integer>();

            for (int j = 1; j <= max; j++) {
                tmp=false;
                for( i=0;i<a.length;i++) {
                    if (a[i] == j)
                        tmp = true;

                }
                    if(!tmp) {
                        missing.add(j);

                    }


        }
            return missing;
    }

}
