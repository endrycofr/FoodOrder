package com.example.foodorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Makanan1 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private static final String COUNTER_KEY = "counter";
    private ImageButton nextButton, addButton, minButton;
    private TextView jumlahPesanan;
    private int counter;
    private ImageButton checkoutButton;
    private Button addCart;
    private ImageButton prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makanan1);
        Intent intent = new Intent(Makanan1.this, Checkout.class);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        counter = sharedPreferences.getInt(COUNTER_KEY, 0);

        checkoutButton = findViewById(R.id.keranjang);
        nextButton = findViewById(R.id.arrow_right);
        prevButton = findViewById(R.id.arrow_left);
        addButton = findViewById(R.id.imageadd);
        minButton = findViewById(R.id.imagemin);
        jumlahPesanan = findViewById(R.id.jumlahPesanan);
        addCart = findViewById(R.id.addToCart);

        jumlahPesanan.setText(String.valueOf(counter));

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan1.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan1.this, Makanan2.class);
                startActivity(intent);
            }
        });

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
                if (counter == 0) {
                    counter = 0;
                } else if (counter > 0) {
                    counter--;
                }
                jumlahPesanan.setText(String.valueOf(counter));
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// Mengirim nilai counter ke Program 3
                startActivity(intent);
            }
        });

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tidak perlu menggunakan variabel burger di sini
                intent.putExtra("burger", counter);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY, counter);
        editor.apply();
    }
}
