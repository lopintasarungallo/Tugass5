package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    private TextView tvJudul, tvGenre, tvDescription;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tvJudul);
        tvGenre = findViewById(R.id.tvGenre);
        tvDescription = findViewById(R.id.tvDescription);
        photo = findViewById(R.id.photo);


        Hero heroan = getIntent().getParcelableExtra("hero_data");


        tvJudul.setText(heroan.getName());
        tvDescription.setText(heroan.getDetail());
        tvGenre.setText(heroan.getGenre());
        photo.setImageResource(heroan.getPhoto());
//
//        String nama = getIntent().getStringExtra("name");
//        String detail = getIntent().getStringExtra("detail");
//        String genre = getIntent().getStringExtra("genre");
//        int foto = getIntent().getIntExtra("photo", 0);
//
//        tvJudul.setText(nama);
//        tvGenre.setText(genre);
//        tvDescription.setText(detail);
//        photo.setImageResource(foto);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(heroan.getName());
//        actionBar.setLogo(R.drawable.ic_baseline_arrow_back_24);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);



    }




//    private void setActionBarTitle(String title){
//        getSupportActionBar().setTitle(title);
//    }
}