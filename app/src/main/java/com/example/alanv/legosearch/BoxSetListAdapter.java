package com.example.alanv.legosearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by jlopez on 28/11/2017.
 */

public class BoxSetListAdapter extends RecyclerView.Adapter<BoxSetListAdapter.ViewHolder>{

    private BoxList list;

    public BoxSetListAdapter(BoxList list) {
        super();
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView idBox, nameV, partsV, realeasedV;
        ImageView boxImage;

        ViewHolder(View view) {
            super(view);
            idBox = view.findViewById(R.id.idBox);
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
        Box box = list.getResults()[position];

        Context context = holder.idBox.getContext();
        holder.nameV.setText(box.name);
        holder.idBox.setText(box.id.toString());
        holder.partsV.setText(box.parts);
        holder.realeasedV.setText(box.released.toString());
        Picasso.with(context).load(box.urlImage).into(holder.boxImage);
    }

    @Override
    public int getItemCount() {
        return list.getCount();
    }
}
