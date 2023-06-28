package com.example.summonersbattle2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Artefakty extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_artefakty);

        losujArtefakty();

        TextView info = (TextView)findViewById(R.id.info);
        info.setText("Kliknij na artefakt, aby zobaczyć jego statystyki");

        ImageView boh1 = (ImageView) findViewById(R.id.artefaktwybierz1);
        ImageView boh2 = (ImageView) findViewById(R.id.artefaktwybierz2);
        ImageView boh3 = (ImageView) findViewById(R.id.artefaktwybierz3);
        wstawObrazek(boh1, artefakt1);
        wstawObrazek(boh2, artefakt2);
        wstawObrazek(boh3, artefakt3);

        ktoregoWybieramyA = ktoregoWybieramyA + 1;
    }

    public void wyb1(View view) {
        ImageView boh1 = (ImageView) findViewById(R.id.artefaktwybierz1);
        boh1.setPadding(5,5,5,5);
        ImageView boh2 = (ImageView) findViewById(R.id.artefaktwybierz2);
        boh2.setPadding(0,0,0,0);
        ImageView boh3 = (ImageView) findViewById(R.id.artefaktwybierz3);
        boh3.setPadding(0,0,0,0);
        TextView info = (TextView)findViewById(R.id.info);
        info.setText(artefakt1.toString());
        if (ktoregoWybieramyA == 1) a1 = artefakt1;
        if (ktoregoWybieramyA == 2) a2 = artefakt1;
        if (ktoregoWybieramyA == 3) a3 = artefakt1;
        if (ktoregoWybieramyA == 4) a4 = artefakt1;
        if (ktoregoWybieramyA == 5) a5 = artefakt1;
    }

    public void wyb2(View view) {
        ImageView boh1 = (ImageView) findViewById(R.id.artefaktwybierz1);
        boh1.setPadding(0,0,0,0);
        ImageView boh2 = (ImageView) findViewById(R.id.artefaktwybierz2);
        boh2.setPadding(5,5,5,5);
        ImageView boh3 = (ImageView) findViewById(R.id.artefaktwybierz3);
        boh3.setPadding(0,0,0,0);
        TextView info = (TextView)findViewById(R.id.info);
        info.setText(artefakt2.toString());
        if (ktoregoWybieramyA == 1) a1 = artefakt1;
        if (ktoregoWybieramyA == 2) a2 = artefakt1;
        if (ktoregoWybieramyA == 3) a3 = artefakt1;
        if (ktoregoWybieramyA == 4) a4 = artefakt1;
        if (ktoregoWybieramyA == 5) a5 = artefakt1;
    }

    public void wyb3(View view) {
        ImageView boh1 = (ImageView) findViewById(R.id.artefaktwybierz1);
        boh1.setPadding(0,0,0,0);
        ImageView boh2 = (ImageView) findViewById(R.id.artefaktwybierz2);
        boh2.setPadding(0,0,0,0);
        ImageView boh3 = (ImageView) findViewById(R.id.artefaktwybierz3);
        boh3.setPadding(5,5,5,5);
        TextView info = (TextView)findViewById(R.id.info);
        info.setText(artefakt3.toString());
        if (ktoregoWybieramyA == 1) a1 = artefakt1;
        if (ktoregoWybieramyA == 2) a2 = artefakt1;
        if (ktoregoWybieramyA == 3) a3 = artefakt1;
        if (ktoregoWybieramyA == 4) a4 = artefakt1;
        if (ktoregoWybieramyA == 5) a5 = artefakt1;
    }

    public void dalej(View view) {
        Intent intent = new Intent(this, Walka.class);
        startActivity(intent);
    }
}