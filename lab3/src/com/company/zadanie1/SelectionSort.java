package com.company.zadanie1;

import java.util.Scanner;

public class SelectionSort extends EnterData implements Strategy{
    @Override
    public void sort() {

        fillRandomData(arr);
        long tStart = returnCurrentTime();
        selectionSort(arr);
        long tEnd = returnCurrentTime();
        System.out.println("Randomowe");
        calculateTime(tStart,tEnd);


        fillPesimisticData(arr);
        tStart=returnCurrentTime();
        selectionSort(arr);
        tEnd=returnCurrentTime();
        System.out.println("Pesymistycznie");
        calculateTime(tStart,tEnd);

        fillOptimisticData(arr);
        tStart=returnCurrentTime();
        selectionSort(arr);
        tEnd=returnCurrentTime();
        System.out.println("Optymistycznie");
        calculateTime(tStart,tEnd);

    }
    void selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }



}
