package com.example.summonersbattle2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class OknoOpcje extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_okno_opcje);
        if(PoziomTrudnosci == 0) latwyf();
        if(PoziomTrudnosci == 1) srednif();
        if(PoziomTrudnosci == 2) trudnyf();
        if(Muzyka == 0) muzykaofff();
        if(Muzyka == 1) muzykaonf();
        if(Jezyk == 0) polskif();
        if(Jezyk == 1) englishf();
    }

    public void latwyf() {
        ((Button) findViewById(R.id.pt_latwy)).setBackgroundColor(Color.DKGRAY);
        ((Button) findViewById(R.id.pt_sredni)).setBackgroundColor(Color.BLACK);
        ((Button) findViewById(R.id.pt_trudny)).setBackgroundColor(Color.BLACK);
    }

    public void srednif() {
        ((Button) findViewById(R.id.pt_latwy)).setBackgroundColor(Color.BLACK);
        ((Button) findViewById(R.id.pt_sredni)).setBackgroundColor(Color.DKGRAY);
        ((Button) findViewById(R.id.pt_trudny)).setBackgroundColor(Color.BLACK);
    }
    public void trudnyf() {
        ((Button) findViewById(R.id.pt_latwy)).setBackgroundColor(Color.BLACK);
        ((Button) findViewById(R.id.pt_sredni)).setBackgroundColor(Color.BLACK);
        ((Button) findViewById(R.id.pt_trudny)).setBackgroundColor(Color.DKGRAY);
    }
    public void muzykaofff() {
        ((Button) findViewById(R.id.m_on)).setBackgroundColor(Color.BLACK);
        ((Button) findViewById(R.id.m_off)).setBackgroundColor(Color.DKGRAY);
    }
    public void muzykaonf() {
        ((Button) findViewById(R.id.m_on)).setBackgroundColor(Color.DKGRAY);
        ((Button) findViewById(R.id.m_off)).setBackgroundColor(Color.BLACK);
    }
    public void polskif() {
        ((Button) findViewById(R.id.j_p)).setBackgroundColor(Color.DKGRAY);
        ((Button) findViewById(R.id.j_e)).setBackgroundColor(Color.BLACK);
    }
    public void englishf() {
        ((Button) findViewById(R.id.j_p)).setBackgroundColor(Color.BLACK);
        ((Button) findViewById(R.id.j_e)).setBackgroundColor(Color.DKGRAY);
    }

    public void latwy(View view) {
        latwyf();
        PoziomTrudnosci = 0;
    }

    public void sredni(View view) {
        srednif();
        PoziomTrudnosci = 1;
    }

    public void trudny(View view) {
        trudnyf();
        PoziomTrudnosci = 2;
    }

    public void muzykaoff(View view) {
        muzykaofff();
        Muzyka = 0;
    }

    public void muzykaon(View view) {
        muzykaonf();
        Muzyka = 1;
    }

    public void polski(View view) {
        polskif();
        Jezyk = 0;
    }

    public void english(View view) {
        englishf();
        Jezyk = 1;
    }

    public void wroc(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
