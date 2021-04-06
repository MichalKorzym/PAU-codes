package com.company.zadanie1;

import java.util.Scanner;

public class Zadanie1  {
        public Zadanie1() {

            Context c1 = new Context();
            int choice;
            System.out.println("1:QuickSort");
            System.out.println("2:BubbleSort");
            System.out.println("3:InsertionSort");
            System.out.println("4:SelectionSort");
            System.out.println("5:MergeSort");
            Scanner scan = new Scanner(System.in);
            choice=scan.nextInt();

            switch(choice) {
                case 1:
                    c1.setSortStrategy(new QuickSort());
                    c1.executeStrategy();
                    break;
                case 2:
                    c1.setSortStrategy(new BubbleSort());
                    c1.executeStrategy();
                    break;
                case 3:
                    c1.setSortStrategy(new InsertionSort());
                    c1.executeStrategy();
                    break;
                case 4:
                    c1.setSortStrategy(new SelectionSort());
                    c1.executeStrategy();
                    break;
                case 5:
                    c1.setSortStrategy(new MergeSort());
                    c1.executeStrategy();
                    break;
                default:
                    System.out.println("zly numer");
            }
        }
}
