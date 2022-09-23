package com.example.miwokapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WordAdapter extends ArrayAdapter<word> {
    public WordAdapter(Activity context, ArrayList<word> WordsList) {
        super(context, 0, WordsList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ListItemView = convertView;

        if ( ListItemView == null ){
            ListItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);

        }
        word currentWord = getItem(position);
        TextView miwokText = ListItemView.findViewById(R.id.miwok_text_view);
        TextView dafaultText = ListItemView.findViewById(R.id.default_text_view);
        ImageView iconImage = ListItemView.findViewById(R.id.item_image);
        miwokText.setText(currentWord.getMiwokTranslation());
        dafaultText.setText(currentWord.getDefaultTranslation());
        iconImage.setImageResource(currentWord.getImageResourceId());


        return ListItemView;
    }
}
