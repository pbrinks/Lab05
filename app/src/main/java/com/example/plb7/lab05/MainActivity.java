package com.example.plb7.lab05;
/** Paige Brinks, plb7
 * Lab 05
 * 10/7/2016
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private boolean preference = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        showPreferences();
    }

    private void showPreferences() {
        TextView preference = (TextView) findViewById(R.id.preference);
        preference.setText("Preference: " + prefs.getBoolean("preference", false));
    }

    /**
     * gotoAbout(), takes user to about activity
     */
    public void gotoAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * gotoSettings(), takes user to settings activity
     */
    public void gotoSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /** onCreateOptionsMenu(Menu menu)
     * Create menu
     * @param menu, triple dot menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    /** onOptionsItemSelected(MenuItem item)
     * when user selects about option in menu, take them to the selected activity
     * @param item, the menu option selected, here the only option is about
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // when user selects about, go to about page
        switch (item.getItemId()) {
            case R.id.about:
                gotoAbout();
                return true;
            case R.id.settings:
                gotoSettings();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("preference", preference);
        editor.commit();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        preference= prefs.getBoolean("preference", false);
        showPreferences();
    }
}
