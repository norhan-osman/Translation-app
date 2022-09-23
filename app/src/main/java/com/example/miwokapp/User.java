package com.example.miwokapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "english_word")
    public String englishword;

    @ColumnInfo(name = "german_word")
    public String germanword;

    @ColumnInfo(name = "userId")
    public String userId;

    public void setData (String english , String german , String usrid){
        this.englishword = english ;
        this.germanword = german;
        this.userId = usrid;
    }
}

