package com.example.islammahmoud.fianl_movie_app.Main_Activity.Detailes.Data;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Islam MaHmoud on 9/7/2016.
 */
public final class Utility {
    public static int isFavorited(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieContract.MovieEntry.CONTENT_URI,
                null,   // projection
                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " = ?", // selection
                new String[] { Integer.toString(id) },   // selectionArgs
                null    // sort order
        );
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }
private Utility(){}
}
