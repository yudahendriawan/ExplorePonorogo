package com.yudahendriawan.exploreponorogo.food;

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
import com.yudahendriawan.exploreponorogo.coffee.CoffeeAdapter;
import com.yudahendriawan.exploreponorogo.model.Food;
import com.yudahendriawan.exploreponorogo.util.Key;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.RecyclerViewAdapter> {

    Context context;
    private List<Food> foods;
    private ItemClickListener itemClickListener;

    public FoodAdapter(Context context, List<Food> foods, ItemClickListener itemClickListener) {
        this.context = context;
        this.foods = foods;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new RecyclerViewAdapter(view, itemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        holder.binding(foods.get(position));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder {


        ImageView imageView;
        ItemClickListener itemClickListener;
        TextView name;

        public RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            imageView = itemView.findViewById(R.id.image_food);
            name = itemView.findViewById(R.id.name_food);


        }

        public void binding(final Food food) {
            Glide.with(context).load(food.getImgUrl()).into(imageView);

            name.setText(food.getName());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailFood.class);
                    intent.putExtra(Key.INTENT_DATA, food);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
