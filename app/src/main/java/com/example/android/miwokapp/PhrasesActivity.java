package com.example.android.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);


        ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("where are you going?","minto wuksus?"));
        words.add(new Word("what is your name?","tinne oyaase'na"));
        words.add(new Word("My name is....","oyaaset"));
        words.add(new Word("how are you feeling","michakses"));
        words.add(new Word("i am feeling good","kuich achit"));
        words.add(new Word("are you coming?","eenes'aa?"));
        words.add(new Word("yes,i am coming","hee'eenem"));
        words.add(new Word("i am coming","eenem"));
        words.add(new Word("let's go","yoowuits"));
        words.add(new Word("come here","anni'nem"));


        WordAdapter adapter=new WordAdapter(this,words);

        ListView listView =findViewById(R.id.listItems);
        listView.setAdapter(adapter);

    }
}
