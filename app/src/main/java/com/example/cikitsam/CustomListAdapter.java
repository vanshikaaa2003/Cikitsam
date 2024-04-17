package com.example.cikitsam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public CustomListAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_list, parent, false);

        TextView textView = rowView.findViewById(R.id.listItemTextView);
        textView.setText(values.get(position));

        return rowView;
    }
}
