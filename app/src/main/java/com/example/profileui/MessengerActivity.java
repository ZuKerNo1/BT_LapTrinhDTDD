package com.example.profileui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MessengerActivity extends AppCompatActivity {

    ArrayList<Messenger> listMess= new ArrayList<>();
    MessAdapter messListViewAdapter;
    ListView listViewMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

//        Trở lại Home
        AppCompatImageView back = (AppCompatImageView) findViewById(R.id.imageBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessengerActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

//        Add danh sách mess
        listMess.add(new Messenger(1, R.drawable.sontung,"M-TP" , "Anh muốn mời em về làm việc với anh", "20:45 pm"));
        listMess.add(new Messenger(2, R.drawable.tranthanh,"Trấn Thành" ,"Đi nhậu không em ?", "19:23 pm"));
        listMess.add(new Messenger(3, R.drawable.hariwon,"HariWon" ,"Em có biết chồng chị đang ở đâu không ?", "19:20 pm"));

        messListViewAdapter = new MessAdapter(listMess);
        listViewMess = findViewById(R.id.listMess);
        listViewMess.setAdapter((ListAdapter) messListViewAdapter);
    }
}