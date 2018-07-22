package com.example.yumi.jyankenapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.text);
        final TextView subtext = (TextView)findViewById(R.id.subtext);
        Button rock = (Button)findViewById(R.id.rock);
        Button scissors = (Button)findViewById(R.id.scissors);
        Button paper = (Button)findViewById(R.id.paper);

        rock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(1,opponentHand,subtext);
                text.setText(opponentHandText);
            }
        });
        scissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(2,opponentHand,subtext);
                text.setText(opponentHandText);
            }
        });
        paper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(3,opponentHand,subtext);
                text.setText(opponentHandText);
            }
        });

    }

    String changeTextOpponentHand(int hand){
        String handText = "";
        if(hand == 1)handText = "グー";
        else if(hand == 2)handText = "チョキ";
        else if(hand == 3)handText = "パー";
        return handText;
    }
    int decideOpponentHand(){
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1; //bound??
        return hand;
    }
    void decideGame(int playerHand,int opponentHand,TextView decidetext){
        String decision;
        if(playerHand == opponentHand)decision = "あいこ";
        else if((playerHand == 3 && opponentHand == 1) || (playerHand+1 == opponentHand))
        decision ="勝ち";
        else decision = "負け";
        decidetext.setText(decision);
    }

}
