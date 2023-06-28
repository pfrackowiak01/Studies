package com.example.summonersbattle2;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class InformacjeGra extends AppCompatActivity {

    static public int PoziomTrudnosci = 0;    // 0 - latwy, 1 - sredni, 2 - trudny
    static public int Muzyka = 1;             // 0 - off, 1 - on
    static public int Jezyk = 0;              // 0 - polski, 1 - angielski
    static public int ktoregoWybieramy = 0;
    static public int ktoregoWybieramyA = 0;
    static public int czas = 0;
    static public int lvl = 0;

    static Bohater czarownica = new Bohater("Czarownica",10000,300,120,120,0,50,0,1,8);
    static Bohater wampir = new Bohater("Wampir",6000,600,100,80,50,70,1,2,2);
    static Bohater palladyn = new Bohater("Palladyn",10000,500,200,100,60,60,2,3,3);
    static Bohater rycerz = new Bohater("Rycerz",8000,400,200,80,70,60,3,4,4);
    static Bohater mag = new Bohater("Mag",6000,400,100,100,0,80,4,1,9);
    static Bohater assasin = new Bohater("Assasin",6000,600,80,100,100,60,5,5,10);
    static Bohater demon = new Bohater("Demon",8000,200,90,140,50,100,6,6,6);
    static Bohater druid = new Bohater("Druid",10000,300,160,110,30,20,7,6,1);
    static Bohater ninja = new Bohater("Ninja",5000,700,50,70,100,70,8,5,7);
    static Bohater pirat = new Bohater("Pirat",8000,500,100,100,0,50,9,1,5);
    static Bohater szamanka = new Bohater("Szamanka",12000,200,120,100,25,50,10,7,4);
    static Bohater uzdrowicielka = new Bohater("Uzdrowicielka",14000,200,200,130,40,20,11,8,1);
    static Bohater pusty = new Bohater("Pusty",0,0,0,0,0,0,-1,0,0);

    static Artefakt miecze = new Artefakt("Ostre Szable",0,10,4,2);
    static Artefakt tarcza = new Artefakt("Mityczna Tarcza",1,10,2,1);
    static Artefakt topor = new Artefakt("Topór Wikinga",2,10,5,3);
    static Artefakt zegar = new Artefakt("Zegar Czasu",3,10,3,4);
    static Artefakt serce = new Artefakt("Szlachetne Serce",4,10,1,5);

    //Potwor hydralatwa = new Potwor();
    Potwor hydralatwa = new Potwor("Hydra",20000,1000,200,200,30,60,20,0,0);
    Potwor hydrasrednia = new Potwor("Hydra",20000,2000,250,180,30,60,21,1,1);
    Potwor hydratrudna = new Potwor("Hydra",20000,4000,300,160,30,60,22,2,2);

    //Wylosowani do wyboru
    static Bohater bwybierz1;
    static Bohater bwybierz2;
    static Bohater bwybierz3;
    static Artefakt artefakt1;
    static Artefakt artefakt2;
    static Artefakt artefakt3;


    //Aliasy
    static Artefakt a1;
    static Artefakt a2;
    static Artefakt a3;
    static Artefakt a4;
    static Artefakt a5;
    static Bohater b1 = pusty;
    static Bohater b2 = pusty;
    static Bohater b3 = pusty;
    static Potwor p;

    //Kopie wybranych bohaterów / potworów / artefaktów
    static Bohater bohater1;
    static Bohater bohater2;
    static Bohater bohater3;
    static Potwor potwor;
    static Artefakt fakt1 = a1;
    static Artefakt fakt2 = a2;
    static Artefakt fakt3 = a3;
    static Artefakt fakt4 = a4;
    static Artefakt fakt5 = a5;

    //Potwor potwor = new Potwor("Hydra",20000,1000,200,200,30,60,hydrao,0,0);
    //Bohater potwor = new Potwor("Hydra",20000,1000,200,200,30,60,hydrao,0,0);

    public void losujPotwora(){
        if (PoziomTrudnosci == 0) p = hydralatwa;
        if (PoziomTrudnosci == 1) p = hydrasrednia;
        if (PoziomTrudnosci == 2) p = hydratrudna;
    }

    public void losujArtefakt(int ktory) {
        Random rand = new Random();
        int los = rand.nextInt(5);
        Artefakt a;
        switch (los) {
            case 0:
                a = miecze;
                break;
            case 1:
                a = tarcza;
                break;
            case 2:
                a = topor;
                break;
            case 3:
                a = zegar;
                break;
            default:
                a = serce;
                break;
        }
        if (ktory == 1) artefakt1 = a;
        if (ktory == 2) artefakt2 = a;
        if (ktory == 3) artefakt3 = a;
    }

    public void losujBohatera(int ktory) {
        Random rand = new Random();
        int los = rand.nextInt(12);
        Bohater b;
        switch (los) {
            case 0:
                b = czarownica;
                break;
            case 1:
                b = wampir;
                break;
            case 2:
                b = palladyn;
                break;
            case 3:
                b = rycerz;
                break;
            case 4:
                b = mag;
                break;
            case 5:
                b = assasin;
                break;
            case 6:
                b = demon;
                break;
            case 7:
                b = druid;
                break;
            case 8:
                b = ninja;
                break;
            case 9:
                b = pirat;
                break;
            case 10:
                b = szamanka;
                break;
            default:
                b = uzdrowicielka;
        }
        if (ktory == 1) bwybierz1 = b;
        if (ktory == 2) bwybierz2 = b;
        if (ktory == 3) bwybierz3 = b;
    }

    public void losujBohaterow() {
        losujBohatera(1);
        while (bwybierz1.index == b1.index || bwybierz1.index == b2.index || bwybierz1.index == b2.index) losujBohatera(1);
        losujBohatera(2);
        while (bwybierz2.index == b1.index || bwybierz2.index == b2.index || bwybierz2.index == b2.index || bwybierz1.index == bwybierz2.index) losujBohatera(2);
        losujBohatera(3);
        while (bwybierz3.index == b1.index || bwybierz3.index == b2.index || bwybierz3.index == b2.index || bwybierz1.index == bwybierz3.index || bwybierz2.index == bwybierz3.index) losujBohatera(3);
    }

    public void losujArtefakty() {
        losujArtefakt(1);
        losujArtefakt(2);
        while (artefakt1.index == artefakt2.index) losujArtefakt(2);
        losujArtefakt(3);
        while (artefakt1.index == artefakt3.index || artefakt2.index == artefakt3.index) losujArtefakt(3);
    }

    public void wstawObrazek(ImageView obrazek, Object boh) {
        if (boh == czarownica) obrazek.setImageResource(R.drawable.czarownica);
        if (boh == wampir) obrazek.setImageResource(R.drawable.wampir);
        if (boh == palladyn) obrazek.setImageResource(R.drawable.palladyn);
        if (boh == rycerz) obrazek.setImageResource(R.drawable.rycerz);
        if (boh == mag) obrazek.setImageResource(R.drawable.mag);
        if (boh == assasin) obrazek.setImageResource(R.drawable.assasin);
        if (boh == demon) obrazek.setImageResource(R.drawable.demon);
        if (boh == druid) obrazek.setImageResource(R.drawable.druid);
        if (boh == ninja) obrazek.setImageResource(R.drawable.ninja);
        if (boh == pirat) obrazek.setImageResource(R.drawable.pirat);
        if (boh == szamanka) obrazek.setImageResource(R.drawable.szamanka);
        if (boh == uzdrowicielka) obrazek.setImageResource(R.drawable.uzdrowicielka);
        if (boh == miecze) obrazek.setImageResource(R.drawable.miecze);
        if (boh == tarcza) obrazek.setImageResource(R.drawable.tarcza);
        if (boh == topor) obrazek.setImageResource(R.drawable.topor);
        if (boh == zegar) obrazek.setImageResource(R.drawable.zegar);
        if (boh == serce) obrazek.setImageResource(R.drawable.serce);
        if (boh == hydralatwa) obrazek.setImageResource(R.drawable.hydra);
        if (boh == hydrasrednia) obrazek.setImageResource(R.drawable.hydra);
        if (boh == hydratrudna) obrazek.setImageResource(R.drawable.hydra);
    }

    public void ulepszArtefakt(Artefakt a, int i) {
        if (i == 1) fakt1 = new Artefakt(a.name,a.index,a.wartosc*2,a.zaleta,0);
        if (i == 2) fakt2 = new Artefakt(a.name,a.index,a.wartosc*2,a.zaleta,0);
        if (i == 3) fakt3 = new Artefakt(a.name,a.index,a.wartosc*2,a.zaleta,0);
        if (i == 4) fakt4 = new Artefakt(a.name,a.index,a.wartosc*2,a.zaleta,0);
        if (i == 5) fakt5 = new Artefakt(a.name,a.index,a.wartosc*2,a.zaleta,0);
    }

    public void przygotowanie(Bohater b1, Bohater b2, Bohater b3, Potwor p) {
        bohater1 = new Bohater(b1.name, b1.zycie, b1.atak, b1.obrona, b1.szybkosc, b1.krytSzansa, b1.krytAtak, b1.index, b1.hit, b1.spell);
        bohater2 = new Bohater(b2.name, b2.zycie, b2.atak, b2.obrona, b2.szybkosc, b2.krytSzansa, b2.krytAtak, b2.index, b2.hit, b2.spell);
        bohater3 = new Bohater(b3.name, b3.zycie, b3.atak, b3.obrona, b3.szybkosc, b3.krytSzansa, b3.krytAtak, b3.index, b3.hit, b3.spell);
        potwor = new Potwor(p.name, p.zycie, p.atak, p.obrona, p.szybkosc, p.krytSzansa, p.krytAtak, p.index, p.hit, p.spell);
        //potwor = new Potwor(hydralatwa.name,hydralatwa.zycie,hydralatwa.atak,hydralatwa.obrona,hydralatwa.szybkosc,hydralatwa.krytSzansa,hydralatwa.krytAtak,hydralatwa.obrazek,hydralatwa.hit,hydralatwa.spell);
        czas = 0;
    }
     public void tloOdLevela(ImageView tlo) {
        if (lvl == 0) tlo.setImageResource(R.drawable.forest);
        if (lvl == 1) tlo.setImageResource(R.drawable.forest2);
        if (lvl == 2) tlo.setImageResource(R.drawable.forest3);
        if (lvl == 3) tlo.setImageResource(R.drawable.desert);
        if (lvl == 4) tlo.setImageResource(R.drawable.mountain);
        if (lvl == 5) tlo.setImageResource(R.drawable.stone2);
        if (lvl == 6) tlo.setImageResource(R.drawable.lava);
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
}
