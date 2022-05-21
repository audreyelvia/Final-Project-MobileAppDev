package com.example.finalproject;

public class User {
    private String ID, email;

    public User(String ID, String email){
        this.ID = ID;
        this.email = email;
    }

    public String getID() {

        return ID;
    }

    public void setID(String ID) {

        this.ID = ID;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }


}
