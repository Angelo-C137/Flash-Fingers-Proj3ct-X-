package com.example.mainactivity;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;

import java.io.InputStream;
import java.util.Random;

public class GameLogic_Single {
    private EditText userInput; // Added EditText for user input
    private TextView displayText; // Added TextView for display
    private long startTimeMillis; // Track start time in milliseconds
    private Random random;
    private int mistakes;

    // Resource ID for the file to read
    private int resourceId;

    public GameLogic_Single(EditText userInput, TextView displayText, int resourceId) {
        this.userInput = userInput;
        this.displayText = displayText;
        this.random = new Random();
        this.mistakes = 0;
        this.resourceId = resourceId; // Set the resource ID
    }

    public void startGame() {
        // Set an OnEditorActionListener for the userInput EditText
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String input = userInput.getText().toString();

                    // Get a random sentence from the resource file
                    String randomSentence = getRandomSentenceFromResource();

                    // Update the displayText with the random sentence
                    displayText.setText(randomSentence);

                    // Calculate mistakes made
                    int mistakesMade = Checker(randomSentence, input);
                    displayText.append("\nMistakes made: " + mistakesMade);

                    // Calculate typing duration
                    long durationMillis = calculateDuration();
                    displayText.append("\nType duration: " + durationMillis / 1000 + " seconds");

                    // Clear the user input field
                    userInput.setText("");

                    return true;
                }
                return false;
            }
        });
    }

    private String getRandomSentenceFromResource() {
        // Read the resource file and return a random sentence
        InputStream inputStream = displayText.getResources().openRawResource(resourceId);
        FileReader fileReader = new FileReader(inputStream);
        return fileReader.randomSen();
    }

    public static int Checker(String output, String user1) {
        int len_output = output.length();
        int len_user1 = user1.length();
        int mistakes = 0;

        for (int i = 0; i < Math.min(len_output, len_user1); i++) {
            if (output.charAt(i) != user1.charAt(i)) {
                mistakes++;
            }
        }

        mistakes += Math.abs(len_output - len_user1);
        return mistakes;
    }

    public long calculateDuration() {
        // Calculate the typing duration in milliseconds
        if (startTimeMillis > 0) {
            long endTimeMillis = System.currentTimeMillis();
            return endTimeMillis - startTimeMillis;
        } else {
            return 0;
        }
    }
}
