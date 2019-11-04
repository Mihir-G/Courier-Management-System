package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<word> {
    public WordAdapter(Activity context, ArrayList<word> words) {
        super(context,0, words);
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        word currentword=getItem(position);
        TextView miwokTextView=(TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentword.getMiwokTranslation());

        TextView defaultTextView=(TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentword.getDefaultTranslation());

        ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);
        if(currentword.hasImage()) {
            imageView.setImageResource(currentword.getImageResourceId());
             imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
