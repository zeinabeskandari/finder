package com.example.finder;

import android.widget.ImageView;

public class movie_class {
    String image,movieName,directorName,productDate,summary;
    public movie_class(String movieName,String directorName,String productDate,String summary,String image){
        this.movieName=movieName;
        this.directorName=directorName;
        this.productDate=productDate;
        this.summary=summary;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getProductDate() {
        return productDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
