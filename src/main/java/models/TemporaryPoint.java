package models;

import java.util.Objects;

public class TemporaryPoint {
    private double height;
    private double speed;
    private double latitude;
    private double longitude;
    private double course;

    public TemporaryPoint(double height, double speed,
                          double latitude, double longitude, double course) {
        this.height = height;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
        this.course = course;
    }

    public TemporaryPoint(double height, double speed, double latitude, double longitude) {
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

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TemporaryPoint that = (TemporaryPoint) o;
        return Double.compare(that.height, height) == 0 && Double.compare(that.speed, speed) == 0
                && Double.compare(that.latitude, latitude) == 0
                && Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, speed, latitude, longitude);
    }

    @Override
    public String toString() {
        return "TemporaryPoint{"
                + "height=" + height
                + ", speed=" + speed
                + ", latitude=" + latitude
                + ", longitude=" + longitude
                + ", course=" + course
                + '}';
    }
}
