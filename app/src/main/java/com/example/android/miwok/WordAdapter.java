package com.example.android.miwok;


import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Harsha on 07-01-2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.colorResourceId=colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        final Word w=getItem(position);

        TextView miwokWord=(TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(w.getMiwokTranslation());

        TextView englishWord=(TextView)listItemView.findViewById(R.id.default_text_view);
        englishWord.setText(w.getDefaultTranslation());

        ImageView imageView=(ImageView)listItemView.findViewById(R.id.image);
        if (w.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(w.getImageId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View TextContainer=listItemView.findViewById(R.id.text_container);
                int color = ContextCompat.getColor(getContext(),colorResourceId);
        TextContainer.setBackgroundColor(color);
        return listItemView;
    }

}
