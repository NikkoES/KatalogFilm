package com.dicoding.nikko.katalogfilm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dicoding.nikko.katalogfilm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMovieActivity extends AppCompatActivity {

    @BindView(R.id.image_backdrop)
    ImageView imageBackdrop;
    @BindView(R.id.txt_nama_movie)
    TextView txtNamaMovie;
    @BindView(R.id.txt_tanggal_movie)
    TextView txtTanggalMovie;
    @BindView(R.id.txt_deskripsi_movie)
    TextView txtDeskripsiMovie;

    String backdropPath, title, releaseDate, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Movie");

        setMovieData();
    }

    private void setMovieData(){
        backdropPath = getIntent().getStringExtra("backdrop");
        title = getIntent().getStringExtra("title");
        releaseDate = getIntent().getStringExtra("release_date");
        overview = getIntent().getStringExtra("overview");

        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w185"+backdropPath)
                .placeholder(R.drawable.no_image_icon)
                .into(imageBackdrop);
        txtNamaMovie.setText(title);
        txtTanggalMovie.setText(releaseDate);
        txtDeskripsiMovie.setText(overview);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
