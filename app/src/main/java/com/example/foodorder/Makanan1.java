package com.example.foodorder;

import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Makanan1 extends AppCompatActivity {
    private ImageButton nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makanan1);

        nextButton = findViewById(R.id.arrow_right);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan1.this, Makanan2.class);
                startActivity(intent);
            }
        });
    }
}