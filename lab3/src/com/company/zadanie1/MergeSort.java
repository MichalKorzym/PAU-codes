package com.company.zadanie1;
import java.util.Scanner;

public class MergeSort extends EnterData implements Strategy{


    @Override
    public void sort() {
        int l=0;
        int r=arr.length-1;
        fillRandomData(arr);
        long tStart = returnCurrentTime();
        sortMerged(arr,l,r);
        long tEnd = returnCurrentTime();
        System.out.println("Randomowe");
        calculateTime(tStart,tEnd);


        fillPesimisticData(arr);
        tStart=returnCurrentTime();
        sortMerged(arr,l,r);
        tEnd=returnCurrentTime();
        System.out.println("Pesymistycznie");
        calculateTime(tStart,tEnd);

        fillOptimisticData(arr);
        tStart=returnCurrentTime();
        sortMerged(arr,l,r);
        tEnd=returnCurrentTime();
        System.out.println("Optymistycznie");
        calculateTime(tStart,tEnd);

    }
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sortMerged(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sortMerged(arr, l, m);
            sortMerged(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}
