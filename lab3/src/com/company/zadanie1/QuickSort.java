package com.company.zadanie1;

import java.util.Scanner;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class QuickSort extends EnterData implements Strategy  {



    @Override
    public void sort() {
        int low=0;
        int high=arr.length-1;
        fillRandomData(arr);
        long tStart = returnCurrentTime();
        quickSort(arr,low,high);
        long tEnd = returnCurrentTime();
        System.out.println("Randomowe");
        calculateTime(tStart,tEnd);

        fillPesimisticData(arr);
        tStart=returnCurrentTime();
        quickSort(arr,low,high);
        tEnd=returnCurrentTime();
        System.out.println("Pesymistycznie");
        calculateTime(tStart,tEnd);

        fillOptimisticData(arr);
        tStart=returnCurrentTime();
        quickSort(arr,low,high);
        tEnd=returnCurrentTime();
        System.out.println("Optymistycznie");
        calculateTime(tStart,tEnd);

       // printArr(arr);

    }
    void quickSort(int arr[],int low,int high){
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

        public int partition(int[] arr, int low, int high)
        {
            
                int pivot = arr[high];
                int i = (low - 1);

                for(int j = low; j <=high - 1; j++)
                {
                    if (arr[j] < pivot)
                    {
                        i++;
                        swap(arr, i, j);
                    }
                }
                swap(arr, i + 1, high);
                return (i + 1);
            
        }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
