package com.example.kevin.shogigame.android_shogi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.kevin.shogigame.R;

/**
 * Created by Kevin on 4/23/2016.
 */
public class Rules extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_page);
    }

    /**
     * Takes user to Main activity.
     * @param view
     */
    public void backToStart(View view) {
        onBackPressed();
    }
}
