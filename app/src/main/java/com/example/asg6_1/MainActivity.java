package com.example.asg6_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DbHandler dbh;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh = new DbHandler(this);

        Button regBtn = findViewById(R.id.register);
        TextView viewRegs = findViewById(R.id.viewRegistrations);
        EditText nameText = findViewById(R.id.name);
        EditText mobText = findViewById(R.id.mob);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String mob = mobText.getText().toString();
                Boolean check = dbh.insertData(name, mob);

                if (check == true) {
                    Toast.makeText(MainActivity.this, "Data inserted Successfully!", Toast.LENGTH_SHORT).show();
                    nameText.setText("");
                    mobText.setText("");
                } else
                    Toast.makeText(MainActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });

        viewRegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewRegistrationsActivity.class);
                startActivity(i);
            }
        });
    }
}