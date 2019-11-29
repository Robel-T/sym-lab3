package com.example.lab3_sym;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class NfcSecurityActivity extends NfcAppCompatActivity {

    private Button highButton;
    private Button mediumButton;
    private Button lowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.highButton   = findViewById(R.id.high);
        this.mediumButton	= findViewById(R.id.medium);
        this.lowButton    = findViewById(R.id.bottom);

        setContentView(R.layout.nfc_security_activity);

        setTitle("NFC Logged security");
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

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
            Toast.makeText(NfcSecurityActivity.this, "You are the best", Toast.LENGTH_LONG).show();

        } else {
            //ToastNotOk!
            Toast.makeText(NfcSecurityActivity.this, "Mais casse toi connard", Toast.LENGTH_LONG).show();
        }


    }



}
