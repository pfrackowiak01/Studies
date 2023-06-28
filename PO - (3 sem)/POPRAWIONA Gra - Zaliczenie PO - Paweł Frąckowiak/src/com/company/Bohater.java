package com.company;

import javax.swing.*;

public class Bohater extends Postac{

    public Bohater(String n, int hp, int a, int d, int s, int cr, int cd, ImageIcon o, int h, int sp) {
        super(n, hp, a, d, s, cr, cd, o, h, sp);
        int aktualneHP = hp;
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
                return "<html>Zawsze trafiasz krytycznie za" + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń.";
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

    @Override
    public String toString() {
        return "<html>========" + this.name + "========" +
                "<BR>Życie----------------" + this.zycie +
                "<BR>Atak-----------------" + this.atak +
                "<BR>Pancerz------------" + this.obrona +
                "<BR>Szybkość----------" + this.szybkosc +
                "<BR>Szansa na Kryt.--" + this.krytSzansa +
                "<BR>Obrażenia Kryt.--" + this.krytAtak +
                "<BR>===========Atak===========" +
                "<BR>" + opiszAtak(this) +
                "<BR>===========Spell===========" +
                "<BR>" + opiszCzar(this) +
                "<html>";

    }
}


