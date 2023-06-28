package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    static ImageIcon ikona = new ImageIcon("logo.png");
    static Color kolor = new Color(232,177,109);
    static Color ciemny = new Color(0,0,0, 40);
    static Color jasny = new Color(255,255,255, 40);
    static Color zielony = new Color(0,255,0,50);
    static Color zolty = new Color(255,255,0,50);
    static Color czerwony = new Color(255,0,0,50);
    static Color czarny = new Color(30,30,30);
    static Color szary = new Color(138, 138, 138, 120);
    static String imie = "Twoje imię";
    static int poziomtrudnosci = 0;

    ImageIcon czarownicao = new ImageIcon("czarownica.png");
    ImageIcon wampiro = new ImageIcon("wampir.png");
    ImageIcon palladyno = new ImageIcon("palladyn.png");
    ImageIcon szamankao = new ImageIcon("szamanka.png");
    ImageIcon mago = new ImageIcon("mag.png");
    ImageIcon pirato = new ImageIcon("pirat.png");
    ImageIcon uzdrowicielkao = new ImageIcon("uzdrowicielka.png");
    ImageIcon ninjao = new ImageIcon("ninja.png");
    ImageIcon rycerzo = new ImageIcon("rycerz.png");
    ImageIcon druido = new ImageIcon("druid.png");
    ImageIcon assasino = new ImageIcon("assasin.png");
    ImageIcon demono = new ImageIcon("demon.png");
    ImageIcon hydrao = new ImageIcon("hydra.png");

    Bohater czarownica = new Bohater("Czarownica",10000,300,120,120,0,50,czarownicao,1,8);
    Bohater wampir = new Bohater("Wampir",6000,600,100,80,50,70,wampiro,2,2);
    Bohater palladyn = new Bohater("Palladyn",10000,500,200,100,60,60,palladyno,3,3);
    Bohater rycerz = new Bohater("Rycerz",8000,400,200,80,70,60,rycerzo,4,4);
    Bohater mag = new Bohater("Mag",6000,400,100,100,0,80,mago,1,9);
    Bohater assasin = new Bohater("Assasin",6000,600,80,100,100,60,assasino,5,10);
    Bohater demon = new Bohater("Demon",8000,200,90,140,50,100,demono,6,6);
    Bohater druid = new Bohater("Druid",10000,300,160,110,30,20,druido,6,1);
    Bohater ninja = new Bohater("Ninja",5000,700,50,70,100,70,ninjao,5,7);
    Bohater pirat = new Bohater("Pirat",8000,500,100,100,0,50,pirato,1,5);
    Bohater szamanka = new Bohater("Szamanka",12000,200,120,100,25,50,szamankao,7,4);
    Bohater uzdrowicielka = new Bohater("Uzdrowicielka",14000,200,200,130,40,20,uzdrowicielkao,8,1);

    //Potwor hydralatwa = new Potwor();
    Potwor hydralatwa = new Potwor("Hydra",20000,1000,200,200,30,60,hydrao,0,0);
    Potwor hydrasrednia = new Potwor("Hydra",20000,2000,250,180,30,60,hydrao,1,1);
    Potwor hydratrudna = new Potwor("Hydra",20000,4000,300,160,30,60,hydrao,2,2);

    //Aliasy
    static Bohater b1;
    static Bohater b2;
    static Bohater b3;
    static Potwor p;

    //Kopie wybranych bohaterów
    static Bohater bohater1;
    static Bohater bohater2;
    static Bohater bohater3;
    static Potwor potwor;
    //Potwor potwor = new Potwor("Hydra",20000,1000,200,200,30,60,hydrao,0,0);
    //Bohater potwor = new Potwor("Hydra",20000,1000,200,200,30,60,hydrao,0,0);

    public void losujPotwora(){
        if (poziomtrudnosci == 0) p = hydralatwa;
        if (poziomtrudnosci == 1) p = hydrasrednia;
        if (poziomtrudnosci == 2) p = hydratrudna;
    }

    public void przygotowanie(Bohater b1, Bohater b2, Bohater b3, Potwor p){
        bohater1 = new Bohater(b1.name,b1.zycie,b1.atak,b1.obrona,b1.szybkosc,b1.krytSzansa,b1.krytAtak,b1.obrazek,b1.hit,b1.spell);
        bohater2 = new Bohater(b2.name,b2.zycie,b2.atak,b2.obrona,b2.szybkosc,b2.krytSzansa,b2.krytAtak,b2.obrazek,b2.hit,b2.spell);
        bohater3 = new Bohater(b3.name,b3.zycie,b3.atak,b3.obrona,b3.szybkosc,b3.krytSzansa,b3.krytAtak,b3.obrazek,b3.hit,b3.spell);
        potwor = new Potwor(p.name,p.zycie,p.atak,p.obrona,p.szybkosc,p.krytSzansa,p.krytAtak,p.obrazek,p.hit,p.spell);
        //potwor = new Potwor(hydralatwa.name,hydralatwa.zycie,hydralatwa.atak,hydralatwa.obrona,hydralatwa.szybkosc,hydralatwa.krytSzansa,hydralatwa.krytAtak,hydralatwa.obrazek,hydralatwa.hit,hydralatwa.spell);
    }

    public String opiszAtak(Bohater b) {
        switch (b.hit) {
            case 0:
                return "<html>Zadajesz " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń.";
            case 1:
                return "<html>Atakujesz za " + b.atak + " obrażeń ignorując pancerz przeciwnika. Nie możesz trafiać krytycznie.";
            case 2:
                return "<html>Atakujesz za " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. <br>Leczysz się o równowartość zadanych obrażeń";
            case 3:
                return "<html>Zadajesz " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zwiększasz sobie maksymalne zdrowie o 500.";
            case 4:
                return "<html>Zadajesz " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zwiększasz sobie pancerz o 20.";
            case 5:
                return "<html>Zawsze trafiasz krytycznie za " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń.";
            case 6:
                return "<html>Atakujesz za " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zwiększasz wszystkim atak o 20%.";
            case 7:
                return "<html>Atakujesz za " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zmniejsz pancerz przeciwnika o 20%.";
            case 8:
                return "<html>Zadajesz " + b.atak + " obrażeń. <br>Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Leczysz wszystkich o 20% ich maksymalnego zdrowia.";
            default:
                return "coś";
        }
    }

    public String opiszCzar(Bohater b) {
        switch (b.spell) {
            case 0:
                return "<html>Leczysz się o " + b.krytAtak + "% twojego maksymalnego zdrowia.";
            case 1:
                return "<html>Wskrzeszasz martwego sojusznika z 50% maksymalnego zdrowia albo leczysz wszystkich o " + b.krytAtak + "% maksymalnego zdrowia.";
            case 2:
                return "<html>Atakujesz i leczysz wszystkich o 30% zadanych przez ciebie obrażeń.";
            case 3:
                return "<html>Zwiększ wszystkim maksymalne zdrowie o 2000.";
            case 4:
                return "<html>Zwiększ wszystkim pancerz o " + b.krytAtak + "%.";
            case 5:
                return "<html>Zwiększ wszystkim atak o " + b.krytAtak + "%.";
            case 6:
                return "<html>Podwój swój atak i uderz przeciwnika.";
            case 7:
                return "<html>Następny cios przeciwnika nie zadaje tobie żadnych obrażeń.";
            case 8:
                return "<html>Zmniejsza pancerz przeciwnika o połowe.";
            case 9:
                return "<html>Zwiększ wszystkim pancerz i atak o 20%.";
            case 10:
                return "<html>Zwiększ wszystkim obrażenia krytyczne o 50%.";
            default:
                return "coś";
        }
    }

    public static void main(String[] args) {

        new Okno();

    }
}
