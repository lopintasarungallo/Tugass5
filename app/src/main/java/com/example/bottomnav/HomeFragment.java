package com.example.bottomnav;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHeroes = view.findViewById(R.id.rvHeroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecycleList();
        return view;
    }

    private void showRecycleList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListAdapter listAdapter = new ListAdapter(list);
        rvHeroes.setAdapter(listAdapter);

        listAdapter.setOnItemClickCallback(new ListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Intent intent = new Intent(getActivity(), Detail.class);
                intent.putExtra("hero_data", data);
//                intent.putExtra("name", data.getName());
//                intent.putExtra("genre", data.getGenre());
//                intent.putExtra("detail", data.getDetail());
//                intent.putExtra("photo", data.getPhoto());
                startActivity(intent);
            }
        });
    }




}
