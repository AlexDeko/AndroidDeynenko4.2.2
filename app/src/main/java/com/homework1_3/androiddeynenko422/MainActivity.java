package com.homework1_3.androiddeynenko422;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnDeleteListener {

    public final static String TITLE = "title";
    public final static String SUBTITLE = "subtitle";
    List<Map<String, String>> simpleAdapterContent;
    BaseAdapter listContentAdapter;

    @Override
    public void onDelete(int position) {
        simpleAdapterContent.remove(position);
        listContentAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView list = findViewById(R.id.list);
        String[] content = prepareContent();
        listContentAdapter = createAdapter(content);
        list.setAdapter(listContentAdapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String text = list.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
    @NonNull
    private BaseAdapter createAdapter(String[] values) {
        simpleAdapterContent = new ArrayList<>();
        for (String value : values) {
            Map<String, String> row = new HashMap<>();
            row.put(TITLE, value);
            row.put(SUBTITLE, String.valueOf(value.length()));
            simpleAdapterContent.add(row);
        }
        return new MyAdapter(
                this,
                this,
                simpleAdapterContent
        );
    }
    @NonNull
    private String[] prepareContent() {
        return getString(R.string.large_text).split("\n\n");
    }
}