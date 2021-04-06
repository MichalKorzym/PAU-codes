package com.company.zadanie1;

import java.util.Random;
import java.util.Scanner;

public  class EnterData {

void printArr(int arr[])
{
    for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
}

int[] fillOptimisticData(int[] arr)
{
    for(int i=0;i<arr.length;i++)
        arr[i]=i;
    return arr;
}

    int[] fillPesimisticData(int[] arr)
    {
        for(int i= arr.length-1;i>=0;i--)
            arr[i]=i;
        return arr;
    }
    int[] fillRandomData(int[] arr)
    {
        Random r=new Random();
        for(int i=0;i<arr.length;i++)
            arr[i]=r.nextInt();
        return arr;
    }
    long returnCurrentTime()
    {
        return System.currentTimeMillis();
    }
    void calculateTime(long tStart,long tEnd)
    {
        long tDelta=tEnd-tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(elapsedSeconds);
    }


}
