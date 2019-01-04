package com.example.midny.finalprojet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void clickProfil(View view) {
        Intent intent = new Intent(this, ProfilActivity.class);
        startActivityForResult(intent, 123);
    }

    public void clickReservation(View view) {
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String valeur = preferences.getString("nom", " ");

    }

    public void clickRecherche(View view) {

        EditText debut = (EditText)findViewById(R.id.dateDebutReservation);
        String dateDebutReservation = debut.getText().toString();;

        EditText fin = (EditText)findViewById(R.id.dateFinReservation);
        String dateFinReservation = fin.getText().toString();


        // client HTTP :
        AsyncHttpClient client = new AsyncHttpClient();
        // paramètres :
        RequestParams requestParams = new RequestParams();
        requestParams.put("dateDebut", dateDebutReservation);
        requestParams.put("dateFin", dateFinReservation);

        // appel :
        client.post("http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php", requestParams, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response)
            {
                String retour = new String(response);
                try
                {
                    JSONObject jsonObject = new JSONObject(retour);
                    Log.i("yey", jsonObject.getString("info"));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] errorResponse, Throwable e)
            {
                Log.e("wola", e.toString());
            }
        });
        Intent intent = new Intent(this, RechercheActivity.class);
        startActivity(intent);

    }

}
