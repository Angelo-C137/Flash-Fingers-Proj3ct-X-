package com.example.mainactivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mainactivity.GameLogic_Single;
import com.example.mainactivity.R;

public class SinglePlayerActivity extends AppCompatActivity {
    private EditText userInput;
    private TextView displayText;
    private GameLogic_Single gameLogic;
    private int resourceId; // Add this variable to store the resource ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        // Initialize the EditText and TextView
        userInput = findViewById(R.id.editTextUserInput); // Replace with your EditText ID
        displayText = findViewById(R.id.textViewDisplay); // Replace with your TextView ID

        // Get the resource ID based on the category (e.g., R.raw.random)
        resourceId = R.raw.random; // Replace with the appropriate resource ID

        // Create an instance of GameLogic_Single with the EditText, TextView, and resourceId
        gameLogic = new GameLogic_Single(userInput, displayText, resourceId);

        // Call the startGame method to set up the game logic
        gameLogic.startGame();
    }
}
