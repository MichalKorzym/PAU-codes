package com.company;

public class Triangle extends Figure implements Printable {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!(a + b > c && a + b > c && a + c > b) || !(checkEdges(a, b, c)))
            throw new IllegalArgumentException("Nie da sie stworzyc takiego trojkata!");
        this.a = a;
        this.b = b;
        this.c = c;

    }

    //kontruktor trojkata rownobocznego
   public Triangle(double a) {
       if (!checkEdges(a))
           throw new IllegalArgumentException("Krawedz nie moze byc ujemna!");
        this.a = a;
        this.b = a;
        this.c = a;

    }

    boolean checkEdges(double a, double b, double c) {
        if (!(a > 0 && b > 0 && c > 0))
            return false;
        else
            return true;
    }

   private double gethalfPerimeter() {
        return calculatePerimeter() / 2;
    }

    @Override
    double getEdge() {
        return a;
    }

    @Override
    double calculateArea() {
        return Math.sqrt(gethalfPerimeter() * (gethalfPerimeter() - a) * (gethalfPerimeter() - b) * (gethalfPerimeter() - c));
    }

    @Override
    double calculatePerimeter() {
        return a + b + c;
    }

    public void print() {
        System.out.println("Boki trojkata a: " + a + " bok b: " + b + " bok c: " + c);
        System.out.println("Pole trojkata: " + calculateArea() + " Obj. trojkata: " + calculatePerimeter());
    }
}
