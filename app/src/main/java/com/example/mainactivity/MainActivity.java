package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity; // Use AppCompatActivity for AndroidX

import com.example.mainactivity.R;

public class MainActivity extends AppCompatActivity {
    private Button singlePlayerButton;
    private Button multiPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePlayerButton = findViewById(R.id.single_player);
        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        multiPlayerButton = findViewById(R.id.multi_player);
        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, com.example.mainactivity.MainActivity2.class);
        startActivity(intent);
    }
}
