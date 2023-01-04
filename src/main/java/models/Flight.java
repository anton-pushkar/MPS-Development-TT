package models;

import java.util.List;

public class Flight {
    private Long number;
    private List<WayPoint> wayPoints;
    private List<TemporaryPoint> passedPoints;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<WayPoint> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(List<WayPoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public List<TemporaryPoint> getPassedPoints() {
        return passedPoints;
    }

    public void setPassedPoints(List<TemporaryPoint> passedPoints) {
        this.passedPoints = passedPoints;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "number=" + number
                + ", wayPoints=" + wayPoints
                + ", passedPoints=" + passedPoints
                + '}';
    }
}
