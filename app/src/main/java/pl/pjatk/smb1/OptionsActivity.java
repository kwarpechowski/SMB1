package pl.pjatk.smb1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

public class OptionsActivity extends DefaultActivity {

    private SharedPreferences sharedPref;
    private Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sw = (Switch) findViewById(R.id.switch1);

        boolean isDarkMode = sharedPref.getBoolean(getString(R.string.darkMode), false);
        sw.setChecked(isDarkMode);
    }



    public void save(View v) {

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(getString(R.string.darkMode), sw.isChecked());
        editor.commit();


        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
