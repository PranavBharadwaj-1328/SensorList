package com.example.sensorlist;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class MySensorsAdapter extends ArrayAdapter<Sensor> {

    private int textViewResourceId;

    private static class ViewHolder {
        private TextView itemView;
    }

    public MySensorsAdapter(Context context, int textViewResourceId, List<Sensor> items) {
        super(context, textViewResourceId, items);
        this.textViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(textViewResourceId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Sensor item = getItem(position);

        if (item != null) {
            viewHolder.itemView.setText(item.getName());
        }

        return convertView;
    }
}


