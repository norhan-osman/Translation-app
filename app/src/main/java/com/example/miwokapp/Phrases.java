package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
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

        WordsList.add(new word(getString(R.string.english_phrase_1),getString(R.string.miwok_phrase_1),R.raw.where_are_you_going));
        WordsList.add(new word(getString(R.string.english_phrase_2),getString(R.string.miwok_phrase_2),R.raw.whats_your_name));
        WordsList.add(new word(getString(R.string.english_phrase_3),getString(R.string.miwok_phrase_3),R.raw.my_name_is));
        WordsList.add(new word(getString(R.string.english_phrase_4),getString(R.string.miwok_phrase_4),R.raw.how_are_you_feeling));
        WordsList.add(new word(getString(R.string.english_phrase_5),getString(R.string.miwok_phrase_5),R.raw.i_am_feeling_good));
        WordsList.add(new word(getString(R.string.english_phrase_6),getString(R.string.miwok_phrase_6),R.raw.areyoucoming));
        WordsList.add(new word(getString(R.string.english_phrase_7),getString(R.string.miwok_phrase_7),R.raw.yesi_am_coming));
        WordsList.add(new word(getString(R.string.english_phrase_8),getString(R.string.miwok_phrase_8),R.raw.i_am_coming));
        WordsList.add(new word(getString(R.string.english_phrase_9),getString(R.string.miwok_phrase_9),R.raw.lets_go));
        WordsList.add(new word(getString(R.string.english_phrase_10),getString(R.string.miwok_phrase_10),R.raw.come_here));


        WordAdapter itemsAdapter = new WordAdapter(this, WordsList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long l) {
                releaseMediaPlayer();
                word w = WordsList.get(position);
                mMediaPlayer = MediaPlayer.create(Phrases.this,w.getResuourceAudioId());
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