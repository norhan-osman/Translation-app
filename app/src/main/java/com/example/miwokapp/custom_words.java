package com.example.miwokapp;

public class custom_words {

    private String mEnglishTransate ;
    private String mGermanTranslate;
    private String mUserid;
    public  custom_words(String EnglishTransate , String GermanTranslate , String Userid){
        mEnglishTransate =  EnglishTransate;
        mGermanTranslate = GermanTranslate;
        mUserid = Userid;
    }
    public String getEnglishTranslate(){
        return mEnglishTransate;
    }
    public String getmGermanTranslate(){
        return mGermanTranslate;
    }
    public String getUserId(){
        return mUserid;
    }

}
