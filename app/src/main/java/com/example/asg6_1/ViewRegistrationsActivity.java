package com.example.asg6_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewRegistrationsActivity extends AppCompatActivity {

    DbHandler dbh;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_registrations);

        Log.d("view", "Inside View Registrations Activity");

        dbh = new DbHandler(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Registration> allRegs = dbh.getAllRegistrations();

        recyclerViewAdapter = new RecyclerViewAdapter(ViewRegistrationsActivity.this, allRegs);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
