package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import androidx.room.Room;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TranslateActivity extends AppCompatActivity {
    myDatabase database ;
    private TextView viewtext;
    private EditText enttext;
    private Button translate;
    String editViewString ;
    String Url  = "https://api.mymemory.translated.net/get?q=" +editViewString + "&langpair=en|ger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        viewtext = (TextView) findViewById(R.id.viewword);
        enttext = (EditText) findViewById(R.id.entword);
        //translate = (TextView) findViewById(R.id.translate);
    }

    public void translate(View view) {
        OkHttpClient client = new OkHttpClient();
       String editViewString = enttext.getText().toString();
        if (editViewString.matches("")){
            viewtext.setText(getString(R.string.cantTranslateemptyValue));
        }
        else{
            //targetText = editViewString;
            String Url  = "https://api.mymemory.translated.net/get?q=" +editViewString + "&langpair=en|ger";
            Request request = new Request.Builder()
                    .url(Url)
                    .build();
           client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    call.cancel();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    final String myResponse = response.body().string();

                    TranslateActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                JSONObject json = new JSONObject(myResponse);
                                viewtext.setText(json.getJSONObject("responseData").getString("translatedText"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }
    }
    public void saveTranslate(View view){
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String GermanText = viewtext.getText().toString();
        String EnglishText = enttext.getText().toString();
        if (EnglishText.matches("")) {
            viewtext.setText(getString(R.string.error_message));
            }else {
            database = Room.databaseBuilder(getApplicationContext() , myDatabase.class , "translationsdb").allowMainThreadQueries().build();
            User user = new User();
            user.setData(EnglishText,GermanText,currentuser);
            database.userDao().insertAll(user);
            Toast.makeText(getApplicationContext() , "Translation Saved Succesfuly " , Toast.LENGTH_SHORT).show();
            }
        }

    }
