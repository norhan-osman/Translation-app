package com.example.miwokapp;

public class word {
    private String mDefaultTranslation ;
    private String mMiwokTranslation;
    private int imageResourceId;
    private int mAudioId;
    public  word(String defaultTranslate , String miwokTranslation , int audioId){
        mDefaultTranslation =  defaultTranslate;
        mMiwokTranslation = miwokTranslation;
        mAudioId = audioId;
    }
    public word (String defaultTranslate , String miwokTranslation , int mImageresourceId  , int audioId){
        mDefaultTranslation =  defaultTranslate;
        mMiwokTranslation = miwokTranslation;
        imageResourceId = mImageresourceId;
        mAudioId =  audioId;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public int getResuourceAudioId(){
        return mAudioId;
    }


}
