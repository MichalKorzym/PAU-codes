package com.company;

public class Square extends Figure implements Printable {
   private double a;

   public Square(double a) {
        if (!checkEdges(a))
            throw new IllegalArgumentException("Krawedz nie moze byc ujemna!");
        this.a = a;
    }


    @Override
    double calculateArea() {

        return a * a;
    }

    @Override
    double getEdge() {
        return a;
    }


    @Override
    double calculatePerimeter() {
        return 4 * a;
    }

    public void print() {
        System.out.println("Bok kwadratu: " + a);
        System.out.println("Pole kwadratu: " + calculateArea() + " Obj.kwadratu: " + calculatePerimeter());
    }
}
