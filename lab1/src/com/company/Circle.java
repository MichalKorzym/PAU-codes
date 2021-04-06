package com.company;

public class Circle extends Figure implements Printable {

   private double r;

  public  Circle(double r) {
        if (!checkEdges(r))
            throw new IllegalArgumentException("Krawedz nie moze byc ujemna!");
        this.r = r;
    }

    @Override
    double getEdge() {
        return r;
    }

    @Override
    double calculateArea() {
        return (PI * (r * r));
    }

    @Override
    double calculatePerimeter() {
        return 2 * PI * r;
    }

    public void print() {
        System.out.println("Promien kola r: " + r);
        System.out.println("Pole kola: " + calculateArea() + " Obj. kola: " + calculatePerimeter());
    }
}
