package pl.pjatk.smb1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pl.pjatk.smb1.database.DatabaseHandler;
import pl.pjatk.smb1.models.Product;

public class AddProductActivity extends DefaultActivity {

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
                n.setActive(true);
                db.Add_Product(n);

                Intent i = new Intent(AddProductActivity.this, ProductListActivity.class);
                startActivity(i);
            }
        });
    }
}
