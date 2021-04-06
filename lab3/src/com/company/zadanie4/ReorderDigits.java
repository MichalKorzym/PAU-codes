package com.company.zadanie4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReorderDigits {
    public void reorderDigits(int array[],String order)
    {

        for(int i = 0;i< array.length;i++){
            ArrayList<Integer> toSort = new ArrayList<>();
            while(array[i] >0){
                toSort.add(array[i]%10);
                array[i]/=10;
            }
            if(order.equals(("asc"))) Collections.sort(toSort);
            else if(order.equals("desc"))
                Collections.sort(toSort, Collections.reverseOrder());

            int outNum = 0;
            int n = toSort.size();

            for(int j = 0;j<n;j++){
                outNum = outNum*10 + toSort.get(j);
            }
            array[i] = outNum;
        }
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
}
