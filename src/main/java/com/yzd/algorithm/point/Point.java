package com.yzd.algorithm.point;



import java.io.Serializable;
import java.util.Objects;

public class Point implements Serializable {

    private static final long serialVersionUID = 1L;

    private double lng;

    private double lat;

    public Point(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public Point() {
        super();
    }

    public double getLng() {
        return lng;
    }

    public Point setLng(double lng) {
        this.lng = lng;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public Point setLat(double lat) {
        this.lat = lat;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lng, lat);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return other.getLat() == lat && other.getLng() == lng;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Point{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
