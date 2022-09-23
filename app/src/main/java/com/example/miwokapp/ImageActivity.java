package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {
    private ImageView image;
    private ProgressDialog simpleWaitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        String URL = " https://image.shutterstock.com/image-photo/colorful-halftimbered-houses-miltenberg-historical-600w-1206450859.jpg" ;
        image =(ImageView) findViewById(R.id.imageView);
        new DownloadImage().execute(URL);

    }
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {




        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {

                InputStream input = new java.net.URL(imageURL).openStream();

                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {

            image.setImageBitmap(result);

        }
    }
}
