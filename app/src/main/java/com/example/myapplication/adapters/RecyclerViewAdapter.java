package com.example.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Hero> mData;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Hero> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hero_row_item, parent, false);

        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_occupation.setText(mData.get(position).getWork());

        // for the image
        String url = mData.get(position).getImage().getSm();
        Picasso.get().load(url).into(holder.imageView_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_name;
        private TextView textView_occupation;
        private ImageView imageView_thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_name = itemView.findViewById(R.id.hero_name);
            textView_occupation = itemView.findViewById(R.id.hero_occupation);
            imageView_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
