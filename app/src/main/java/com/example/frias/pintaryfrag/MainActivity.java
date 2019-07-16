package com.example.frias.pintaryfrag;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Frag fragmento = (Frag) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }
}
