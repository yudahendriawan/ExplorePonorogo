package com.yudahendriawan.exploreponorogo.coffee;

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
import com.yudahendriawan.exploreponorogo.R;
import com.yudahendriawan.exploreponorogo.model.Coffee;
import com.yudahendriawan.exploreponorogo.util.Key;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.RecyclerViewAdapter>  {

    Context context;
    private List<Coffee> coffees;
    private ItemClickListener itemClickListener;

    public CoffeeAdapter(Context context, List<Coffee> coffees, ItemClickListener itemClickListener) {
        this.context = context;
        this.coffees = coffees;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_coffee,parent,false);
        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
//        Coffee coffee = coffees.get(position);
//
//        Glide.with(context).load(coffee.getImgUrl()).into(holder.imageView);
//        holder.name.setText(coffee.getName());
        holder.binding(coffees.get(position));
    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        ItemClickListener itemClickListener;
        TextView name;

        public RecyclerViewAdapter(@NonNull View itemView, final ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            imageView = itemView.findViewById(R.id.image_coffee);
            name = itemView.findViewById(R.id.name_coffee);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(v,getAdapterPosition());
                }
            });
        }

        public void binding(final Coffee coffee){

            Glide.with(context).load(coffee.getImgUrl()).into(imageView);
            name.setText(coffee.getName());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailCoffee.class);
                    intent.putExtra(Key.INTENT_DATA, coffee);
                    v.getContext().startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
