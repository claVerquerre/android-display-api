package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.activities.HeroActivity;
import com.example.myapplication.model.Hero;
import com.example.myapplication.utils.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Hero> mData;

    public RecyclerViewAdapter(Context mContext, List<Hero> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.hero_row_item, parent, false);

        return new MyViewHolder(view);
        /* viewHolder.view_container.setOnClickListener(view1 -> {

            Intent i = new Intent(mContext, HeroActivity.class);
            i.putExtra("hero_name", mData.get(viewHolder.getAdapterPosition()).getName());
            i.putExtra("hero_powerstats", mData.get(viewHolder.getAdapterPosition()).getPowerstats());
            i.putExtra("hero_biography", mData.get(viewHolder.getAdapterPosition()).getBiography());
            i.putExtra("hero_appearance", mData.get(viewHolder.getAdapterPosition()).getAppearance());
            i.putExtra("hero_work", mData.get(viewHolder.getAdapterPosition()).getWork());
            i.putExtra("hero_image", mData.get(viewHolder.getAdapterPosition()).getImage());

            mContext.startActivity(i);
        });

        return viewHolder; */
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(mData);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hero_name)
        TextView textView_name;

        @BindView(R.id.hero_occupation)
        TextView textView_occupation;

        @BindView(R.id.thumbnail)
        ImageView imageView_thumbnail;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Hero hero) {
            textView_name.setText(hero.getName());
            textView_occupation.setText(hero.getWork());
            ImageUtils.loadImage(imageView_thumbnail, hero.getImage());
        }
    }
}
