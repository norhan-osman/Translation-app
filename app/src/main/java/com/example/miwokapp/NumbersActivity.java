package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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

        WordsList.add(new word(getString(R.string.english_number_one), getString(R.string.miwok_number_one), R.drawable.number_one, R.raw.eins));
        WordsList.add(new word(getString(R.string.english_number_two), getString(R.string.miwok_number_two), R.drawable.number_two, R.raw.zwei));
        WordsList.add(new word(getString(R.string.english_number_three), getString(R.string.miwok_number_three), R.drawable.number_three, R.raw.drei));
        WordsList.add(new word(getString(R.string.english_number_four), getString(R.string.miwok_number_four), R.drawable.number_four, R.raw.vier));
        WordsList.add(new word(getString(R.string.english_number_five), getString(R.string.miwok_number_five), R.drawable.number_five, R.raw.funf));
        WordsList.add(new word(getString(R.string.english_number_six), getString(R.string.miwok_number_six), R.drawable.number_six, R.raw.sechs));
        WordsList.add(new word(getString(R.string.english_number_seven), getString(R.string.miwok_number_seven), R.drawable.number_seven, R.raw.sieben));
        WordsList.add(new word(getString(R.string.english_number_eight), getString(R.string.miwok_number_eight), R.drawable.number_eight, R.raw.acht));
        WordsList.add(new word(getString(R.string.english_number_nine), getString(R.string.miwok_number_nine), R.drawable.number_nine, R.raw.neun));
        WordsList.add(new word(getString(R.string.english_number_ten), getString(R.string.miwok_number_ten), R.drawable.number_ten, R.raw.zehn));


        WordAdapter itemsAdapter = new WordAdapter(this, WordsList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                word w = WordsList.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, w.getResuourceAudioId());
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
