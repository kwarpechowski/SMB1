package pl.pjatk.smb1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

/**
 * Created by kamilw on 08.10.2016.
 */
public class DefaultActivity extends AppCompatActivity {


    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDarkMode = sharedPref.getBoolean(getString(R.string.darkMode), false);

        if(isDarkMode) {
            RelativeLayout rl = (RelativeLayout) findViewById(R.id.mainLayout);
            rl.setBackgroundColor(Color.GRAY);
        }
    }
}
