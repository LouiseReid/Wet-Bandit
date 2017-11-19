package com.example.louisereid.wetbandit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView wheel1;
    private ImageView wheel2;
    private ImageView wheel3;
    private TextView credit;
    private TextView jackpot;
    private Button collect;
    private Button topup5;
    private Button topup10;
    private Button topup20;
    private ImageButton spin;
    private Machine machine;
    private ArrayList<Symbol> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        machine = new Machine(1000, 0, 5, 3, 0);


        wheel1 = (ImageView)findViewById(R.id.wheel1);
        wheel2 = (ImageView)findViewById(R.id.wheel2);
        wheel3 = (ImageView)findViewById(R.id.wheel3);
        credit = (TextView)findViewById(R.id.creditView);
        jackpot = (TextView)findViewById(R.id.jackpotView);
        collect = (Button)findViewById(R.id.collectBtn);
        topup5 = (Button)findViewById(R.id.tu5);
        topup10 = (Button)findViewById(R.id.tu10);
        topup20 = (Button)findViewById(R.id.tu20);
        spin = (ImageButton)findViewById(R.id.spinBtn);

        credit.setText(machine.getCredit().toString());
        jackpot.setText(machine.getBank().toString());

    }

    public void onSpinButtonPress(View button){
        if (machine.getCredit() >= machine.getPrice()) {
            machine.charge();
            result = machine.resultOfSpin();
            machine.spin(result);
            machine.payout(machine.spin(result));

            wheel1.setImageResource(result.get(0).getImage());
            wheel2.setImageResource(result.get(1).getImage());
            wheel3.setImageResource(result.get(2).getImage());

            credit.setText(machine.getCredit().toString());
            jackpot.setText(machine.getBank().toString());
        }
    }

    public void ontopUpBtn5Press(View button){
        machine.topUp5();
        credit.setText(machine.getCredit().toString());
    }

    public void ontopUpBtn10Press(View button){
        machine.topUp10();
        credit.setText(machine.getCredit().toString());

    }

    public void ontopUpBtn20Press(View button){
        machine.topUp20();
        credit.setText(machine.getCredit().toString());
    }

    public void onCollectBtnPress(View button){
        machine.collect();
        machine.setBank(1000);
        credit.setText(machine.getCredit().toString());
        jackpot.setText(machine.getBank().toString());

    }
}
