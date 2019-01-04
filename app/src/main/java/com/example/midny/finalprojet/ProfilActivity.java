package com.example.midny.finalprojet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void clickValider(View view) {
        EditText userName = (EditText)findViewById(R.id.nom);
        EditText userSurname = (EditText)findViewById(R.id.prenom);
        EditText birthDate = (EditText)findViewById(R.id.dateNaissance);
        String nom = userName.getText().toString();
        String prenom = userSurname.getText().toString();
        String dateNaissace = birthDate.getText().toString();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nom", nom);
        editor.putString("prenom", prenom);
        editor.putString("dateNaissance", dateNaissace);
        editor.apply();
        Intent intent = new Intent();
        finish();
    }

}
