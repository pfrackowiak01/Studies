package com.example.summonersbattle2;

import java.util.Random;

public class Postac {
    String name;
    int zycie;
    int atak;
    int obrona;
    int szybkosc;
    int krytSzansa;
    int krytAtak;
    int index;
    int hit;
    int spell;
    int aktualneHP;

    public Postac(String n, int hp, int a, int d, int s, int cr, int cd, int i, int h, int sp) {
        this.name = n;
        this.zycie = hp;
        this.atak = a;
        this.obrona = d;
        this.szybkosc = s;
        this.krytSzansa = cr;
        this.krytAtak = cd;
        this.index = i;
        this.hit = h;
        this.spell = sp;
        this.aktualneHP = hp;
    }

    public boolean zyje(){
        if(this.aktualneHP > 0) return true;
        else {
            this.aktualneHP = 0;
            return false;
        }
    }

    public int uderzenie(){
        Random rand = new Random();
        int losowa = rand.nextInt(100);   //  losowa od 0 do 99
        if (losowa < krytSzansa) return this.atak + this.atak * this.krytAtak/100;
        else return this.atak;
    }

    public void leczenieSiebie(int procent){
        if (this.zyje()) this.aktualneHP = this.aktualneHP + this.zycie * procent/100;
        if (this.aktualneHP > this.zycie) this.aktualneHP = this.zycie;
    }
}
