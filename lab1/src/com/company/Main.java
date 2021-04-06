package com.company;


import java.util.Scanner;
import java.lang.*;


public class Main {

    public static void main(String[] args) {

        while (true) {

            System.out.println("Wybierz czego pole i obwod chcialbys policzyc");
            System.out.println("1:Trojkat");
            System.out.println("2:Kwadrat");
            System.out.println("3:Okrąg");
            System.out.println("4:Graniastoslup prawidlowy o podstawie trojkata(trojkatny), kwadratu(czworokatny) lub walec");
            System.out.println("5:Wyjscie");
            Scanner in=new Scanner(System.in);
            int number = in.nextInt();
            double height;
            switch (number) {
                case 1:
                    //trojkat
                    System.out.println("Podaj boki a,b,c");
                    double a, b, c;
                    a = in.nextDouble();
                    b = in.nextDouble();
                    c = in.nextDouble();
                    Triangle t = new Triangle(a, b, c);
                    t.print();
                    break;
                case 2:
                    //kwadrat
                    System.out.println("Podaj bok kwadratu");
                    double a_s;
                    a_s = in.nextDouble();
                    Square s = new Square(a_s);
                    s.print();
                    break;
                case 3:
                    // kolo
                    System.out.println("Podaj promien okregu");
                    double r;
                    r = in.nextDouble();
                    Circle kolo = new Circle(r);
                    kolo.print();
                    break;
                case 4:
                    //ostroslup
                    System.out.println("Podstawa graniastoslupa ");
                    System.out.println("1:Trojkat,2:Kwadrat,3:Walec");
                    number = in.nextInt();
                    //rozne podstawy
                    switch (number) {
                        case 1:
                            //podstawa trojkat rownoboczny
                            System.out.println("Podaj bok a trojkata rownobocznego ");
                            a = in.nextDouble();
                            System.out.println("Podaj wysokosc graniastoslupa");
                            height = in.nextDouble();
                            Figure p_t = new Triangle(a);
                            Prism pr_t = new Prism(p_t, height);
                            pr_t.print();
                            break;
                        case 2:
                            //podstawa kwadrat
                            System.out.println("Podaj bok kwadratu w podstawie");
                            a_s = in.nextDouble();
                            //wysokosc
                            System.out.println("Podaj wysokosc graniastoslupa");
                            height = in.nextDouble();
                            Figure p_s = new Square(a_s);
                            Prism pr_s = new Prism(p_s, height);
                            pr_s.print();
                            break;
                        case 3:
                            //podstawa kolo
                            System.out.println("Podaj promien kola w podstawie");
                            r=in.nextDouble();
                            System.out.println("Podaj wysokosc graniastoslupa");
                            height = in.nextDouble();
                            Figure p_c= new Circle(r);
                            Prism pr_c= new Prism(p_c,height);
                            pr_c.print();
                            break;

                        default:
                            System.out.println("Wybrales zly numer!! ");
                            break;
                    }

                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wybrales zly numer!!");
                    break;

            }


        }
    }
}
