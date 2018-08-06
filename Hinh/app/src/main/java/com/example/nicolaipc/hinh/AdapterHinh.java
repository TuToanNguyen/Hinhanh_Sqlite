package com.example.nicolaipc.hinh;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHinh extends BaseAdapter{
    Activity context;
    ArrayList<Hinh> list;

    public AdapterHinh(Activity context, ArrayList<Hinh> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.adapter_hinh, null);
        ImageView img = (ImageView) row.findViewById(R.id.img);
        TextView id = (TextView) row.findViewById(R.id.id);
        TextView name = (TextView) row.findViewById(R.id.name);

        final Hinh hinh = list.get(position);
        id.setText(hinh._id + "");
        name.setText(hinh.name);

        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(hinh.img, 0, hinh.img.length);
        img.setImageBitmap(bmHinhDaiDien);

        return row;
    }
}
