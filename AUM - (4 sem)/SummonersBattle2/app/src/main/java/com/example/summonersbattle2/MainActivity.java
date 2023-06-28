package com.example.summonersbattle2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends InformacjeGra {

    public static final String EXTRA_MESSAGE = "com.summonersbattle.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void rozpocznijGre(View view) {
        Intent intent = new Intent(this, Wstep.class);
        startActivity(intent);
    }

    public void opcje(View view) {
        Intent intent = new Intent(this, OknoOpcje.class);
        //EditText ediText = (EditText) findViewById(R.id.editText);
        startActivity(intent);
    }

    public void wyjdz(View view) {
        finish();
        System.exit(0);
    }
}