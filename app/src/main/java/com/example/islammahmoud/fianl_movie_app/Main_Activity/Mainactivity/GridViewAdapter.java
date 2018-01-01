package com.example.islammahmoud.fianl_movie_app.Main_Activity.Mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.islammahmoud.fianl_movie_app.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Islam MaHmoud on 8/18/2016.
 */
public class GridViewAdapter extends BaseAdapter {
    private final Context context;
    private LayoutInflater inflator;
    private final MovieData movie =new  MovieData();
    private List<MovieData> ob_movie;

    public GridViewAdapter(Context mcontext, ArrayList<MovieData> objects) {

        context = mcontext;
        inflator=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ob_movie=objects;
    }
    public Context getContext() {
        return context;
    }


    public void add(MovieData object) {
        synchronized (movie) {
            ob_movie.add(object);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return ob_movie.size();
    }
    public void clear() {
        synchronized (movie) {
            ob_movie.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return ob_movie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<MovieData> data) {
        clear();
        for (MovieData movies : data) {
            add(movies);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        viewimage viewimages;
        if (view == null) {
            view = inflator.inflate(R.layout.fragment_items, viewGroup, false);
            viewimages = new viewimage(view);
            view.setTag(viewimages);
        }

        final MovieData movie = (MovieData) getItem(position);

        String image_url = "http://image.tmdb.org/t/p/w185" + movie.getImage();

        viewimages = (viewimage) view.getTag();

        Picasso.with(getContext()).load(image_url).into(viewimages.imageView);
        viewimages.titleView.setText(movie.getTitle());

        return view;
    }

    public static class viewimage {
        public final ImageView imageView;
        public final TextView titleView;

        public viewimage(View view) {
            imageView = (ImageView) view.findViewById(R.id.ImageViwe);
            titleView = (TextView) view.findViewById(R.id.title_items);
        }
    }
}
