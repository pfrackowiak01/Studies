package com.example.summonersbattle2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Walka extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_walka);

        losujPotwora();
        przygotowanie(b1, b2, b3, p);
        ImageView tlo = (ImageView) findViewById(R.id.tlo);
        tloOdLevela(tlo);

        ImageView boh1 = (ImageView) findViewById(R.id.walkaboh1);
        ImageView boh2 = (ImageView) findViewById(R.id.walkaboh2);
        ImageView boh3 = (ImageView) findViewById(R.id.walkaboh3);
        ImageView boss = (ImageView) findViewById(R.id.walkaboss);
        wstawObrazek(boh1, b1);
        wstawObrazek(boh2, b2);
        wstawObrazek(boh3, b3);
        wstawObrazek(boss, p);

        ProgressBar HPbohatera1 = findViewById(R.id.progressBarHP1);
        HPbohatera1.setMax(bohater1.zycie);
        HPbohatera1.setProgress(bohater1.zycie);
        HPbohatera1.setProgressTintList(ColorStateList.valueOf(Color.RED));
        ProgressBar HPbohatera2 = findViewById(R.id.progressBarHP2);
        HPbohatera2.setMax(bohater2.zycie);
        HPbohatera2.setProgress(bohater2.zycie);
        HPbohatera2.setProgressTintList(ColorStateList.valueOf(Color.RED));
        ProgressBar HPbohatera3 = findViewById(R.id.progressBarHP3);
        HPbohatera3.setMax(bohater3.zycie);
        HPbohatera3.setProgress(bohater3.zycie);
        HPbohatera3.setProgressTintList(ColorStateList.valueOf(Color.RED));
        ProgressBar HPpotwora = findViewById(R.id.progressBarHP4);
        HPpotwora.setMax(potwor.zycie);
        HPpotwora.setProgress(potwor.zycie);
        HPpotwora.setProgressTintList(ColorStateList.valueOf(Color.RED));
        ProgressBar SZbohatera1 = findViewById(R.id.progressBarSZ1);
        SZbohatera1.setMax(bohater1.szybkosc);
        SZbohatera1.setProgress(najszybszaPostac().szybkosc);
        SZbohatera1.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
        ProgressBar SZbohatera2 = findViewById(R.id.progressBarSZ2);
        SZbohatera2.setMax(bohater2.szybkosc);
        SZbohatera2.setProgress(najszybszaPostac().szybkosc);
        SZbohatera2.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
        ProgressBar SZbohatera3 = findViewById(R.id.progressBarSZ3);
        SZbohatera3.setMax(bohater3.szybkosc);
        SZbohatera3.setProgress(najszybszaPostac().szybkosc);
        SZbohatera3.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
        ProgressBar SZpotwora = findViewById(R.id.progressBarSZ4);
        SZpotwora.setMax(potwor.szybkosc);
        SZpotwora.setProgress(najszybszaPostac().szybkosc);
        SZpotwora.setProgressTintList(ColorStateList.valueOf(Color.BLUE));

        czyjaTura();
    }


    public void atak(View view) {

        turaAtak(najszybszaPostac());

        czyjaTura();

        wszyscyNieZyja();

        aktualizujSzybkosc();
    }

    public void czar(View view) {

        aktualizujSzybkosc();

        turaCzar(najszybszaPostac());

        czyjaTura();

        wszyscyNieZyja();

        aktualizujSzybkosc();
    }

    public void wszyscyNieZyja(){
        if (!bohater1.zyje() && !bohater2.zyje()  && !bohater3.zyje()) {
            Intent intent = new Intent(this, Porazka.class);
            startActivity(intent);
        }
    }

    public void wykonajTure() {
        if (najszybszaPostac() == bohater1) bohater1.szybkosc += b1.szybkosc;
        else if (najszybszaPostac() == bohater2) bohater2.szybkosc += b2.szybkosc;
        else if (najszybszaPostac() == bohater3) bohater3.szybkosc += b3.szybkosc;
        else potwor.szybkosc += p.szybkosc;
    }

    public Postac najszybszaPostac() {
        if (bohater1.szybkosc <= bohater2.szybkosc && bohater1.szybkosc <= bohater3.szybkosc && bohater1.szybkosc <= potwor.szybkosc) return bohater1;
        else if (bohater2.szybkosc <= bohater3.szybkosc && bohater2.szybkosc <= potwor.szybkosc) return bohater2;
        else if (bohater3.szybkosc <= potwor.szybkosc) return bohater3;
        else return potwor;
    }

    public void czyjaTura() {
        ImageView boh1 = (ImageView) findViewById(R.id.walkaboh1);
        boh1.setPadding(0,0,0,0);
        ImageView boh2 = (ImageView) findViewById(R.id.walkaboh2);
        boh2.setPadding(0,0,0,0);
        ImageView boh3 = (ImageView) findViewById(R.id.walkaboh3);
        boh3.setPadding(0,0,0,0);
        ImageView boss = (ImageView) findViewById(R.id.walkaboss);
        boss.setPadding(0,0,0,0);
        if (bohater1.zyje() && bohater1.szybkosc <= bohater2.szybkosc && bohater1.szybkosc <= bohater3.szybkosc && bohater1.szybkosc <= potwor.szybkosc) boh1.setPadding(5,5,5,5);
        else if (bohater2.zyje() && bohater2.szybkosc <= bohater3.szybkosc && bohater2.szybkosc <= potwor.szybkosc) boh2.setPadding(5,5,5,5);
        else if (bohater3.zyje() && bohater3.szybkosc <= potwor.szybkosc) boh3.setPadding(5,5,5,5);
        else boss.setPadding(5,5,5,5);
    }

    public void turaAtak(Postac postac) {

        ProgressBar HPbohatera1 = findViewById(R.id.progressBarHP1);
        ProgressBar HPbohatera2 = findViewById(R.id.progressBarHP2);
        ProgressBar HPbohatera3 = findViewById(R.id.progressBarHP3);
        if (postac != potwor && postac.zyje()) {
            potwor.atakBohateraWPotwora(postac, potwor);
            wykonajTure();
            aktualizujHPPotwora();
            aktualizujHPBohatera(HPbohatera1, bohater1);
            aktualizujHPBohatera(HPbohatera2, bohater2);
            aktualizujHPBohatera(HPbohatera3, bohater3);
        }
        if (postac != potwor && !postac.zyje()) postac.aktualneHP = 0;
        while (!najszybszaPostac().zyje()) wykonajTure();
        if (potwor.zyje()) {
            if (najszybszaPostac() == potwor) {
                czyjaTura();
                potwor.atakowanieBohaterów(bohater1, bohater2, bohater3, potwor);
                wykonajTure();
                aktualizujHPBohatera(HPbohatera1, bohater1);
                aktualizujHPBohatera(HPbohatera2, bohater2);
                aktualizujHPBohatera(HPbohatera3, bohater3);
            }
        }
        else {
            Intent intent = new Intent(this, Nagroda.class);
            startActivity(intent);
        }
    }

    public void turaCzar(Postac postac){

        ProgressBar HPbohatera1 = findViewById(R.id.progressBarHP1);
        ProgressBar HPbohatera2 = findViewById(R.id.progressBarHP2);
        ProgressBar HPbohatera3 = findViewById(R.id.progressBarHP3);
        if (postac != potwor && postac.zyje()) {
            if(postac.spell == 1) spellBohateraWPotwora(postac, potwor);
            else spellBohateraWPotwora(postac, potwor);
            wykonajTure();
            aktualizujHPPotwora();
            aktualizujHPBohatera(HPbohatera1, bohater1);
            aktualizujHPBohatera(HPbohatera2, bohater2);
            aktualizujHPBohatera(HPbohatera3, bohater3);
        }
        if (postac != potwor && !postac.zyje()) postac.aktualneHP = 0;
        while (!najszybszaPostac().zyje()) wykonajTure();
        if (potwor.zyje()) {
            if (najszybszaPostac() == potwor) {
                czyjaTura();
                potwor.atakowanieBohaterów(bohater1, bohater2, bohater3, potwor);
                wykonajTure();
                aktualizujHPBohatera(HPbohatera1, bohater1);
                aktualizujHPBohatera(HPbohatera2, bohater2);
                aktualizujHPBohatera(HPbohatera3, bohater3);
            }
        }
        else {
            Intent intent = new Intent(this, Nagroda.class);
            startActivity(intent);
        }
    }

    public void aktualizujSzybkosc() {

        ProgressBar SZbohatera1 = findViewById(R.id.progressBarSZ1);
        ProgressBar SZbohatera2 = findViewById(R.id.progressBarSZ2);
        ProgressBar SZbohatera3 = findViewById(R.id.progressBarSZ3);
        ProgressBar SZpotwora = findViewById(R.id.progressBarSZ4);

        while (czas < najszybszaPostac().szybkosc) {
            SZbohatera1.setProgress(czas % SZbohatera1.getMax());
            SZbohatera2.setProgress(czas % SZbohatera2.getMax());
            SZbohatera3.setProgress(czas % SZbohatera3.getMax());
            SZpotwora.setProgress(czas % SZpotwora.getMax());
            czas++;
        }
    }


    public void aktualizujHPPotwora() {


        ProgressBar HPpotwora = findViewById(R.id.progressBarHP4);
        int i = HPpotwora.getProgress();
        while(i>=potwor.aktualneHP) {
            HPpotwora.setProgress(i);
            /*
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            i -= 10;
        }
    }

    public void aktualizujHPBohatera(ProgressBar barHP, Postac b) {

        ProgressBar SZbohatera1 = findViewById(R.id.progressBarSZ1);
        ProgressBar SZbohatera2 = findViewById(R.id.progressBarSZ2);
        ProgressBar SZbohatera3 = findViewById(R.id.progressBarSZ3);
        int i = barHP.getProgress();
        if (i >= b.aktualneHP) {
            while (i >= b.aktualneHP) {
                barHP.setProgress(i);
            /*
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
                i -= 10;
            }
        } else {
            while (i <= b.aktualneHP) {
                barHP.setProgress(i);
            /*
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
                i += 10;
            }
        }
        if (i < 0) {
            barHP.setVisibility(View.INVISIBLE);
            if (b == bohater1) SZbohatera1.setVisibility(View.INVISIBLE);
            if (b == bohater2) SZbohatera2.setVisibility(View.INVISIBLE);
            if (b == bohater3) SZbohatera3.setVisibility(View.INVISIBLE);
        }
    }

    public void spellBohateraWPotwora(Postac b, Potwor p){

        ProgressBar HPbohatera1 = findViewById(R.id.progressBarHP1);
        ProgressBar HPbohatera2 = findViewById(R.id.progressBarHP2);
        ProgressBar HPbohatera3 = findViewById(R.id.progressBarHP3);
        switch (b.spell) {
            case 1:
                leczenieWszystkich(p.krytAtak);
                aktualizujHPBohatera(HPbohatera1, bohater1);
                aktualizujHPBohatera(HPbohatera2, bohater2);
                aktualizujHPBohatera(HPbohatera3, bohater3);
            case 2:
                int kradziez = b.uderzenie() - p.obrona;
                p.aktualneHP = p.aktualneHP - kradziez;
                leczenieWszystkichOWartosc(kradziez);
            default:
                p.aktualneHP = p.aktualneHP - (b.uderzenie() - p.obrona);
        }
    }

    public void leczenieWszystkich (int procent) {
        if (bohater1.zyje()) bohater1.aktualneHP = bohater1.aktualneHP + bohater1.zycie * procent/100;
        if (bohater1.aktualneHP > bohater1.zycie) bohater1.aktualneHP = bohater1.zycie;
        if (bohater2.zyje()) bohater2.aktualneHP = bohater2.aktualneHP + bohater2.zycie * procent/100;
        if (bohater2.aktualneHP > bohater2.zycie) bohater2.aktualneHP = bohater2.zycie;
        if (bohater3.zyje()) bohater3.aktualneHP = bohater3.aktualneHP + bohater3.zycie * procent/100;
        if (bohater3.aktualneHP > bohater3.zycie) bohater3.aktualneHP = bohater3.zycie;
    }

    public void leczenieWszystkichOWartosc (int wartosc) {
        if (bohater1.zyje()) bohater1.aktualneHP = bohater1.aktualneHP + wartosc;
        if (bohater1.aktualneHP > bohater1.zycie) bohater1.aktualneHP = bohater1.zycie;
        if (bohater2.zyje()) bohater2.aktualneHP = bohater2.aktualneHP + wartosc;
        if (bohater2.aktualneHP > bohater2.zycie) bohater2.aktualneHP = bohater2.zycie;
        if (bohater3.zyje()) bohater3.aktualneHP = bohater3.aktualneHP + wartosc;
        if (bohater3.aktualneHP > bohater3.zycie) bohater3.aktualneHP = bohater3.zycie;
    }
}