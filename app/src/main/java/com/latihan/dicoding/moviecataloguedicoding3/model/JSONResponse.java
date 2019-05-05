package com.latihan.dicoding.moviecataloguedicoding3.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {

    @SerializedName("results")
    @Expose
    private Movie[] results = null;

    public Movie[] getResults() {
        return results;
    }
}