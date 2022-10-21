package com.example.profileui;

public class Favorite {
    public Favorite(int ID, String nameSong, String singer, Integer file) {
        this.ID = ID;
        this.nameSong = nameSong;
        this.singer = singer;
        this.file = file;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Integer getFile() {
        return file;
    }

    public void setFile(Integer file) {
        this.file = file;
    }

    int ID;
    String nameSong;
    String singer;
    Integer file;

}
