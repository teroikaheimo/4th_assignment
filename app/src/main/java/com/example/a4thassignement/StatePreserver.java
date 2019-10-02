package com.example.a4thassignement;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/* Preserves views disabled state for focusable, focusableInTouchMode and enabled.

Usage
1. add views to list.
2. call saveViewsState in your activity's onSaveInstanceState method.
3. call restoreViewsState in your activity's onRestoreInstanceState method.

* */
public class StatePreserver {
    ArrayList<View> views;

    public StatePreserver() {
        views = new ArrayList<>();
    }

    public void addView(View view) {
        views.add(view);
    }

    public boolean removeView(View view) {
        return views.remove(view);
    }

    public void saveViewsState(Bundle outState) {
        for (View view : views) {
            // IF view state is disabled. Save state as true with index as state name.
            if (!view.isFocusable()) {
                outState.putBoolean(Integer.toString(views.indexOf(view)), true);
            }
        }
    }

    public void restoreViewsState(Bundle savedState) {
        for (View view : views) {
            // IF state was saved as disabled then restore view to that state.
            if (savedState.getBoolean(Integer.toString(views.indexOf(view)))) {
                setViewState(view);
            }
        }
    }

    private void setViewState(View view) {
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        view.setEnabled(false);
    }
}
