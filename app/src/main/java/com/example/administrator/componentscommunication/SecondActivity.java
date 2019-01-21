package com.example.administrator.componentscommunication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = this.getIntent().getExtras();
        String s = bundle.getString("data_string");
        int i = bundle.getInt("data_int");
        char c = bundle.getChar("data_char");
        String str=s+"+"+String.valueOf(i)+"+"+c;

        new AlertDialog.Builder(SecondActivity.this)
                .setTitle("Communication")
                .setMessage(str)
                .setCancelable(true)
                .show();
    }
}
