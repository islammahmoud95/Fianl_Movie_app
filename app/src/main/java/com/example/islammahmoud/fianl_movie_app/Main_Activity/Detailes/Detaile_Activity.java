package com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.islammahmoud.fianl_movie_app.R;


public class Detaile_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaile);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(Detailes_Fragment.DETAIL_MOVIE,
                    getIntent().getParcelableExtra(Detailes_Fragment.DETAIL_MOVIE));

            Detailes_Fragment fragment = new Detailes_Fragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, fragment)
                    .commit();
        }
    }
}
