package com.example.nicolaipc.hinh;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Danhsach_Activity extends AppCompatActivity {

    final String DATABASE_NAME = "dbHinh.sqlite";
    SQLiteDatabase database;

    ListView listView;
    ArrayList<Hinh> list;
    AdapterHinh adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_);

        addControls();
        readData();
    }

    private void readData() {
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM tbHinh",null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            byte[] img = cursor.getBlob(2);
            list.add(new Hinh(_id, name, img));
        }
        adapter.notifyDataSetChanged();
    }

    private void addControls() {
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new AdapterHinh(this, list);
        listView.setAdapter(adapter);
    }
}
