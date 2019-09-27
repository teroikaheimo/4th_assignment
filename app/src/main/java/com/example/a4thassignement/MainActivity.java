package com.example.a4thassignement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button buttonToggle;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonToggle = findViewById(R.id.buttonToggle);
        this.editText = findViewById(R.id.editText);

        buttonToggle.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                toggleEditTextField();
            }
        });
    }

    // Disables or enables editText field.
    private void toggleEditTextField() {
        boolean setState = !editText.isFocusable();
        this.editText.setFocusable(setState);
        this.editText.setFocusableInTouchMode(setState);
        this.editText.setEnabled(setState);
    }
}
