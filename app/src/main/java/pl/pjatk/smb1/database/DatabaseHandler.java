package pl.pjatk.smb1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import pl.pjatk.smb1.models.Product;

/**
 * Created by kamilw on 08.10.2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "productsManager";
    private static final String TABLE_CONTACTS = "products";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ACTIVE = "active";

    private final ArrayList<Product> product_list = new ArrayList<Product>();

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT, " + KEY_ACTIVE + " INTEGER)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public void Add_Product(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_ACTIVE, product.isActive());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public void Update_Product(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_ACTIVE, product.isActive());
        db.update(TABLE_CONTACTS, values, "id="+product.getId(), null);
        Log.i("SMB", "update " + product.isActive());
        db.close();
    }

    public void Remove_Product(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, "id="+product.getId(), null);
        db.close();
    }

    public ArrayList<Product> Get_Products() {
        try {
            product_list.clear();

            String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " ORDER BY id DESC";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Product product = new Product();
                    product.setId(Integer.parseInt(cursor.getString(0)));
                    product.setName(cursor.getString(1));

                    int t = Integer.parseInt(cursor.getString(2));
                    product.setActive((t == 1));
                    product_list.add(product);
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return product_list;
        } catch (Exception e) {
        }

        return product_list;
    }

    public Product getProduct(int pId) {
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS + " WHERE id=" + pId;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            Product product = new Product();
            product.setId(Integer.parseInt(cursor.getString(0)));
            product.setName(cursor.getString(1));

            int t = Integer.parseInt(cursor.getString(2));
            product.setActive((t == 1));
            return product;
        } else {
            return null;
        }

    }
}
