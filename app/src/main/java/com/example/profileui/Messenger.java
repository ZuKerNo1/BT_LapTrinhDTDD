package com.example.profileui;

import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class Messenger {
    int ID;
    int avatar;
    String name;
    String content;
    String time;

    public Messenger(int ID, int avatar, String name, String content, String time) {
        this.ID = ID;
        this.avatar = avatar;
        this.name = name;
        this.content = content;
        this.time = time;
    }

}
