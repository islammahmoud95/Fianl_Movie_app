package com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes.Review;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Islam MaHmoud on 9/4/2016.
 */
public class Review_Data {
    private String id;
    private String author;
    private String content;

    public Review_Data() {

    }

    public Review_Data(JSONObject trailer) throws JSONException {
        this.id = trailer.getString("id");
        this.author = trailer.getString("author");
        this.content = trailer.getString("content");
    }

    public String getId() { return id; }

    public String getAuthor() { return author; }

    public String getContent() { return content; }
}

