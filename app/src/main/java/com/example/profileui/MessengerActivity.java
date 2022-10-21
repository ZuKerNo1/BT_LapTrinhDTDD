package com.example.profileui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessengerActivity extends AppCompatActivity {
    public static final String message1 = "com.example.myfirstapp.MESSAGE";
    ArrayList<Messenger> listMess= new ArrayList<>();
    MessAdapter messListViewAdapter;
    ListView listViewMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.mess);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mess:

                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(),FavoriteActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

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
        listViewMess.setAdapter(messListViewAdapter);

        listViewMess.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = listMess.get(i).getName();
                String context = listMess.get(i).getContent();
                int ava = listMess.get(i).getAvatar();
                Intent intent = new Intent(MessengerActivity.this, ChattingActivity.class);
                intent.putExtra("ten", name);
                intent.putExtra("noidung", context);
                intent.putExtra("anhdaidien", ava);
                startActivity(intent);
            }
        });

    }

}