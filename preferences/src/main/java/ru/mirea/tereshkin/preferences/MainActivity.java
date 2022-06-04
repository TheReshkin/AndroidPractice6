package ru.mirea.tereshkin.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText instInput;
    private TextView name1;
    private TextView inst;
    private SharedPreferences preferences;
    final String SAVED_NAME = "saved_name";
    final String SAVED_INSTITUTION = "saved_inst";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1 = findViewById(R.id.name);
        inst = findViewById(R.id.inst);
        nameInput = findViewById(R.id.name_input);
        instInput = findViewById(R.id.inst_input);
        preferences = getPreferences(MODE_PRIVATE);
    }
    public void onSaveText(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_NAME, nameInput.getText().toString());
        editor.putString(SAVED_INSTITUTION, instInput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    public void onLoadText(View view) {
        String name = preferences.getString(SAVED_NAME, "Empty");
        String institution = preferences.getString(SAVED_INSTITUTION, "Empty");
        name1.setText(name);
        inst.setText(institution);
    }
    public void onClickSave(View view){
        onSaveText(view);
    }

    public void onClickLoad(View view){
        onLoadText(view);
    }
}