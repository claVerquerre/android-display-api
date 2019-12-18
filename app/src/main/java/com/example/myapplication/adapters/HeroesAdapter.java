package com.example.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.HeroesModel;
import com.example.myapplication.utils.OnItemPhotoClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.MyViewHolder> {
    private final List<HeroesModel> heroesModelList;
    private final Context mContext;
    private final int viewType;
    private static OnItemPhotoClickListener onItemClickedListener;


    public HeroesAdapter(Context context, List<HeroesModel> heroesModelList, int viewType) {
        this.mContext = context;
        this.heroesModelList = heroesModelList;

        // this variable indicate the type of display
        // 0 : list
        // 1 : grid
        this.viewType = viewType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.heroes_list_item, parent, false);
        }
        else {
            view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.heroes_grid_item, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        final HeroesModel data = heroesModelList.get(position);

        if (data.getImage().getSm() != null && !data.getImage().getSm().trim().isEmpty()){
            Picasso.get().load(data.getImage().getSm())
                    .placeholder(R.drawable.loading_shape)
                    .into(myViewHolder.iv_myImage);
        } else {
            myViewHolder.iv_myImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.loading_shape));
        }

        myViewHolder.tv_myText.setText(data.getName());

        // display more information in list view
        if (viewType == 0) {
            myViewHolder.hero_desc.setText(data.getBiography().getFullName());
            myViewHolder.hero_publisher.setText(data.getBiography().getPublisher());
        }

        myViewHolder.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickedListener != null) {
                    onItemClickedListener.onItemClick(data);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroesModelList.size();
    }


    public static void setOnItemClickedListener(OnItemPhotoClickListener onItemClickedListener) {
        HeroesAdapter.onItemClickedListener = onItemClickedListener;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_myImage;
        private TextView tv_myText, hero_desc, hero_publisher;
        private CardView line;

        MyViewHolder(View view) {
            super(view);

            iv_myImage = view.findViewById(R.id.iv_myImage);
            tv_myText = view.findViewById(R.id.tv_myText);
            hero_desc = view.findViewById(R.id.hero_desc);
            hero_publisher = view.findViewById(R.id.hero_publisher);
            line = view.findViewById(R.id.line);
        }
    }
}