package com.example.alanv.legosearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchBoxes extends AppCompatActivity {

    public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.ViewHolder>{

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameV;
            TextView partsV;
            TextView realeasedV;
            ImageView boxImage;

            ViewHolder(View view) {
                super(view);
                nameV = view.findViewById(R.id.nameV);
                partsV = view.findViewById(R.id.partsV);
                realeasedV = view.findViewById(R.id.realeasedV);
                boxImage = view.findViewById(R.id.boxImage);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_view_box, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_boxes);

        Box studies = new Box();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        BoxAdapter adapter = new BoxAdapter(studies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        studies.loadData(this, R.raw.studies);
        adapter.notifyDataSetChanged();
    }
}
