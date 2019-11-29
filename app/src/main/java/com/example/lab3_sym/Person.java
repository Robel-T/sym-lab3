/**
 * Fichier: NfcActivity.java
 *
 * Auteur: Edoardo Carpita, Marion Dutu Launay, Robel Teklehaimanot
 * Date  : 1 Décembre 2019
 *
 * But   : Implémentation de la classe Person.
 *
 */

package com.example.lab3_sym;

import android.util.Log;
import java.io.Serializable;


public class Person implements Serializable {

    private String username;
    private String password;
    private int securityLevel;
    Log log;

    Person(){
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
           log.w("time", " " + securityLevel);
           securityLevel -= 1;
       }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
