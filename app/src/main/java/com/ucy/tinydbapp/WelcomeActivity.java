package com.ucy.tinydbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back,clear;
    private TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        typeCasting();
        getSupportActionBar().hide();
    }

    private void typeCasting(){
        back = findViewById(R.id.button_back);
        clear = findViewById(R.id.button_clear);
        back.setOnClickListener(this);
        clear.setOnClickListener(this);

        tinyDB = new TinyDB(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.button_back:
                onBackPressed();
                break;
            case R.id.button_clear:
                //Delete data
                tinyDB.clear();
                Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
