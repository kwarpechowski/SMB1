package pl.pjatk.smb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pl.pjatk.smb1.Model.Product;

public class ProductEditActivity extends DefaultActivity {

    private EditText name;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        name = (EditText)findViewById(R.id.name);

        Intent i = getIntent();
        int pId = i.getIntExtra("product", 0);

        DatabaseHandler db = new DatabaseHandler(this);
        product = db.getProduct(pId);
        db.close();

        name.setText(product.getName());

    }

    public void update(View v) {
        product.setName(name.getText().toString());
        DatabaseHandler db = new DatabaseHandler(this);
        db.Update_Product(product);
        db.close();

        Intent i = new Intent(this, ProductListActivity.class);
        startActivity(i);
    }
}
