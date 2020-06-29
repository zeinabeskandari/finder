package com.example.finder;

import android.widget.ImageView;

public class movie_class {
    String poster_path,title,overview;
    public movie_class(String poster_path,String title,String backdrop_path,String overview,String release_date){
        this.poster_path=poster_path;
        this.title=title;
        this.overview=overview;

    }



    public String getPoster_path() {
        return poster_path;
    }

    public String getTitle() {
        return title;
    }


    public String getOverview() {
        return overview;
    }


    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setOverview(String overview) {
        this.overview = overview;
    }


}
