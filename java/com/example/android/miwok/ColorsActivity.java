package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<word > words = new ArrayList<word>();

        words.add(new word("red","wetetti",R.drawable.color_red));
        words.add(new word("green","chokokki",R.drawable.color_green));
        words.add(new word("brown","takaakki",R.drawable.color_brown));
        words.add(new word("gray","topoppi",R.drawable.color_gray));
        words.add(new word("black","kululli",R.drawable.color_black));
        words.add(new word("white","kelelli",R.drawable.color_white));
        words.add(new word("dusty yellow","topiis",R.drawable.color_dusty_yellow));
        words.add(new word("mustard yellow","chiwitte",R.drawable.color_mustard_yellow));


        WordAdapter adapter =
                new WordAdapter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
