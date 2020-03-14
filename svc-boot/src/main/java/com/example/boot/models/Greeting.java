package com.example.boot.models;


public class Greeting {
    public final String name;

    public Greeting() {
        name = "empty";
    }

    public Greeting(String _name) {
        this.name = _name;
    }
    
    public String getName() {
        return name;
    }
}