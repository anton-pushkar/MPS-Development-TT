package models;

public class AirplaneCharacteristics {
    private double maxSpeed;
    private double speedChange;
    private double heightChange;
    private double courseChange;

    public AirplaneCharacteristics(double maxSpeed, double speedChange, double heightChange, double courseChange) {
        this.maxSpeed = maxSpeed;
        this.speedChange = speedChange;
        this.heightChange = heightChange;
        this.courseChange = courseChange;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getSpeedChange() {
        return speedChange;
    }

    public void setSpeedChange(double speedChange) {
        this.speedChange = speedChange;
    }

    public double getHeightChange() {
        return heightChange;
    }

    public void setHeightChange(double heightChange) {
        this.heightChange = heightChange;
    }

    public double getCourseChange() {
        return courseChange;
    }

    public void setCourseChange(double courseChange) {
        this.courseChange = courseChange;
    }

}
