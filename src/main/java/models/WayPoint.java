package models;

import java.util.Objects;

public class WayPoint {
    private double height;
    private double speed;
    private double latitude;
    private double longitude;

    public WayPoint(double height, double speed, double latitude, double longitude) {
        this.height = height;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "WayPoint{"
                + "height=" + height
                + ", speed=" + speed
                + ", latitude=" + latitude
                + ", longitude=" + longitude
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WayPoint point = (WayPoint) o;
        return Double.compare(point.height, height) == 0 && Double.compare(point.speed, speed) == 0
                && Double.compare(point.latitude, latitude) == 0
                && Double.compare(point.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, speed, latitude, longitude);
    }
}
