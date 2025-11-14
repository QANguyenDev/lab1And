package com.example.lab1_ph44183.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1_ph44183.Model.ModelCat;
import com.example.lab1_ph44183.R;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.MyViewHolder> {

    Context context;
    ArrayList<ModelCat> list;

    public CatAdapter(Context context, ArrayList<ModelCat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_cat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelCat modelCat = list.get(position);
        holder.tvIdCat.setText(String.valueOf(modelCat.getId_cat()));
        holder.tvCatName.setText(modelCat.getCatname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvIdCat, tvCatName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdCat = itemView.findViewById(R.id.tvIdCat);
            tvCatName = itemView.findViewById(R.id.tvCatName);
        }
    }

}
