package pl.pjatk.smb1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import pl.pjatk.smb1.database.DatabaseHandler;
import pl.pjatk.smb1.models.Product;
import pl.pjatk.smb1.adapters.ProductsAdapter;

public class ProductListActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list2);

       this.bind_list();
    }

    public void goToAdd(View v) {
        Intent i = new Intent(this, AddProductActivity.class);
        startActivity(i);
    }

    private void bind_list() {
        ListView yourListView = (ListView) findViewById(R.id.listView);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Product> list = db.Get_Products();
        yourListView.setAdapter(new ProductsAdapter(this, list));
        db.close();
    }
}
