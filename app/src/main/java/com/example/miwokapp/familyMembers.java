package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class familyMembers extends AppCompatActivity {
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

        WordsList.add(new word(getString(R.string.english_family_father), getString(R.string.miwok_family_father), R.drawable.family_father, R.raw.vater));
        WordsList.add(new word(getString(R.string.english_family_mother), getString(R.string.miwok_family_mother), R.drawable.family_mother, R.raw.mutter));
        WordsList.add(new word(getString(R.string.english_family_son), getString(R.string.miwok_family_son), R.drawable.family_son, R.raw.sohn));
        WordsList.add(new word(getString(R.string.english_family_daughter), getString(R.string.miwok_family_daughter), R.drawable.family_daughter, R.raw.tochter));
        WordsList.add(new word(getString(R.string.english_family_olderborther), getString(R.string.miwok_family_olderborther), R.drawable.family_older_brother, R.raw.altererbruder));
        WordsList.add(new word(getString(R.string.english_family_youngerbrother), getString(R.string.miwok_family_youngerbrother), R.drawable.family_younger_brother, R.raw.jungerer_bruder));
        WordsList.add(new word(getString(R.string.english_family_oldersister), getString(R.string.miwok_family_oldersister), R.drawable.family_older_sister, R.raw.altererschwester));
        WordsList.add(new word(getString(R.string.english_family_youngersister), getString(R.string.miwok_family_youngersister), R.drawable.family_younger_sister, R.raw.jungere_schwester));
        WordsList.add(new word(getString(R.string.english_family_grandmother), getString(R.string.miwok_family_grandmother), R.drawable.family_grandmother, R.raw.oma));
        WordsList.add(new word(getString(R.string.english_family_grandfather), getString(R.string.miwok_family_grandfather), R.drawable.family_grandfather, R.raw.opa));

        WordAdapter itemsAdapter = new WordAdapter(this, WordsList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                word w = WordsList.get(position);
                mMediaPlayer = MediaPlayer.create(familyMembers.this, w.getResuourceAudioId());
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