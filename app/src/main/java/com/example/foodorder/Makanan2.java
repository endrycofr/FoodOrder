package com.example.foodorder;

import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Makanan2 extends AppCompatActivity {
    private ImageButton nextButton;
    private ImageButton prevButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makanan2);

        nextButton = findViewById(R.id.arrow_right);
        prevButton = findViewById(R.id.arrow_left);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan2.this, Makanan1.class);
                startActivity(intent);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan2.this, Checkout.class);
                startActivity(intent);
            }
        });
    }
}