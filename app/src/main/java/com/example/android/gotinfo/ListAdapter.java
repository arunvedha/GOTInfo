package com.example.android.gotinfo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {


    public ListAdapter(Context context, ArrayList<String> words) {
        super(context, 0, words);
    }

    public ListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        String currentString = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name_of_character);
        name.setText(currentString);

        return listItemView;
    }




}
