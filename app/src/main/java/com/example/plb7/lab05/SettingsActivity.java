package com.example.plb7.lab05;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Admin on 10/7/2016.
 */

public class SettingsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
