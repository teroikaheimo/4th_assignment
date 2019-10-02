package com.example.a4thassignement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/*
* Create an application which shows a splash screen when starting.
* The screen shows the name of the application and the logo of the application in the middle
* of the screen. The splash screen lasts for 3,5 seconds before moving on.

The next screen, which is the main screen of the application, consists of a EditText and a Button.
* The button enables/disables the EditText.

When the phone orientation changes from vertical to horizontal (or horizontal to vertical)
* the text inputted in the EditText stays the same. Also the EditText stays enabled or disabled
* after the orientation change.

After this implement a general solution of your choice to save the state of the views in your
* activity. Meaning that you are not hardcoding the views when saving the states but instead
* somehow iterating through all necessary views used for state.
* */

public class MainActivity extends AppCompatActivity {
    Button buttonToggle;
    EditText editText;
    StatePreserver statePreserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statePreserver = new StatePreserver();

        // Get views
        this.buttonToggle = findViewById(R.id.buttonToggle);
        this.editText = findViewById(R.id.editText);

        // Add views that need their state to be preserved
        statePreserver.addView(editText);

        // toggle editText on and off
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
        super.onSaveInstanceState(outState);
        // Saves view state after rotation etc.
        this.statePreserver.saveViewsState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        // restores views state after rotation etc.
        this.statePreserver.restoreViewsState(savedState);
    }

    // Disables or enables editText field.
    private void toggleEditTextField(Boolean setState) {
        this.editText.setFocusable(setState);
        this.editText.setFocusableInTouchMode(setState);
        this.editText.setEnabled(setState);
    }
}
