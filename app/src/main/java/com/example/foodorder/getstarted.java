package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class getstarted extends AppCompatActivity {

    private Button cardFindget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        cardFindget = (Button) findViewById(R.id.cardFindget);
        cardFindget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginActivity();
            }
        });
    }

    public void openloginActivity() {
        Intent intent = new Intent(getstarted.this, loginActivity.class);
        startActivity(intent);


//    Button btn;
//
//    Button btn = findViewById(R.id.cardFindget);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            startActivity(new Intent(getstarted.this, loginActivity.class));
//        }
//    });

    }
}