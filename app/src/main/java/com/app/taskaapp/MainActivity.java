package com.app.taskaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;
    private  TextView wifeNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.hello_name);
        nameTextView.setText("No, My Wife Said, My Name Is Spondon");

        wifeNameTextView = findViewById(R.id.wife_name);
        wifeNameTextView.setText("Her Name Is: Khatune Rokaia Jannat");
    }


}