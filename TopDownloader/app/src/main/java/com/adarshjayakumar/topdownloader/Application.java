package com.adarshjayakumar.topdownloader;

/**
 * Created by adarsh on 3/16/2016.
 */
public class Application {
    private String title;
    private String artist;
    private String releaseDate;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {

        return "Title :"+getTitle()+"\n"+"Artist : "+getArtist()+"\nReleaseDate : "+getReleaseDate();
    }
}
