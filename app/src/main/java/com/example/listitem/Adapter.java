package com.example.listitem;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    final ArrayList<Product> listProduct;
    Adapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listProduct.get(position).productID;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.activity_item, null);
        } else viewProduct = convertView;

        Product product = (Product) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("%s", product.name));
        ((TextView) viewProduct.findViewById(R.id.infor)).setText(String.format("Giá: %s", product.infor));
        ((TextView) viewProduct.findViewById(R.id.amount)).setText(String.format("%d ", product.amount));
        ((ImageView) viewProduct.findViewById(R.id.imgProduct)).setBackgroundResource(Integer.parseInt(String.format("%d", product.imgView)));
        ((TextView) viewProduct.findViewById(R.id.add)).setText(String.format("%s", product.add));
        ((TextView) viewProduct.findViewById(R.id.delete)).setText(String.format("%s", product.delete));

        return viewProduct;
    }
}
