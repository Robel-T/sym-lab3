/**
 * Fichier: NfcActivity.java
 *
 * Auteur: Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date  : 1 Décembre 2019
 *
 * But   : Implémentation de l'activité NFC qui s'occupe du login de la personne.
 *
 */



package com.example.lab3_sym.Activity.NFC;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab3_sym.Model.Person;
import com.example.lab3_sym.R;

public class NfcActivity extends NfcAppCompatActivity {

    private EditText username;
    private EditText password;
    private Button   sendbtn;
    Log log;

    protected static final String LOGTAG = "logged_person";

    Person marion = new Person();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfc_activity);

        // initialisation de l'utilisateur de vérification
        marion.setUsername("M");
        marion.setPassword("1");


        // Link to GUI elements
        this.username   = findViewById(R.id.username);
        this.password	= findViewById(R.id.password);
        this.sendbtn    = findViewById(R.id.sendBtn);


        this.sendbtn.setOnClickListener((view) -> {

            log.w("security"," " + loggedPerson.getSecurityLevel());
            String usn      = username.getText().toString();
            String pwd      = password.getText().toString();

            loggedPerson.setUsername(usn);
            loggedPerson.setPassword(pwd);

            mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

            if(isValid(loggedPerson,marion)){
                Intent intent = new Intent(this, NfcSecurityActivity.class);
                this.startActivity(intent);
            }
            else{
                Toast.makeText(NfcActivity.this, "Make contact with the nfc tag", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean isValid(Person p1, Person p2){

        if(p1.getUsername().equals(p2.getUsername())){
            if( p1.getPassword().equals(p2.getPassword()))
                return p1.getSecurityLevel() > 0;
        }
        return false;
    }


}
