package com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes.Trailer;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Islam MaHmoud on 9/4/2016.
 */
public class TrailerData {
    private String id;
    private String key;
    private String name;
    private String site;
    private String type;

    public TrailerData() {

    }

    public TrailerData(JSONObject trailer) throws JSONException {
        this.id = trailer.getString("id");
        this.key = trailer.getString("key");
        this.name = trailer.getString("name");
        this.site = trailer.getString("site");
        this.type = trailer.getString("type");
    }

    public String getId() {
        return id;
    }

    public String getKey() { return key; }

    public String getName() { return name; }

    public String getSite() { return site; }

    public String getType() { return type; }
}