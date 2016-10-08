package pl.pjatk.smb1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToLst(View v) {
        Intent i = new Intent(this, ProductListActivity.class);
        startActivity(i);
    }

    public void goToSettings(View v) {
        Intent i = new Intent(this, OptionsActivity.class);
        startActivity(i);
    }
}
