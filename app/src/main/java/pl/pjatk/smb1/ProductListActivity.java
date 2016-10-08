package pl.pjatk.smb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list2);

       this.bind_list();
        this.bind_add();
    }

    private void bind_add() {
        final Button button = (Button) findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ProductListActivity.this, AddProductActivity.class);
                startActivity(i);
            }
        });

    }

    private void bind_list() {
        ListView yourListView = (ListView) findViewById(R.id.listView);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Product> list = db.Get_Products();
        yourListView .setAdapter(new ProductsAdapter(this, list));
        db.close();
    }
}
