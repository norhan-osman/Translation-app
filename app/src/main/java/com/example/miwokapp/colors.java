package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colors extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<word> WordsList = new ArrayList<word>();

        WordsList.add(new word(getString(R.string.english_color_red),getString(R.string.miwok_color_red),R.drawable.color_red,R.raw.rot));
        WordsList.add(new word(getString(R.string.english_color_green),getString(R.string.miwok_color_green),R.drawable.color_green,R.raw.grun));
        WordsList.add(new word(getString(R.string.english_color_brown),getString(R.string.miwok_color_brown),R.drawable.color_brown,R.raw.braun));
        WordsList.add(new word(getString(R.string.english_color_gray),getString(R.string.miwok_color_gray),R.drawable.color_gray,R.raw.grau));
        WordsList.add(new word(getString(R.string.english_color_black),getString(R.string.miwok_color_black),R.drawable.color_black,R.raw.schwarz));
        WordsList.add(new word(getString(R.string.english_color_white),getString(R.string.miwok_color_white),R.drawable.color_white,R.raw.weiss));
        WordsList.add(new word(getString(R.string.english_color_dustyyellow),getString(R.string.miwok_color_dustyyellow),R.drawable.color_dusty_yellow,R.raw.blond));
        WordsList.add(new word(getString(R.string.english_color_mustardyellow),getString(R.string.miwok_color_mustardyellow),R.drawable.color_mustard_yellow,R.raw.gelb));

        WordAdapter itemsAdapter = new WordAdapter(this, WordsList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long l) {
                releaseMediaPlayer();
                word w = WordsList.get(position);
                mMediaPlayer = MediaPlayer.create(colors.this,w.getResuourceAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}