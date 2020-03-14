package com.example.greeting.models;

public class Greeting {
    public final String name;

    public Greeting(String _name) {
        this.name = _name;
    }
    
    public String getName() {
        return name;
    }
}