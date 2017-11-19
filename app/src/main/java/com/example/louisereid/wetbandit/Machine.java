package com.example.louisereid.wetbandit;

import java.util.ArrayList;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by louisereid on 17/11/2017.
 */

public class Machine {

    private int bank;
    private int winnings;
    private int price;
    private int noOfWheels;
    private int credit;
    private ArrayList<Wheel> row;


    public Machine(int bank, int winnings, int price, int noOfWheels, int credit) {
        this.bank = bank;
        this.winnings = winnings;
        this.price = price;
        this.noOfWheels = noOfWheels;
        this.row = new ArrayList<>();
        this.credit = credit;
        generateMachine();
    }

    public Integer getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getPrice() {
        return price;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public int getWinnings() {
        return winnings;
    }

    private void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    private void generateMachine() {
        for (int i = 0; i < noOfWheels; i++) {
            Wheel wheel = new Wheel();
            row.add(wheel);
        }
    }


    public ArrayList<Symbol> resultOfSpin(){
        ArrayList<Symbol> line = new ArrayList<>();
        for(Wheel wheel :row){
            Symbol symbol = wheel.spinWheel();
            line.add(symbol);
        }
        return line;
    }


    public int spin(ArrayList<Symbol> line) {
        int winnings = 0;
        boolean winningSpin = true;
        Symbol firstWheel = line.get(0);
        for (int i = 1; i < line.size(); i++) {
            if (line.get(i) != firstWheel) {
                winningSpin = false;
            }
        }
        if (winningSpin){
            for(Symbol symbol : line){
                winnings += symbol.getValue();
                if (firstWheel == Symbol.KEVIN) {
                    winnings = bank;
                }
            }
        }
        setWinnings(winnings);
        return this.getWinnings();
    }


    public void payout(int winnings){
        bank -= winnings;
        credit += winnings;
    }



    public void charge(){
        credit -= price;
        bank += price;

    }

    public void collect(){
        setCredit(0);
    }


    public void topUp5(){
        setCredit(getCredit() + TopUp.FIVE.value);
    }

    public void topUp10(){
        setCredit(getCredit() + TopUp.TEN.value);
    }

    public void topUp20(){
        setCredit(getCredit() + TopUp.TWENTY.value);
    }
}
