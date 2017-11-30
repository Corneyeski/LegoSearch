package com.example.alanv.legosearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SearchBoxes extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    ProgressBar pbSearch;
    EditText textSearch;
    ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_boxes);

        pbSearch = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        textSearch = findViewById(R.id.textSearch);
        search = findViewById(R.id.search);

        Box studies = new Box();

       /* RecyclerView recyclerView = findViewById(R.id.recyclerView);
        BoxAdapter adapter = new BoxAdapter(studies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        studies.loadData(this, R.raw.studies);
        adapter.notifyDataSetChanged();*/
    }

    @Override
    public void onClick(View view) {

    }
}
