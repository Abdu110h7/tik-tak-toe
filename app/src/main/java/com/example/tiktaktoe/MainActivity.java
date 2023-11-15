package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3,img4,img5,img6,img7,img8,img9;
    boolean isTurnX =true;
    Dialog dialog;
    TextView winnername;
    MaterialButton restart;

    String player1, player2;

    TextView turnName;



    String[][] table = new String[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setDialog();
        turnName.setText( player1 + " Navbati");
        img1.setOnClickListener(v -> clickTable((ImageView)v,1));
        img2.setOnClickListener(v -> clickTable((ImageView)v,2));
        img3.setOnClickListener(v -> clickTable((ImageView)v,3));
        img4.setOnClickListener(v -> clickTable((ImageView)v,4));
        img5.setOnClickListener(v -> clickTable((ImageView)v,5));
        img6.setOnClickListener(v -> clickTable((ImageView)v,6));
        img7.setOnClickListener(v -> clickTable((ImageView)v,7));
        img8.setOnClickListener(v -> clickTable((ImageView)v,8));
        img9.setOnClickListener(v -> clickTable((ImageView)v,9));


    }

    private void setDialog() {
        dialog= new Dialog(this);
        dialog.setContentView(R. layout.winner_dialog);
        dialog.setCancelable(false );
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        winnername = dialog.findViewById(R.id.textView2);
        restart = dialog.findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                recreate();
            }
        });
    }


    private void clickTable(ImageView v,int position) {
        if(v.getDrawable()!=null){
            return;
        }

        int x =(position -1) /3;
        int y =(position-1) %3;

        if(isTurnX) {
            turnName.setText(player2 + " navbati");

            v.setImageResource(R.drawable.ic_x);
            table[x][y] = "x";
        }else {
            turnName.setText(player1 + " navbati");
            v.setImageResource(R.drawable.ic_0);
            table[x][y] = "0";
        }
        if (hasWinner(table)) {

            if (isTurnX) {

               winnername.setText(player1 + " G`alaba qozondi");
                dialog.show();
               return;
            } else {
                winnername.setText(player2 + " G`alaba qozondi");
                dialog.show();
               return;

            }
        }
        if (isDraw(table)){
            winnername.setText("Do`stlik g`alaba qozondi");
            dialog.show();
        }
        isTurnX=!isTurnX;
    }

    private boolean isDraw(String [][] table){
        for (int i = 0; i < 3;i++){
            for (int j = 0; j<3; j++){
                if (table[i][j].equals("*")){
                    return false;
                }

            }
        }
         return true;
    }
    private  boolean hasWinner(String[][] table) {

        /// winner x
        if ((table[0][0].equals("x") && table[0][1].equals("x") && table[0][2].equals("x")) ||
                (table[1][0].equals("x") && table[1][1].equals("x") && table[1][2].equals("x")) ||
                (table[2][0].equals("x") && table[2][1].equals("x") && table[2][2].equals("x")) ||
                (table[0][0].equals("x") && table[1][0].equals("x") && table[2][0].equals("x")) ||
                (table[0][1].equals("x") && table[1][1].equals("x") && table[2][1].equals("x")) ||
                (table[0][2].equals("x") && table[1][2].equals("x") && table[2][2].equals("x")) ||
                (table[0][0].equals("x") && table[1][1].equals("x") && table[2][2].equals("x")) ||
                (table[2][0].equals("x") && table[1][1].equals("x") && table[0][2].equals("x"))) {
            return true;

        }
        if ((table[0][0].equals("0") && table[0][1].equals("0") && table[0][2].equals("0")) ||
                (table[1][0].equals("0") && table[1][1].equals("0") && table[1][2].equals("0")) ||
                (table[2][0].equals("0") && table[2][1].equals("0") && table[2][2].equals("0")) ||
                (table[0][0].equals("0") && table[1][0].equals("0") && table[2][0].equals("0")) ||
                (table[0][1].equals("0") && table[1][1].equals("0") && table[2][1].equals("0")) ||
                (table[0][2].equals("0") && table[1][2].equals("0") && table[2][2].equals("0")) ||
                (table[0][0].equals("0") && table[1][1].equals("0") && table[2][2].equals("0")) ||
                (table[2][0].equals("0") && table[1][1].equals("0") && table[0][2].equals("0"))) {
            return true;


        }
        return false;
    }


    private void initViews() {
        img1=findViewById(R.id.img_1);
        img2=findViewById(R.id.img_2);
        img3=findViewById(R.id.img_3);
        img4=findViewById(R.id.img_4);
        img5=findViewById(R.id.img_5);
        img6=findViewById(R.id.img_6);
        img7=findViewById(R.id.img_7);
        img8=findViewById(R.id.img_8);
        img9=findViewById(R.id.img_9);
        player1 = getIntent().getStringExtra("Player1");
        player2 = getIntent().getStringExtra("Player2");
        turnName = findViewById(R.id.turnName);



        for (int i = 0; i < 3;i++){
            for (int j = 0; j<3; j++){
                table[i][j]="*";
            }
        }

    }
}