package com.example.android.miwokapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goPhrases(View view) {
        Intent i =new Intent(this,PhrasesActivity.class);
        startActivity(i);

    }

    public void goFamilyMembers(View view) {
        Intent i =new Intent(this,FamilyMemberActivity.class);
        startActivity(i);
    }

    public void goNumbers(View view) {
        Intent i =new Intent(this,NumbersActivity.class);
        startActivity(i);
    }

    public void goColors(View view) {
        Intent i =new Intent(this,ColorsActivity.class);
        startActivity(i);
    }
}
