package com.example.midny.finalprojet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import org.parceler.Parcels;

public class RechercheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        String dateDebutReservation = Parcels.unwrap(getIntent().getParcelableExtra("dateDebut"));
        String dateFinReservation = Parcels.unwrap(getIntent().getParcelableExtra("dateFin"));


    }


}
