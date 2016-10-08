package pl.pjatk.smb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
