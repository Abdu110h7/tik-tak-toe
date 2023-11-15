package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class ChooseActivity extends AppCompatActivity {


    MaterialButton startbutten;
    EditText player1,player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        initViews();
        startbutten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String player1Name =player1.getText().toString();
                String player2Name= player2.getText().toString();
                if (player1Name.isEmpty()){
                    Toast.makeText(ChooseActivity.this, "Birinchi o`yinchini ismini  kiriting", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(player2Name.isEmpty()){
                    Toast.makeText(ChooseActivity.this, "ikkinchi o`yinchini ismini kiritng", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent =new Intent(ChooseActivity.this,MainActivity.class);
                intent.putExtra("Player1",player1Name);
                intent.putExtra("Player2",player2Name);
                startActivity(intent);

            }
        });

    }

    private void initViews() {
        startbutten = findViewById(R.id.startbutten);
        player1 = findViewById(R.id.Player1);
        player2 = findViewById(R.id.Player2);
    }
}