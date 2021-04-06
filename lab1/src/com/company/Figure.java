package com.company;

import java.util.Scanner;

interface Printable
{
    void print();
}
abstract  class Figure implements  Printable
{
    final double PI=3.14;
    Scanner in= new Scanner(System.in);
    abstract double calculateArea();
    abstract double calculatePerimeter();
    boolean checkEdges(double a)
    {
        if(!(a>0))
        return false;
        else
            return true;
    }
abstract double getEdge();
}

