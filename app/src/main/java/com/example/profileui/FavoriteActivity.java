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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    ArrayList<Favorite> listFavo= new ArrayList<>();
    FavoriteAdapter favoListViewAdapter;
    ListView listViewFavo;
    TextView nameSong, nameSinger;
    ImageView button;
    AppCompatImageView back;

    int position;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.favorite);

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

                        return true;
                }
                return false;
            }
        });




        listFavo.add(new Favorite(1, "Nơi này có anh","Sơn Tùng M-TP", R.raw.noinaycoanh));
        listFavo.add(new Favorite(2, "Waiting for you","MONO", R.raw.waitingforyou));
        listFavo.add(new Favorite(3, "Gác lại âu lo","Da LAB - Miu Lê", R.raw.gaclaiaulo));
        listFavo.add(new Favorite(4, "Chuyện đôi ta","Emcee L, Muội", R.raw.chuyendoita));
        listFavo.add(new Favorite(5, "Ánh sao và bầu trời","T.R.I", R.raw.anhsaovabautroi));
        listFavo.add(new Favorite(6, "Nàng thơ","Hoàng Dũng", R.raw.nangtho));
        listFavo.add(new Favorite(7, "Yêu 5","Rhymastic", R.raw.yeu5));
        listFavo.add(new Favorite(8, "Đành phải buông tay","Đỗ Hải Đăng", R.raw.danhphaibuongtay));
        listFavo.add(new Favorite(9, "Vì anh đâu có biết","Madihu - Vũ", R.raw.vianhdaucobiet));
        listFavo.add(new Favorite(10, "3107","W/n - DuongG - Nâu", R.raw.ba107));

        favoListViewAdapter = new FavoriteAdapter(listFavo);
        listViewFavo = findViewById(R.id.listFavorite);
        listViewFavo.setAdapter((ListAdapter) favoListViewAdapter);


        nameSong = (TextView) findViewById(R.id.nameSong);
        nameSinger = (TextView) findViewById(R.id.singer);
        button = (ImageView) findViewById(R.id.buttonplay);
        mediaPlayer = MediaPlayer.create(FavoriteActivity.this, listFavo.get(position).getFile());
        listViewFavo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(FavoriteActivity.this, listFavo.get(i).getFile());
                nameSong.setText(listFavo.get(i).getNameSong());
                nameSinger.setText(listFavo.get(i).getSinger());
                button.setImageResource(R.drawable.paused);
                mediaPlayer.start();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    button.setImageResource(R.drawable.play);
                }
                else{
                    mediaPlayer.start();
                    button.setImageResource(R.drawable.paused);
                }

            }
        });

        back = (AppCompatImageView) findViewById(R.id.imageBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoriteActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}