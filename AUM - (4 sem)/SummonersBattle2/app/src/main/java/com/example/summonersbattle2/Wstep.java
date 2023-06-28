package com.example.summonersbattle2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Wstep extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wstep);

        TextView info = (TextView)findViewById(R.id.info);
        info.setText("Witaj podrózniku w naszym świecie! Miło, że nas odwiedziłeś. Akurat mamy ostatnio mały problem z niechcianymi gośćmi z innych wymiarów. Kilkoru śmiałków zebrało się, aby powstrzymać te potwory. Proszę, pomóż nam wybrać 3 najlepszych bohaterów, którzy pokonają, razem z tobą na czele, te okrutne bestie.");
    }

    public void dalej(View view) {
        Intent intent = new Intent(this, Bohaterzy.class);
        startActivity(intent);
    }

}