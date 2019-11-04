package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ArrayList<word > words = new ArrayList<word>();

        words.add(new word("Where are you going?","minto wuksus"));
        words.add(new word("What is your name?","tinne oyaase'ne"));
        words.add(new word("My same is...","oyaaset..."));
        words.add(new word("How are you feeling?","michekses?"));
        words.add(new word("I am feeling good.","kuchi achit"));
        words.add(new word("Are you coming?","eenes'aa?"));
        words.add(new word("Yes,I'm coming.","hee'eenem'"));
        words.add(new word("I'm coming.","eenem"));
        words.add(new word("Lets go.","yoowutis"));
        words.add(new word("Come here.","enni'nem"));

        WordAdapter adapter =
                new WordAdapter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
