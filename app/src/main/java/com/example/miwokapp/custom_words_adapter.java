package com.example.miwokapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class custom_words_adapter extends ArrayAdapter<custom_words> {
    public custom_words_adapter(Activity context, ArrayList<custom_words> WordsList) {
        super(context, 0, WordsList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ListItemView = convertView;

        if ( ListItemView == null ){
            ListItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_saved_translates,parent,false);

        }
        custom_words currentWord = getItem(position);
        TextView germanTranslate = ListItemView.findViewById(R.id.GermanText);
        TextView englishTranslate = ListItemView.findViewById(R.id.EnglishText);
        germanTranslate.setText(currentWord.getmGermanTranslate());
        englishTranslate.setText(currentWord.getEnglishTranslate());

        return ListItemView;
    }

}
