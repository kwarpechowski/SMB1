package pl.pjatk.smb1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import pl.pjatk.smb1.data.DatabaseHandler;
import pl.pjatk.smb1.data.ProductsContract;
import pl.pjatk.smb1.models.Product;

public class ProductEditActivity extends DefaultActivity {

    private EditText name;
    private DatabaseHandler db;
    private int pId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        db = new DatabaseHandler(this);

        name = (EditText)findViewById(R.id.name);

        Intent i = getIntent();
        pId = i.getIntExtra(getString(R.string.product), 0);

        Cursor c = db.getById(pId);
        c.moveToFirst();

       name.setText(c.getString(c.getColumnIndex(ProductsContract.ProductEntry.KEY_NAME)));

    }

    public void update(View v) {

        ContentValues values = new ContentValues();
        values.put(ProductsContract.ProductEntry.KEY_NAME, name.getText().toString());
        getContentResolver().update(ProductsContract.ProductEntry.CONTENT_URI, values, ProductsContract.ProductEntry.KEY_ID+"="+pId, null);

        Intent i = new Intent(this, ProductListActivity.class);
        startActivity(i);
    }
}
