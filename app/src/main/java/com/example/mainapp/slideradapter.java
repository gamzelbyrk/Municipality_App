package com.example.mainapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class slideradapter extends RecyclerView.Adapter<slideradapter.sliderviewholder>{

    private List<slideritem> slideritems;
    private ViewPager2 viewPager2;

     slideradapter(List<slideritem> slideritems, ViewPager2 viewpager) {
        this.slideritems = slideritems;
        this.viewPager2 = viewpager;
    }

    @NonNull
    @NotNull
    @Override
    public sliderviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new sliderviewholder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull sliderviewholder holder, int position) {
        holder.setimage(slideritems.get(position));
        if (position == slideritems.size()- 2)
            viewPager2.post(runnable);

    }

    @Override
    public int getItemCount() {
        return slideritems.size();
    }

    class sliderviewholder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

         sliderviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageslide);
        }

        void setimage(slideritem slideritem){
            imageView.setImageResource(slideritem.getImage());
        }

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideritems.addAll(slideritems);
            notifyDataSetChanged();

        }
    };
}
