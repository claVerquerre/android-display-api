package com.example.myapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.HeroesModel;
import com.squareup.picasso.Picasso;

/**
 * Activity to display the detail of an hero.
 */
public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.detail_fragment,container, false);


        ImageView imageView = rootView.findViewById(R.id.detail_hero_picture);
        TextView textView_name = rootView.findViewById(R.id.detail_hero_name);
        TextView textView_fullname = rootView.findViewById(R.id.detail_full_name);
        TextView textView_publisher = rootView.findViewById(R.id.detail_publisher);
        TextView textView_intelligence = rootView.findViewById(R.id.detail_intelligence);
        TextView textView_strength = rootView.findViewById(R.id.detail_strength);
        TextView textView_speed = rootView.findViewById(R.id.detail_speed);
        TextView textView_durability = rootView.findViewById(R.id.detail_durability);
        TextView textView_power = rootView.findViewById(R.id.detail_power);
        TextView textView_combat = rootView.findViewById(R.id.detail_combat);

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            if (bundle.containsKey("hero")) {
                final HeroesModel hero = (HeroesModel) bundle.getSerializable("hero");

                Picasso.get().load(hero.getImage().getSm())
                        .placeholder(R.drawable.loading_shape)
                        .into(imageView);

                textView_name.setText(hero.getName());

                String fullname = "Fullname : " + hero.getBiography().getFullName();
                textView_fullname.setText(fullname);

                String publisher = "Publisher : " + hero.getBiography().getPublisher();
                textView_publisher.setText(publisher);

                String intelligence = "Intelligence : " + hero.getPowerstats().getIntelligence();
                textView_intelligence.setText(intelligence);

                String strength = "Strength : " + hero.getPowerstats().getStrength();
                textView_strength.setText(strength);

                String speed = "Speed : " + hero.getPowerstats().getSpeed();
                textView_speed.setText(speed);

                String durability = "Durability : " + hero.getPowerstats().getDurability();
                textView_durability.setText(durability);

                String power = "Power : " + hero.getPowerstats().getPower();
                textView_power.setText(power);

                String combat = "Combat : " + hero.getPowerstats().getCombat();
                textView_combat.setText(combat);
            }
        }
        return rootView;
    }
}