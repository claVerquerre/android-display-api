package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.activities.HeroActivity;
import com.example.myapplication.model.Hero;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Hero> mData;
    private RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Hero> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // request option for glide
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.hero_row_item, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, HeroActivity.class);
                i.putExtra("hero_name", mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("hero_powerstats", mData.get(viewHolder.getAdapterPosition()).getPowerstats());
                i.putExtra("hero_biography", mData.get(viewHolder.getAdapterPosition()).getBiography());
                i.putExtra("hero_appearance", mData.get(viewHolder.getAdapterPosition()).getAppearance());
                i.putExtra("hero_work", mData.get(viewHolder.getAdapterPosition()).getWork());
                i.putExtra("hero_image", mData.get(viewHolder.getAdapterPosition()).getImage());

                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView_name.setText(mData.get(position).getName());
        holder.textView_occupation.setText(mData.get(position).getWork());

        // use Glide to set ImageView
        Glide.with(mContext)
                .load(mData.get(position).getImage())
                .apply(options)
                .into(holder.imageView_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView_name;
        TextView textView_occupation;
        ImageView imageView_thumbnail;

        // for the detail of a hero
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);

            textView_name = itemView.findViewById(R.id.hero_name);
            textView_occupation = itemView.findViewById(R.id.hero_occupation);
            imageView_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
