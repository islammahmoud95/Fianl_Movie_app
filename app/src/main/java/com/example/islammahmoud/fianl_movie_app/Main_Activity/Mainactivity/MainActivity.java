package com.example.islammahmoud.fianl_movie_app.Main_Activity.Mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes.Detaile_Activity;
import com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes.Detailes_Fragment;
import com.example.islammahmoud.fianl_movie_app.R;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.Callback{

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.movie_detail_container) != null) {
            mTwoPane = true;
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.movie_detail_container, new Detailes_Fragment(),
                                Detailes_Fragment.TAG)
                        .commit();
            }
        } else {
            mTwoPane = false;
        }
    }
    @Override
    public void onItemSelected(MovieData movie) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(Detailes_Fragment.DETAIL_MOVIE, movie);

            Detailes_Fragment fragment = new Detailes_Fragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment, Detailes_Fragment.TAG)
                    .commit();
        } else {
            Intent intent = new Intent(this, Detaile_Activity.class)
                    .putExtra(Detailes_Fragment.DETAIL_MOVIE, movie);
            startActivity(intent);
        }
    }
}
