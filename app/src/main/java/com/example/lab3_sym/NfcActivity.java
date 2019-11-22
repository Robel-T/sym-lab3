package com.example.lab3_sym;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NfcActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button   sendbtn;
    private NfcAdapter mNfcAdapter;

    Person marion = new Person("Marion", "12345678");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfc_activity);

        // Link to GUI elements
        this.username   = findViewById(R.id.username);
        this.password	= findViewById(R.id.password);
        this.sendbtn    = findViewById(R.id.sendBtn);

        String usn      = username.getText().toString();
        String pwd      = password.getText().toString();
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        Person person = new Person(usn,pwd);

        this.sendbtn.setOnClickListener((view) -> {
            if(isValid(person,marion)){
                if(isNFC()){
                    marion.setSecurityMax();
                }
                Intent intent = new Intent(this, NfcSecurityActivity.class);
                this.startActivity(intent);
            }
        });



    }

    private boolean isValid(Person p1, Person p2){

        if(p1.getUsername().equals(p2.getUsername())){
            if(p1.getPassword().equals(p2.getPassword())){
                return true;
            }
        }
        return false;
    }

    private boolean isNFC(){
        return true;
    }
}
