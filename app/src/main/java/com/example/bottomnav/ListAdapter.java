package com.example.bottomnav;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Hero> listHero;

    public ListAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }

    private OnItemClickCallback onItemClickCallback;


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false);
        return  new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        Hero hero = listHero.get(position);
//        Glide.with(holder.itemView.getContext()).load(hero.getPhoto()).apply(new RequestOptions().override(55, 55));
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());
        holder.tvGenre.setText(hero.getGenre());
        holder.imgPhoto.setImageResource(hero.getPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getBindingAdapterPosition()));
            }
        });

    }


    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDetail, tvGenre;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.photo);
            tvName = itemView.findViewById(R.id.tvJudul);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvDetail = itemView.findViewById(R.id.tvDescription);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hero data);
    }
}
