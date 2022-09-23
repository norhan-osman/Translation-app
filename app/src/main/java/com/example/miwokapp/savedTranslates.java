package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class savedTranslates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_translates);

        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        final ArrayList<custom_words> WordsList = new ArrayList<custom_words>();

//        WordsList.add(new custom_words(getString(R.string.english_phrase_1),getString(R.string.miwok_phrase_1),R.raw.where_are_you_going));

        custom_words_adapter itemsAdapter = new custom_words_adapter(this, WordsList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        TextView GermanText = findViewById(R.id.GermanText);
        GermanText.setText(currentuser);

    }


}
