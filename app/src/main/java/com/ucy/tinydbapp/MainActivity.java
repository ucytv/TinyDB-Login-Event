package com.ucy.tinydbapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText nick, pass;
    private CheckBox remember;
    private Button login;
    private TinyDB tinyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Must be fullscreen!
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        typeCasting();
        getData();
        getSupportActionBar().hide();//This is important!
    }

    public void getData() {
        String loadNick = tinyDB.getString("nick");
        String loadPass = tinyDB.getString("pass");

        if (checkStatus(loadNick, loadPass))
            nextActivity();
        else
            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
    }

    public void typeCasting() {
        nick = findViewById(R.id.edit_nick);
        pass = findViewById(R.id.edit_pass);
        remember = findViewById(R.id.checkbox_remember);
        login = findViewById(R.id.button_login);
        login.setOnClickListener(this);

        tinyDB = new TinyDB(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_login) {
            getTextAndNext();

        }
    }

    public boolean checkStatus(String nick, String pass) {
        String myNick = "ucytv";
        String myPass = "followme";
        if (!TextUtils.isEmpty(nick) && !TextUtils.isEmpty(pass))
            return nick.equals(myNick) && pass.equals(myPass);
        else
            return false;
    }

    public void getTextAndNext() {
        String nickInfo = nick.getText().toString().trim();
        String passInfo = pass.getText().toString().trim();


        if (checkStatus(nickInfo, passInfo)) {
            if (remember.isChecked()) {
                //Save data
                tinyDB.putString("nick", nickInfo);
                tinyDB.putString("pass", passInfo);
            }else{
                clearEditor(); //To avoid bug and error
            }
            nextActivity();
        }else Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();

    }

    public void clearEditor() {
        tinyDB.clear();
        Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show();
    }

    private void nextActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
