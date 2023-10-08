package com.example.mainactivity;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileReader {
    private List<String> lines;
    private Random random;

    public FileReader(InputStream inputStream) {
        lines = new ArrayList<>();
        random = new Random();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String randomSen() {
        if (lines.isEmpty()) {
            return "No data available";
        }
        int num = random.nextInt(lines.size());
        return lines.get(num);
    }
}
