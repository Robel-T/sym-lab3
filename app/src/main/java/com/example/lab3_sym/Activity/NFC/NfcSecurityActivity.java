/**
 * Fichier: NfcSecurityActivity.java
 *
 * Auteur: Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date  : 1 Décembre 2019
 *
 * But   : Implémentation de la deuxieme activité lancé après le login correct.
 *
 */


package com.example.lab3_sym.Activity.NFC;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.lab3_sym.R;

public class NfcSecurityActivity extends NfcAppCompatActivity {

    private Button highButton;
    private Button mediumButton;
    private Button lowButton;

    Log log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfc_security_activity);


        this.highButton   = findViewById(R.id.high);
        this.mediumButton	= findViewById(R.id.medium);
        this.lowButton    = findViewById(R.id.low);

        setTitle("NFC Logged security");

        this.highButton.setOnClickListener((view) -> {
            checkSecurity(9);
        });

        this.mediumButton.setOnClickListener((view) -> {
            checkSecurity(6);
        });

        this.lowButton.setOnClickListener((view) -> {
            checkSecurity(3);
        });


    }


    private void checkSecurity(int level){

        if (loggedPerson.getSecurityLevel() >= level) {
            //ToastOk!
            Toast.makeText(NfcSecurityActivity.this, "Niveau Suffisant", Toast.LENGTH_LONG).show();

        } else {
            //ToastNotOk!
            Toast.makeText(NfcSecurityActivity.this, "Niveau Insuffisant", Toast.LENGTH_LONG).show();
        }


    }



}
