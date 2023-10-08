package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.random);
        button1 = findViewById(R.id.computer);
        button2 = findViewById(R.id.medicine);
        button3 = findViewById(R.id.anime);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass the resource ID for the first button's text file
                openActivity3(R.raw.random);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass the resource ID for the second button's text file
                openActivity3(R.raw.computer);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass the resource ID for the third button's text file
                openActivity3(R.raw.medicine);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass the resource ID for the fourth button's text file
                openActivity3(R.raw.anime);
            }
        });
    }

    public void openActivity3(int resourceId) {
        Intent intent = new Intent(this, com.example.mainactivity.MainActivity3.class);
        intent.putExtra("FILE_ID", resourceId); // Pass the resource ID as an extra
        startActivity(intent);
    }
}
