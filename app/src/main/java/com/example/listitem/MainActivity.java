package com.example.listitem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> listProduct;
    Adapter productListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Áo hoodie","150000" , 1, R.drawable.aohoodie, "Add", "Delete"));
        listProduct.add(new Product(2, "Mũ bảo hiểm","100000" ,1, R.drawable.mubaohiem, "Add", "Delete"));
        listProduct.add(new Product(3, "Đèn ngủ","70000" , 1, R.drawable.denngu, "Add", "Delete"));
        listProduct.add(new Product(4, "Giày","250000" , 1, R.drawable.giay, "Add", "Delete"));
        listProduct.add(new Product(5, "Túi xách","300000" , 1, R.drawable.tuixach, "Add", "Delete"));

        productListViewAdapter = new Adapter(listProduct);
        listViewProduct = findViewById(R.id.listProduct);
        listViewProduct.setAdapter(productListViewAdapter);
        listViewProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Xác nhận !!!");
                builder.setMessage("Có muốn xóa sản phẩm này không ?");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        listProduct.remove(position);
                        listViewProduct.setAdapter(productListViewAdapter);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }


}