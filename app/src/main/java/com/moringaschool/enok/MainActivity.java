package com.moringaschool.enok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.moringaschool.enok.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mBodies = new ArrayList<>();
    private ArrayList<String> mLanguages =  new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);



        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, mTitles, mBodies, mLanguages);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initQuestions();
    }

    private void initQuestions(){
        mTitles.add("Unable to install python3");
        mBodies.add("My ubuntu linux is refusing to install python3");
        mLanguages.add("Python");

        mTitles.add("Unable to install Java");
        mBodies.add("My ubuntu linux is refusing to install JVM");
        mLanguages.add("Java");

        mTitles.add("Unable to install Node");
        mBodies.add("My ubuntu linux is refusing to install NodeJs");
        mLanguages.add("Javascript");

        mTitles.add("Unable to install JVM");
        mBodies.add("My ubuntu linux is refusing to install JVM");
        mLanguages.add("Java");

        mTitles.add("Unable to install python3");
        mBodies.add("My ubuntu linux is refusing to install python3");
        mLanguages.add("Python");

        mTitles.add("Unable to install Java");
        mBodies.add("My ubuntu linux is refusing to install JVM");
        mLanguages.add("Java");

        mTitles.add("Unable to install Node");
        mBodies.add("My ubuntu linux is refusing to install NodeJs");
        mLanguages.add("Javascript");

        mTitles.add("Unable to install JVM");
        mBodies.add("My ubuntu linux is refusing to install JVM");
        mLanguages.add("Java");
    }
}