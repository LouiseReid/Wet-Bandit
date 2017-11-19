package com.example.louisereid.wetbandit;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by louisereid on 17/11/2017.
 */

public class Wheel {

    ArrayList<Symbol> wheel;

    public Wheel(){
        wheel = new ArrayList<>();
        generateWheel();
    }

    public Wheel(ArrayList<Symbol> newSymbols){
        this.wheel = newSymbols;

    }

    public ArrayList<Symbol> getSymbols() {
        return wheel;
    }

    private int getNumberOfSymbols(){
        return wheel.size();
    }

    private void generateWheel(){
        for(Symbol symbol : Symbol.values()){
            wheel.add(symbol);
        }
    }

    public Symbol getSymbolAtIndex(int index){
        return wheel.get(index);
    }

    private int getRandomNumber(){
        Random rand = new Random();
        int listSize = getNumberOfSymbols();
        int random = rand.nextInt(listSize);
        return random;
    }

    public Symbol getSymbol(){
        int index = getRandomNumber();
        return getSymbolAtIndex(index);
    }


    public Symbol spinWheel(){
        return getSymbol();
    }
}
