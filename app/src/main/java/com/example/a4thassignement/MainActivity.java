package com.example.a4thassignement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    EditText editText2;
    EditText editText3;
    StatePreserver statePreserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statePreserver = new StatePreserver();

        // Get views
        this.buttonToggle = findViewById(R.id.buttonToggle);
        this.editText = findViewById(R.id.editText);
        this.editText2 = findViewById(R.id.editText2);
        this.editText3 = findViewById(R.id.editText3);


        // Add views that need their disabled state to be preserved
        // for demo purposes only editText field 1 and 3 are added
        statePreserver.addView(editText);
        statePreserver.addView(editText3);


        // toggle editText on and off
        buttonToggle.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                // for demo purposes all the view's state's are toggled but only two of those
                // preserve state.
                toggleViewState(!editText.isFocusable(), editText);
                toggleViewState(!editText2.isFocusable(), editText2);
                toggleViewState(!editText3.isFocusable(), editText3);
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

    // Disables or enables view
    private void toggleViewState(Boolean state, View view) {
        view.setFocusable(state);
        view.setFocusableInTouchMode(state);
        view.setEnabled(state);
    }
}
