package com.example.foodorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private static final String BURGER_KEY = "burger";
    private static final String HOTDOG_KEY = "hotdog";
    private int burger, hotdog, intentBurger, intentHotdog;
    private TextView banyakburger, banyakhotdog, itemTotalVal, totalHarga;
    private TextView hargaburger, hargahotdog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_screen);

        Intent intent = getIntent();
        intentBurger = intent.getIntExtra("burger", -1); // Mengambil nilai counter dari Program 1
        intentHotdog = intent.getIntExtra("hotdog", -1);
        banyakburger = findViewById(R.id.banyakpesanan1);
        hargaburger = findViewById(R.id.hargapesanan1);
        itemTotalVal = findViewById(R.id.itemTotalVal);
        totalHarga = findViewById(R.id.total);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        burger = sharedPreferences.getInt(BURGER_KEY, 0);
        hotdog = sharedPreferences.getInt(HOTDOG_KEY, 0);
        if (intentBurger != -1){
            burger = intentBurger;
        }
        if (intentHotdog != -1){
            hotdog = intentHotdog;
        }
        if (burger>= 0) {
            String jumlahBurger = String.valueOf(burger);
            int totalHargaBurger = 20000 * burger;

            banyakburger.setText("x" + jumlahBurger);
            hargaburger.setText("Rp " + String.valueOf(totalHargaBurger));
        }
        banyakhotdog = findViewById(R.id.banyakpesanan2);
        hargahotdog = findViewById(R.id.hargapesanan2);

        if (hotdog >= 0) {
            String jumlahHotdog = String.valueOf(hotdog);
            int totalHargaHotdog = 18000 * hotdog;

            banyakhotdog.setText("x" + jumlahHotdog);
            hargahotdog.setText("Rp " + String.valueOf(totalHargaHotdog));
        }
        if(hotdog >=0 || burger >=0){
            int val = hotdog + burger;
            int total = hotdog * 18000 + burger * 20000;
            itemTotalVal.setText(String.valueOf(val));
            totalHarga.setText(String.valueOf(total));
        }
    }
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(BURGER_KEY, burger);
        editor.putInt(HOTDOG_KEY, hotdog);
        editor.apply();
    }
}
