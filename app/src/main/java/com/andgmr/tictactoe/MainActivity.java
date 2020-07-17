package com.andgmr.tictactoe;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b11, b12, b13, b21, b22, b23, b31, b32, b33, resetBT;
    private AlertDialog.Builder gameOverDialog;
    private TextView turnText;
    private int sem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeUI();

        resetBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetare();
            }
        });

        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b31.setOnClickListener(this);
        b32.setOnClickListener(this);
        b33.setOnClickListener(this);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_main);

        InitializeUI();
    }

    public void InitializeUI(){
        b11 = (Button) findViewById(R.id.box11);
        b12 = (Button) findViewById(R.id.box12);
        b13 = (Button) findViewById(R.id.box13);
        b21 = (Button) findViewById(R.id.box21);
        b22 = (Button) findViewById(R.id.box22);
        b23 = (Button) findViewById(R.id.box23);
        b31 = (Button) findViewById(R.id.box31);
        b32 = (Button) findViewById(R.id.box32);
        b33 = (Button) findViewById(R.id.box33);

        resetBT = (Button) findViewById(R.id.resetButton);

        turnText = (TextView) findViewById(R.id.turnText);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.box11:
                if(b11.getText()=="")
                    if(sem==0){
                        b11.setText("X");
                        turnText.setText("0");
                        sem=1;
                    }else{
                        b11.setText("0");
                        turnText.setText("X");
                        sem=0;
                    }
                verificare();

                break;
            case R.id.box12:
                if(b12.getText()=="")
                if(sem==0){
                    b12.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b12.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box13:
                if(b13.getText()=="")
                if(sem==0){
                    b13.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b13.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box21:
                if(b21.getText()=="")
                if(sem==0){
                    b21.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b21.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box22:
                if(b22.getText()=="")
                if(sem==0){
                    b22.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b22.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box23:
                if(b23.getText()=="")
                if(sem==0){
                    b23.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b23.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box31:
                if(b31.getText()=="")
                if(sem==0){
                    b31.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b31.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box32:
                if(b32.getText()=="")
                if(sem==0){
                    b32.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b32.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
            case R.id.box33:
                if(b33.getText()=="")
                if(sem==0){
                    b33.setText("X");
                    turnText.setText("0");
                    sem=1;
                }else{
                    b33.setText("0");
                    turnText.setText("X");
                    sem=0;
                }
                verificare();
                break;
        }
    }

    private void verificare(){
        if(     b11.getText()!="" &&
                b12.getText()!="" &&
                b13.getText()!="" &&
                b21.getText()!="" &&
                b22.getText()!="" &&
                b23.getText()!="" &&
                b31.getText()!="" &&
                b32.getText()!="" &&
                b33.getText()!=""){
            if ((b11.getText() == b12.getText() && b13.getText() == b12.getText()) ||
                    (b21.getText() == b22.getText() && b22.getText() == b23.getText()) ||
                    (b31.getText() == b32.getText() && b32.getText() == b33.getText()) ||
                    (b11.getText() == b22.getText() && b33.getText() == b22.getText()) ||
                    (b13.getText() == b22.getText() && b22.getText() == b31.getText()) ||
                    (b11.getText() == b21.getText() && b21.getText() == b31.getText()) ||
                    (b12.getText() == b22.getText() && b32.getText() == b22.getText()) ||
                    (b13.getText() == b23.getText() && b23.getText() == b33.getText())){
                gameOverDialog = new AlertDialog.Builder(MainActivity.this);
                gameOverDialog.setPositiveButton(getResources().getString(R.string.reset),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialogInterface, int i) {
                                resetare();
                                dialogInterface.cancel();
                            }

                        });
                if(turnText.getText()=="0")
                    gameOverDialog.setMessage("A castigat X");
                else gameOverDialog.setMessage("A castigat 0");
                AlertDialog GameOver = gameOverDialog.create();

                GameOver.show();
            }else {
                gameOverDialog = new AlertDialog.Builder(MainActivity.this);
                gameOverDialog.setPositiveButton(getResources().getString(R.string.reset),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialogInterface, int i) {
                                resetare();
                                dialogInterface.cancel();
                            }

                        });
                gameOverDialog.setMessage("Este egalitate");
                AlertDialog GameOver = gameOverDialog.create();

                GameOver.show();
            }
        }
    }
    private void resetare(){
        sem=0;
        turnText.setText("X");
        b11.setText("");
        b12.setText("");
        b13.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b31.setText("");
        b32.setText("");
        b33.setText("");
    }
}