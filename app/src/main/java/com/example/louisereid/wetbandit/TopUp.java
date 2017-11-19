package com.example.louisereid.wetbandit;

/**
 * Created by louisereid on 19/11/2017.
 */

public enum TopUp {

    FIVE(5),
    TEN(10),
    TWENTY(20);

    public int value;

    TopUp(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
