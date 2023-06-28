package com.example.summonersbattle2;

public class Bohater extends Postac {

    public Bohater(String n, int hp, int a, int d, int s, int cr, int cd, int i, int h, int sp) {
        super(n, hp, a, d, s, cr, cd, i, h, sp);
        int aktualneHP = hp;
    }

    public String opiszAtak(Bohater b) {
        switch (b.hit) {
            case 0:
                return "Zadajesz " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń.";
            case 1:
                return "Atakujesz za " + b.atak + " obrażeń ignorując pancerz przeciwnika. Nie możesz trafiać krytycznie.";
            case 2:
                return "Atakujesz za " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Leczysz się o równowartość zadanych obrażeń";
            case 3:
                return "Zadajesz " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zwiększasz sobie maksymalne zdrowie o 500.";
            case 4:
                return "Zadajesz " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zwiększasz sobie pancerz o 20.";
            case 5:
                return "Zawsze trafiasz krytycznie za" + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń.";
            case 6:
                return "Atakujesz za " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zwiększasz wszystkim atak o 20%.";
            case 7:
                return "Atakujesz za " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Zmniejsz pancerz przeciwnika o 20%.";
            case 8:
                return "Zadajesz " + b.atak + " obrażeń. Masz " + b.krytAtak + "% szans na trafienie krytyczne, które zada " + (b.atak + b.atak * b.krytAtak / 100) + " obrażeń. Leczysz wszystkich o 20% ich maksymalnego zdrowia.";
            default:
                return "coś";
        }
    }

    public String opiszCzar(Bohater b) {
        switch (b.spell) {
            case 0:
                return "Leczysz się o " + b.krytAtak + "% twojego maksymalnego zdrowia.";
            case 1:
                return "Wskrzeszasz martwego sojusznika z 50% maksymalnego zdrowia albo leczysz wszystkich o " + b.krytAtak + "% maksymalnego zdrowia.";
            case 2:
                return "Atakujesz i leczysz wszystkich o 30% zadanych przez ciebie obrażeń.";
            case 3:
                return "Zwiększ wszystkim maksymalne zdrowie o 2000.";
            case 4:
                return "Zwiększ wszystkim pancerz o " + b.krytAtak + "%.";
            case 5:
                return "Zwiększ wszystkim atak o " + b.krytAtak + "%.";
            case 6:
                return "Podwój swój atak i uderz przeciwnika.";
            case 7:
                return "Następny cios przeciwnika nie zadaje tobie żadnych obrażeń.";
            case 8:
                return "Zmniejsza pancerz przeciwnika o połowe.";
            case 9:
                return "Zwiększ wszystkim pancerz i atak o 20%.";
            case 10:
                return "Zwiększ wszystkim obrażenia krytyczne o 50%.";
            default:
                return "coś";
        }
    }

    @Override
    public String toString() {
        return "========" + this.name + "========" +
                "\nŻycie----------------" + this.zycie +
                "\nAtak-----------------" + this.atak +
                "\nPancerz------------" + this.obrona +
                "\nSzybkość----------" + this.szybkosc +
                "\nSzansa na Kryt.--" + this.krytSzansa +
                "\nObrażenia Kryt.--" + this.krytAtak +
                "\n===========Atak===========" +
                "\n" + opiszAtak(this) +
                "\n===========Spell===========" +
                "\n" + opiszCzar(this);

    }
}
