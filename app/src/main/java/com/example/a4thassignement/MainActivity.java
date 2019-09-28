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
                toggleEditTextField(!editText.isFocusable());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (!this.editText.isFocusable()) {
            outState.putBoolean("editTextDisabled", true);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        if (savedState.getBoolean("editTextDisabled")) {
            toggleEditTextField(false);
        }
    }

    // Disables or enables editText field.
    private void toggleEditTextField(Boolean setState) {
        this.editText.setFocusable(setState);
        this.editText.setFocusableInTouchMode(setState);
        this.editText.setEnabled(setState);
    }
}
