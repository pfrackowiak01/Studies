package com.example.summonersbattle2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Porazka extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_porazka);
    }

    public void dalej(View view) {
        ktoregoWybieramy = 0;
        ktoregoWybieramyA = 0;
        lvl = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}