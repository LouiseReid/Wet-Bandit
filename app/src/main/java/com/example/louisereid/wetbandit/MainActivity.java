package com.example.louisereid.wetbandit;

import android.media.Image;
import android.media.MediaPlayer;
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
    private ImageButton topup5;
    private ImageButton topup10;
    private ImageButton topup20;
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
        topup5 = (ImageButton)findViewById(R.id.tu5);
        topup10 = (ImageButton)findViewById(R.id.tu10);
        topup20 = (ImageButton)findViewById(R.id.tu20);
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

    public void ontopUpBtnPress(View button){
        if (button == topup5){
            machine.topUp5();
        }
        else if (button == topup10){
            machine.topUp10();
        }
        else if(button == topup20){
            machine.topUp20();
        }
        credit.setText(machine.getCredit().toString());
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.kaching);
        mp.start();
    }


    public void onCollectBtnPress(View button){
        machine.collect();
        machine.setBank(1000);
        credit.setText(machine.getCredit().toString());
        jackpot.setText(machine.getBank().toString());
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.keepthechange);
        mp.start();

    }
}
