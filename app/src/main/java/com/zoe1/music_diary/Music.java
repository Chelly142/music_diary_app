package com.zoe1.music_diary;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Music {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "artist")
    public String artist;
    @ColumnInfo(name = "rank")
    public String rank;
    @ColumnInfo(name = "category")
    public String category;
    @ColumnInfo(name = "image_url")
    public String image_url;

    public Music( String title, String artist, String image_url) {
        this.title = title;
        this.artist = artist;
        this.image_url = image_url;
        this.rank = "0";
        this.category="0";
    }
}
