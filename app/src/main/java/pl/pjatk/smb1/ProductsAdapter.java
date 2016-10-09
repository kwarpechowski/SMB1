package pl.pjatk.smb1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.Switch;
import android.widget.TextView;

import pl.pjatk.smb1.ProductEditActivity;
import pl.pjatk.smb1.R;
import pl.pjatk.smb1.data.DatabaseHandler;
import pl.pjatk.smb1.data.ProductsContract;

/**
 * Created by kamilw on 08.10.2016.
 */
public class ProductsAdapter extends CursorAdapter {
    private Context ctx;
    private DatabaseHandler db;

    public ProductsAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        ctx = context;
        db = new DatabaseHandler(ctx);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(cursor.getString(cursor.getColumnIndex(ProductsContract.ProductEntry.KEY_NAME)));

        final int id = cursor.getInt(cursor.getColumnIndex(ProductsContract.ProductEntry.KEY_ID));


        Switch sw = (Switch) view.findViewById(R.id.switch1);
        sw.setChecked(cursor.getInt(cursor.getColumnIndex(ProductsContract.ProductEntry.KEY_ACTIVE)) == 1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ContentValues values = new ContentValues();
                values.put(ProductsContract.ProductEntry.KEY_ACTIVE, isChecked);
                db.UpdateById(values, id);

            }
        });

        Button btn = (Button) view.findViewById(R.id.remove);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.getContentResolver().delete(ProductsContract.ProductEntry.CONTENT_URI, ProductsContract.ProductEntry.KEY_ID+"="+id, null);
                swapCursor(db.getAll());
            }
        });


        Button editbtn = (Button) view.findViewById(R.id.edit);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, ProductEditActivity.class);
                i.putExtra(ctx.getString(R.string.product), id);
                ctx.startActivity(i);
            }
        });
    }
}