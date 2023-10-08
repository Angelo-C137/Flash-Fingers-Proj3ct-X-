package com.example.mainactivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private TextView tvDisplayText;
    private TextView tvResultText; // Added TextView for result
    private EditText etUserInput;
    private Button btnSubmit;
    private Button btnStopTimer;
    private TextView tvTimer;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 2 * 60 * 1000; // Two minutes in milliseconds
    private FileReader fileReader;
    private List<String> userInputs = new ArrayList<>(); // To store user inputs
    private String currentSentence; // Store the current sentence being displayed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvDisplayText = findViewById(R.id.DisplayText);
        tvResultText = findViewById(R.id.ResultText); // Initialize the result text view
        etUserInput = findViewById(R.id.UserInput);
        btnSubmit = findViewById(R.id.button);
        btnStopTimer = findViewById(R.id.stopButton);
        tvTimer = findViewById(R.id.tvTimer);

        int resourceId = getIntent().getIntExtra("FILE_ID", 0);
        InputStream inputStream = getResources().openRawResource(resourceId);
        fileReader = new FileReader(inputStream);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user input
                String userInput = etUserInput.getText().toString();

                // Add the user input to the list
                userInputs.add(userInput);

                // Compare user input with the current displayed sentence
                if (userInput.equals(currentSentence)) {
                    // If user input matches the displayed sentence
                    // Show a "Correct" message in the result TextView
                    tvResultText.setText("Correct!");
                } else {
                    // If user input does not match the displayed sentence
                    // Show an "Incorrect" message in the result TextView
                    tvResultText.setText("Incorrect!");
                }

                // Clear the EditText for the next input
                etUserInput.setText("");

                // Read a new random string from the file using FileReader
                currentSentence = fileReader.randomSen();

                // Display the new string in the TextView
                tvDisplayText.setText(currentSentence);
            }
        });

        // ... (other code, including the count-down timer)
    }

    // ... (other methods)
}
