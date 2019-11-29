package com.example.lab3_sym;


import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.lab3_sym.NfcAppCompatActivity.loggedPerson;

public class Person implements Serializable {

    private String username;
    private String password;
    private int securityLevel;



    Person(String username, String password){
        this.username = username;
        this.password = password;
        securityLevel = 0;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername(){
        return username;
    }

    public int getSecurityLevel(){
        return securityLevel;
    }

    public void setSecurityMax(){
        securityLevel = 10;
    }

    public void setSecuritylowerLevel(){
       if(securityLevel > 0){
           securityLevel -= 1;
       }
    }

}
