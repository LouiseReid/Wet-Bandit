package com.example.louisereid.wetbandit;

/**
 * Created by louisereid on 17/11/2017.
 */

public enum Symbol {

    TAP(2, R.drawable.tap),
    MARV(5, R.drawable.marv),
    HARRY(5, R.drawable.harry),
    KEVIN(10, R.drawable.kevin);

    private int value;
    private int image;

    Symbol(int value, int image) {
        this.value = value;
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public Integer getImage(){
        return image;
    }
}
