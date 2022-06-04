package ru.mirea.tereshkin.internalfilestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String fileName = "mirea.txt";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.out_text);
        String string = "Hello mirea!";
        writeContentToFile(string, fileName);
    }


    private void writeContentToFile(String content, String fileName) {
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTextFromFile(String fileName) {
        try (FileInputStream fis = openFileInput(fileName)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            return text;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void onClickShow(View view) {
        textView.setText(getTextFromFile(fileName));
    }
}