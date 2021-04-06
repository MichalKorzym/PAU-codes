package com.company.zadanie1;

import java.util.Scanner;

public class BubbleSort extends EnterData implements Strategy{
    @Override
    public void sort() {

        fillRandomData(arr);
        long tStart = returnCurrentTime();
        bubbleSort(arr);
        long tEnd = returnCurrentTime();
        System.out.println("Randomowe");
        calculateTime(tStart,tEnd);


        fillPesimisticData(arr);
        tStart=returnCurrentTime();
        bubbleSort(arr);
        tEnd=returnCurrentTime();
        System.out.println("Pesymistycznie");
        calculateTime(tStart,tEnd);

        fillOptimisticData(arr);
        tStart=returnCurrentTime();
        bubbleSort(arr);
        tEnd=returnCurrentTime();
        System.out.println("Optymistycznie");
        calculateTime(tStart,tEnd);

    }
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

}
