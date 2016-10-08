package pl.pjatk.smb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }



    public void save(View v) {
        //TODO KW Obsluga
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
