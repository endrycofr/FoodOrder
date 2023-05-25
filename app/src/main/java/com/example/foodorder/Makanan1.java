package com.example.foodorder;

import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Struct;


public class Makanan1 extends AppCompatActivity {
    private ImageButton nextButton, addButton, minButton;
    private TextView jumlahPesanan;
    private int counter = 0;
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
        addButton=findViewById(R.id.imageadd);
        minButton=findViewById(R.id.imagemin);
        jumlahPesanan=findViewById(R.id.jumlahPesanan);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                jumlahPesanan.setText(String.valueOf(counter));
            }
        });
        minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                jumlahPesanan.setText(String.valueOf(counter));
            }
        }) ;
    }
}