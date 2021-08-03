package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        RatingBar rbStars = rowView.findViewById(R.id.rbStars);
        TextView tvSingers = rowView.findViewById(R.id.tvSingers);
        ImageView newImg = rowView.findViewById(R.id.ivNew);

        // Obtain the Android Version information based on the position
        Song currentObj = songList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentObj.getTitle());
        tvYear.setText(String.valueOf(currentObj.getYearReleased()));
        rbStars.setRating(currentObj.getStars());
        tvSingers.setText(currentObj.getSingers());
        newImg.setImageResource(R.drawable.new_image);

        if (currentObj.getYearReleased() >= 2019) {
            newImg.setVisibility(View.VISIBLE);
        } else {
            newImg.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}
