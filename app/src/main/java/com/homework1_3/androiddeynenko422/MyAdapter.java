package com.homework1_3.androiddeynenko422;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<Map<String, String>> {
    private OnDeleteListener deleteListener;
    private List<Map<String, String>> simpleAdapterContent;

    public MyAdapter(@NonNull Context context, OnDeleteListener deleteListener, List<Map<String, String>> simpleAdapterContent) {
        super(context, 0, simpleAdapterContent);
        this.deleteListener = deleteListener;
        this.simpleAdapterContent = simpleAdapterContent;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,
                    parent, false);
        }
        convertView.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteListener.onDelete(position);
            }
        });
        Map<String, String> entry = simpleAdapterContent.get(position);
        TextView title = convertView.findViewById(R.id.textItem1);
        title.setText(entry.get(MainActivity.TITLE));
        TextView subtitle = convertView.findViewById(R.id.textItem2);
        subtitle.setText(entry.get(MainActivity.SUBTITLE));
        return convertView;
    }

    interface OnDeleteListener {
        void onDelete(int position);
    }
}
