package com.example.android.gotinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public LocationResponse() {
    }

    /**
     *
     * @param message
     * @param data
     */
    public LocationResponse(String message, List<Datum> data) {
        super();
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocationResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public LocationResponse withData(List<Datum> data) {
        this.data = data;
        return this;
    }

}



