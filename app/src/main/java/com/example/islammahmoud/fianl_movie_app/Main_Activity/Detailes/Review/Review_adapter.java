package com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes.Review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.islammahmoud.fianl_movie_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Islam MaHmoud on 9/4/2016.
 */
public class Review_adapter  extends BaseAdapter

{

        private final Context context;
        private LayoutInflater inflator;
        private final Review_Data movie =new Review_Data();
        private List<Review_Data> ob_movie;

        public Review_adapter(Context mcontext, ArrayList<Review_Data> objects) {

        context = mcontext;
        inflator=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ob_movie=objects;
    }
    public Context getContext() {
        return context;
    }


    public void add(Review_Data object) {
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

    public void setData(List<Review_Data> data) {
        clear();
        for (Review_Data movies : data) {
            add(movies);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = inflator.inflate(R.layout.review_movies, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Review_Data review = (Review_Data) getItem(position);

        viewHolder = (ViewHolder) view.getTag();

        viewHolder.authorView.setText(review.getAuthor());
        viewHolder.contentView.setText(review.getContent());

        return view;
    }



    public static class ViewHolder {
        public final TextView authorView;
        public final TextView contentView;

        public ViewHolder(View view) {
            authorView = (TextView) view.findViewById(R.id.review_author);
            contentView = (TextView) view.findViewById(R.id.review_content);
        }
    }

}

