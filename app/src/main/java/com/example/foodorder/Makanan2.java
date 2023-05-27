package com.example.foodorder;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Makanan2 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private static final String COUNTER_KEY = "counter_makanan2";
    private ImageButton nextButton, addButton, minButton;
    private TextView jumlahPesanan;
    private int counter = 0;
    private ImageButton prevButton;
    private ImageButton checkoutButton;
    private Button addCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makanan2);
        Intent intent = new Intent(Makanan2.this, Checkout.class);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        counter = sharedPreferences.getInt(COUNTER_KEY, 0);
        addCart = findViewById(R.id.addToCart);
        prevButton = findViewById(R.id.arrow_left);
        checkoutButton = findViewById(R.id.keranjang);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Makanan2.this, Makanan1.class);
                startActivity(intent);
            }
        });



        addButton = findViewById(R.id.imageadd);
        minButton = findViewById(R.id.imagemin);
        jumlahPesanan = findViewById(R.id.jumlahPesanan);
        jumlahPesanan.setText(String.valueOf(counter));

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
                if (counter > 0) {
                    counter--;
                }
                jumlahPesanan.setText(String.valueOf(counter));
            }
        });
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("hotdog",counter);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Simpan nilai counter ke SharedPreferences saat aktivitas di-pause
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_KEY, counter);
        editor.apply();
    }
}
