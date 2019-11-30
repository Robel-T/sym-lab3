/**
 * Fichier: MainActivity.java
 *
 * Auteur: Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date  : 1 Décembre 2019
 *
 * But   : Implémentation de l'activité principale qui lance les activités du laboratoire.
 *
 */

package com.example.lab3_sym;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab3_sym.Activity.NFC.NfcActivity;
import com.example.lab3_sym.Activity.QR.QrActivity;

public class MainActivity extends AppCompatActivity {

    private Button nfcButton       = null;
    private Button codeBarreButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nfcButton       = findViewById(R.id.nfc);
        this.codeBarreButton = findViewById(R.id.codebarre);

        nfcButton.setOnClickListener((view) -> {
            Intent intent = new Intent(this, NfcActivity.class);
            this.startActivity(intent);
        });

        codeBarreButton.setOnClickListener((view) -> {
            Intent intent = new Intent(this, QrActivity.class);
            this.startActivity(intent);
        });

    }
}
