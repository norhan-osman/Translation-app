package com.example.miwokapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnSignOut;
    FirebaseAuth auth;
    FirebaseUser user;
    ProgressDialog PD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        PD = new ProgressDialog(this);
        PD.setMessage(getString(R.string.loading_message));
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);
        btnSignOut = (Button) findViewById(R.id.sign_out_button);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            auth.signOut();
            FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
            }
            };
         }
        });


        TextView numberCategory = findViewById(R.id.NumbersLabel);
        numberCategory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sendTo = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(sendTo);
            }
        });


    }
    public void  openColors( View view) {
        Intent sendTo = new Intent(this,colors.class);
        startActivity(sendTo);
    }
    public void  openFamily( View view) {
        Intent sendTo = new Intent(this,familyMembers.class);
        startActivity(sendTo);
    }
    public void  openPhrases( View view) {
        Intent sendTo = new Intent(this,Phrases.class);
        startActivity(sendTo);
    }
    public void  openSaved( View view) {
        Intent sendTo = new Intent(this,savedTranslates.class);
        startActivity(sendTo);
    }


    @Override    protected void onResume() {
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        super.onResume();
    }


    public void openTranslation(View view) {
        Intent intent=new Intent(this,TranslateActivity.class);
        startActivity(intent);
    }
    public void clickimage(View view) {
        Intent intent= new Intent(this , ImageActivity.class);
        startActivity(intent);
    }

}
