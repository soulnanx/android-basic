package com.example.renan.projetopi.entity;

/**
 * Created by renan on 1/23/15.
 */
public class Contact {
    private long id;
    private String name;
    private String number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
