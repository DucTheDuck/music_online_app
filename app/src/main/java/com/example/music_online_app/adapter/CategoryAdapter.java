package com.example.music_online_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.music_online_app.OnItemClickListener;
import com.example.music_online_app.OnlineAlbumActivity;
import com.example.music_online_app.R;
import com.example.music_online_app.models.CategoryModels;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{
    private List<CategoryModels> categoryModels;
    private Context context;
    private OnItemClickListener listener;

    public CategoryAdapter(Context context, List<CategoryModels> categoryModels){
        this.context = context;
        this.categoryModels = categoryModels;
    }

    public CategoryAdapter(
            Context context,
            List<CategoryModels> categoryModels,
            OnItemClickListener onItemClickListener){
        this.context = context;
        this.categoryModels = categoryModels;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item_recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(categoryModels.get(position), listener);
//
//        String image = categoryModels.get(position).getCoverUrl();
//        String name = categoryModels.get(position).getName();
//
//        holder.textView.setText(name);
//        Glide.with(holder.imageView).load(image)
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
//                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return categoryModels.size() ;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.name_text_view);
            imageView = itemView.findViewById(R.id.cover_image_view);


        }
        public void bind(final CategoryModels item, final OnItemClickListener listener) {
            textView.setText(item.getName());
            Glide.with(imageView).load(item.getCoverUrl())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    .into(imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }
}
