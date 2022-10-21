package com.example.profileui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChattingActivity extends AppCompatActivity {
    TextView nameUser, message, repMess;
    RoundedImageView circleImageView;
    AppCompatImageView back;
    ImageView buttonSend;
    EditText inputMess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

//        Nav
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.mess);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mess:
                        startActivity(new Intent(getApplicationContext(),MessengerActivity.class));
                        overridePendingTransition(0, 0);
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

        Intent intent = getIntent();
        String nd1 = (String)intent.getSerializableExtra("ten");
        String nd2 = (String)intent.getSerializableExtra("noidung");
        int nd3 = (Integer) intent.getSerializableExtra("anhdaidien");

        nameUser = (TextView) findViewById(R.id.nameUser);
        message = (TextView) findViewById(R.id.message);
        circleImageView = (RoundedImageView) findViewById(R.id.circleImageView);
        nameUser.setText(nd1);
        message.setText(nd2);
        circleImageView.setImageResource(nd3);

        back = (AppCompatImageView) findViewById(R.id.imageBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChattingActivity.this, MessengerActivity.class);
                startActivity(intent);
            }
        });


        buttonSend = (ImageView) findViewById(R.id.sendMess);
        repMess = (TextView) findViewById(R.id.rep);
        inputMess = (EditText) findViewById(R.id.inputMess);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repMess.setText(inputMess.getText());
                repMess.setVisibility(View.VISIBLE);
                inputMess.setText("");
            }
        });


    }


}