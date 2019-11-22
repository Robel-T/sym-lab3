package com.example.lab3_sym;

public class Person {

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

    public void setSecurityMax(){
        securityLevel = 10;
    }

    public void setSecuritylowerLevel(){
       if(securityLevel > 0){
           securityLevel -= 1;
       }
    }
}
