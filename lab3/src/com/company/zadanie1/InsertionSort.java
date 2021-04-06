package com.company.zadanie1;

import java.util.Scanner;

public class InsertionSort extends EnterData implements Strategy{
    @Override
    public void sort() {

        fillRandomData(arr);
        long tStart = returnCurrentTime();
        insertionSort(arr);
        long tEnd = returnCurrentTime();
        System.out.println("Randomowe");
        calculateTime(tStart,tEnd);


        fillPesimisticData(arr);
        tStart=returnCurrentTime();
        insertionSort(arr);
        tEnd=returnCurrentTime();
        System.out.println("Pesymistycznie");
        calculateTime(tStart,tEnd);

        fillOptimisticData(arr);
        tStart=returnCurrentTime();
        insertionSort(arr);
        tEnd=returnCurrentTime();
        System.out.println("Optymistycznie");
        calculateTime(tStart,tEnd);

    }
    void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
