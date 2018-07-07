package com.example.android.gotinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private long v;
    @SerializedName("locations")
    @Expose
    private List<String> locations = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param id
     * @param v
     * @param locations
     * @param name
     * @param slug
     */
    public Datum(String id, String slug, String name, long v, List<String> locations) {
        super();
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.v = v;
        this.locations = locations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Datum withId(String id) {
        this.id = id;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Datum withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }

    public Datum withV(long v) {
        this.v = v;
        return this;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Datum withLocations(List<String> locations) {
        this.locations = locations;
        return this;
    }

}