package com.example.summonersbattle2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Nagroda extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nagroda);
        ImageView tlo = (ImageView) findViewById(R.id.tlo);
        tloOdLevela(tlo);
    }

    public void dalej(View view) {
        lvl++;
        Intent intent = new Intent(this, Artefakty.class);
        startActivity(intent);
    }
}