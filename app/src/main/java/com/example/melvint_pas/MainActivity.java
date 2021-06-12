package com.example.melvint_pas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView datalist;
    ArrayList<Model> list;
    DataAdapter dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datalist = findViewById(R.id.rv_datalist);
        populateList();
        dataAdapter = new DataAdapter(this, list);
        datalist.setAdapter(dataAdapter);
        datalist.setItemAnimator(new DefaultItemAnimator());
        datalist.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void populateList() {
        list = new ArrayList<>();
        list.add(new Model("Putri", R.drawable.avatar1));
        list.add(new Model("Rizky", R.drawable.avatar2));
        list.add(new Model("Mamen", R.drawable.avatar3));
        list.add(new Model("Andika", R.drawable.avatar4));
        list.add(new Model("Melvin", R.drawable.avatar5));
        list.add(new Model("Nanik", R.drawable.avatar6));
        list.add(new Model("Dava", R.drawable.avatar6));
        list.add(new Model("Iqbal", R.drawable.avatar2));
        list.add(new Model("Programmer", R.drawable.avatar5));
        list.add(new Model("Keyla", R.drawable.avatar4));
        list.add(new Model("java", R.drawable.avatar1));


    }
}