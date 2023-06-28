package com.example.summonersbattle2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Bohaterzy extends InformacjeGra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bohaterzy);

        losujBohaterow();

        TextView info = (TextView)findViewById(R.id.info);
        info.setText("Kliknij na bohatera, aby zobaczyć jego statystyki");

        ImageView boh1 = (ImageView) findViewById(R.id.bohaterwybierz1);
        ImageView boh2 = (ImageView) findViewById(R.id.walkaboh2);
        ImageView boh3 = (ImageView) findViewById(R.id.bohaterwybierz3);
        wstawObrazek(boh1, bwybierz1);
        wstawObrazek(boh2, bwybierz2);
        wstawObrazek(boh3, bwybierz3);

        ktoregoWybieramy = ktoregoWybieramy + 1;
    }

    public void wyb1(View view) {
        ImageView boh1 = (ImageView) findViewById(R.id.bohaterwybierz1);
        boh1.setPadding(5,5,5,5);
        ImageView boh2 = (ImageView) findViewById(R.id.walkaboh2);
        boh2.setPadding(0,0,0,0);
        ImageView boh3 = (ImageView) findViewById(R.id.bohaterwybierz3);
        boh3.setPadding(0,0,0,0);
        TextView info = (TextView)findViewById(R.id.info);
        info.setText(bwybierz1.toString());
        if (ktoregoWybieramy == 1) b1 = bwybierz1;
        if (ktoregoWybieramy == 2) b2 = bwybierz1;
        if (ktoregoWybieramy == 3) b3 = bwybierz1;
    }

    public void wyb2(View view) {
        ImageView boh1 = (ImageView) findViewById(R.id.bohaterwybierz1);
        boh1.setPadding(0,0,0,0);
        ImageView boh2 = (ImageView) findViewById(R.id.walkaboh2);
        boh2.setPadding(5,5,5,5);
        ImageView boh3 = (ImageView) findViewById(R.id.bohaterwybierz3);
        boh3.setPadding(0,0,0,0);
        TextView info = (TextView)findViewById(R.id.info);
        info.setText(bwybierz2.toString());
        if (ktoregoWybieramy == 1) b1 = bwybierz2;
        if (ktoregoWybieramy == 2) b2 = bwybierz2;
        if (ktoregoWybieramy == 3) b3 = bwybierz2;
    }

    public void wyb3(View view) {
        ImageView boh1 = (ImageView) findViewById(R.id.bohaterwybierz1);
        boh1.setPadding(0,0,0,0);
        ImageView boh2 = (ImageView) findViewById(R.id.walkaboh2);
        boh2.setPadding(0,0,0,0);
        ImageView boh3 = (ImageView) findViewById(R.id.bohaterwybierz3);
        boh3.setPadding(5,5,5,5);
        TextView info = (TextView)findViewById(R.id.info);
        info.setText(bwybierz3.toString());
        if (ktoregoWybieramy == 1) b1 = bwybierz3;
        if (ktoregoWybieramy == 2) b2 = bwybierz3;
        if (ktoregoWybieramy == 3) b3 = bwybierz3;
    }

    public void dalej(View view) {

        if (ktoregoWybieramy >= 3) {
            Intent intent = new Intent(this, Artefakty.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, Bohaterzy.class);
            startActivity(intent);
        }
    }
}