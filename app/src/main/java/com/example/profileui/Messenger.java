package com.example.profileui;

import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class Messenger {
    int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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
