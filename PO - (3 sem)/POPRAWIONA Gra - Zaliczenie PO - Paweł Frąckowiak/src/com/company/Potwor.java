package com.company;

import javax.swing.*;

public class Potwor extends Postac{

    public Potwor(String n, int hp, int a, int d, int s, int cr, int cd, ImageIcon o, int h, int sp) {
        super(n, hp, a, d, s, cr, cd, o, h, sp);
        int aktualneHP = hp;
    }

    public void atakBohateraWPotwora(Postac b, Potwor p){
        switch (b.hit) {
            case 2:
                int kradziez = (b.uderzenie() - p.obrona);
                p.aktualneHP = p.aktualneHP - kradziez;
                b.aktualneHP = b.aktualneHP + kradziez;
                if (b.aktualneHP > zycie) b.aktualneHP = zycie;
            default:
                p.aktualneHP = p.aktualneHP - (b.uderzenie() - p.obrona);
        }
    }
/*
    public void spellBohateraWPotwora(Postac b, Potwor p){
        switch (b.spell) {
            default:
                p.aktualneHP = p.aktualneHP - (b.uderzenie() - p.obrona);
        }
    }
*/
    public void atakowanieBohaterów(Bohater b1, Bohater b2, Bohater b3, Potwor p) {
        b1.aktualneHP = b1.aktualneHP - (p.uderzenie() - b1.obrona);
        b2.aktualneHP = b2.aktualneHP - (p.uderzenie() - b2.obrona);
        b3.aktualneHP = b3.aktualneHP - (p.uderzenie() - b3.obrona);
    }

}
