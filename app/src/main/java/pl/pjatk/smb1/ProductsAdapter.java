package pl.pjatk.smb1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kamilw on 08.10.2016.
 */
public class ProductsAdapter extends ArrayAdapter<Product> {
    private Context ctx;

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);

        ctx = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(product.getName());


        Switch sw = (Switch) convertView.findViewById(R.id.switch1);
        sw.setChecked(product.isActive());

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                product.setActive(isChecked);
                DatabaseHandler db = new DatabaseHandler(ctx);
                db.Update_Product(product);
                db.close();
            }
        });

        Button btn = (Button) convertView.findViewById(R.id.remove);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(ctx);
                remove(product);
                db.Remove_Product(product);
                db.close();
                notifyDataSetChanged();
            }
        });

        return convertView;

    }
}