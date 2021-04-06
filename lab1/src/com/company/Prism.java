package com.company;

public class Prism extends Figure implements Printable {
   private Figure basis;
   private double h;


   public Prism(Figure basis, double h) {
        if (!checkEdges(h))
            throw new IllegalArgumentException("Krawedz nie moze byc ujemna!");
        this.basis = basis;
        this.h = h;

        // this.lateralArea=lateralArea;
    }

 private   double calculateLateralArea() {
        if (basis instanceof Square) {
            return getEdge() * h * 4;

        } else if (basis instanceof Triangle) {
            return getEdge() * h * 3;
        } else {

            return 2 * PI * getEdge() * h;
        }
    }

    @Override
    double calculateArea() {
        return 2 * basis.calculateArea() + calculateLateralArea();
    }

    @Override
    double getEdge() {
        return basis.getEdge();
    }

    @Override
    double calculatePerimeter() {
        return basis.calculateArea() * h;
    }

    @Override
    public void print() {
        System.out.println("Dane podstawy oraz jej obwod i objetosc");
        basis.print();
        System.out.println("Wysokosc graniastoslupa " + h);
        System.out.println("Pole calkowite: " + calculateArea() + " Pole boczne: " + calculateLateralArea() + " Obj: " + calculatePerimeter());
    }
}
