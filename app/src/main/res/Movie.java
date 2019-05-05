package com.latihan.dicoding.moviecataloguedicoding3.Item;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    private String title;
    private String date;
    private String description;
    private String posterLink;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie(JSONObject object) {
        try{
            this.id = object.getInt("id");
            this.title = object.getString("title");
            this.posterLink = object.getString("poster_path");
            this.description = object.getString("overview");
            this.date = object.getString("release_date");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
