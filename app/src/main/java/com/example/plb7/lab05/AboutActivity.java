package com.example.plb7.lab05;
/** Paige Brinks, plb7
 * Lab 05
 *
 * 10/7/2016
 *
 * Build an application with two activities
 * About Activity - display about message
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }
}
