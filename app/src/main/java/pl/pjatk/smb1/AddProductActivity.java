package pl.pjatk.smb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private AddProductActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        this.bindSave();
        activity = this;
    }

    private void bindSave() {
        final Button button = (Button) findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db = new DatabaseHandler(activity);
                Product n = new Product();

                EditText name   = (EditText)findViewById(R.id.name);
                n.setName(name.getText().toString());
                db.Add_Product(n);

                Intent i = new Intent(AddProductActivity.this, ProductListActivity.class);
                startActivity(i);
            }
        });
    }
}
