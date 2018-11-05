package com.example.sophie.library;

import android.view.View;
import android.widget.TextView;

class User {
    private int id;
    private String first_name;
    private String last_name;


    public User(){}

    public User(int id, String first_name, String last_name) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public String print() {
        return first_name + " " + last_name + "\nID: " + id + "\n\n";
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
}
