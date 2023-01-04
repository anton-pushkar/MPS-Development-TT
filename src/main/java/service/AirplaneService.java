package service;

import models.Airplane;
import models.AirplaneCharacteristics;
import models.Flight;
import models.TemporaryPoint;
import models.WayPoint;

public class AirplaneService {

    public void changeHeight(Airplane airplane, WayPoint wayPoint,
                             AirplaneCharacteristics characteristics) {
        if (airplane.getPosition().getHeight() < wayPoint.getHeight()) {
            airplane.getPosition().setHeight(Math.min(airplane.getPosition()
                    .getHeight() + characteristics.getHeightChange(), wayPoint.getHeight()));
        }
        if (airplane.getPosition().getHeight() > wayPoint.getHeight()) {
            airplane.getPosition().setHeight(Math.max(airplane.getPosition()
                    .getHeight() - characteristics.getHeightChange(), wayPoint.getHeight()));
        }

    }

    public void changeSpeed(Airplane airplane, WayPoint wayPoint,
                            AirplaneCharacteristics characteristics) {
        if (airplane.getPosition().getSpeed() < wayPoint.getSpeed()) {
            airplane.getPosition().setSpeed(Math.min(airplane.getPosition()
                    .getSpeed() + characteristics.getSpeedChange(), wayPoint.getSpeed()));
        }
        if (airplane.getPosition().getSpeed() > wayPoint.getSpeed()) {
            airplane.getPosition().setSpeed(Math.max(airplane.getPosition()
                    .getSpeed() - characteristics.getSpeedChange(), wayPoint.getSpeed()));
        }

    }

    public void rotate(Airplane airplane, WayPoint wayPoint,
                       AirplaneCharacteristics characteristics, Flight flight) {
        double currentAngle = airplane.getPosition().getCourse();
        double angle = findAngle(airplane, wayPoint);
        while (currentAngle != angle) {
            if (currentAngle < angle) {
                if (currentAngle + characteristics.getCourseChange() < angle) {
                    currentAngle = currentAngle + characteristics.getCourseChange();
                    airplane.getPosition()
                            .setCourse(currentAngle + characteristics.getCourseChange());
                    TemporaryPoint point = createPoint(airplane);
                    flight.getPassedPoints().add(point);
                } else {
                    airplane.getPosition().setCourse(angle);
                    currentAngle = angle;
                    TemporaryPoint point = createPoint(airplane);
                    flight.getPassedPoints().add(point);
                }
            }

            if (currentAngle > angle) {
                if (currentAngle - characteristics.getCourseChange() > angle) {
                    currentAngle = currentAngle - characteristics.getCourseChange();
                    airplane.getPosition()
                            .setCourse(currentAngle - characteristics.getCourseChange());
                    TemporaryPoint point = createPoint(airplane);
                    flight.getPassedPoints().add(point);
                } else {
                    airplane.getPosition().setCourse(angle);
                    currentAngle = angle;
                    TemporaryPoint point = createPoint(airplane);
                    flight.getPassedPoints().add(point);
                }
            }
        }
    }

    public double findAngle(Airplane airplane, WayPoint wayPoint) {
        double angleToPoint = airplane.getPosition().getCourse();
        if (airplane.getPosition().getLatitude() < wayPoint.getLatitude()
                   && airplane.getPosition().getLongitude() < wayPoint.getLongitude()) {
            double x = wayPoint.getLatitude() - airplane.getPosition().getLatitude();
            double y = wayPoint.getLongitude() - airplane.getPosition().getLongitude();
            angleToPoint = Math.toDegrees(Math.atan(x / y));
        }
        if (airplane.getPosition().getLatitude() > wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() < wayPoint.getLongitude()) {
            double x = airplane.getPosition().getLatitude() - wayPoint.getLatitude();
            double y = wayPoint.getLongitude() - airplane.getPosition().getLongitude();
            angleToPoint = Math.toDegrees(Math.atan(y / x)) + 270;
        }
        if (airplane.getPosition().getLatitude() > wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() > wayPoint.getLongitude()) {
            double x = airplane.getPosition().getLatitude() - wayPoint.getLatitude();
            double y = airplane.getPosition().getLongitude() - wayPoint.getLongitude();
            angleToPoint = Math.toDegrees(Math.atan(x / y)) + 180;
        }
        if (airplane.getPosition().getLatitude() < wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() > wayPoint.getLongitude()) {
            double x = wayPoint.getLatitude() - airplane.getPosition().getLatitude();
            double y = airplane.getPosition().getLongitude() - wayPoint.getLongitude();
            angleToPoint = Math.toDegrees(Math.atan(y / x)) + 90;
        }
        return angleToPoint;
    }

    public void move(Airplane airplane, WayPoint wayPoint,
                     AirplaneCharacteristics characteristics) {
        double speed = airplane.getPosition().getSpeed();
        if (airplane.getPosition().getLatitude() < wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() < wayPoint.getLongitude()) {
            double x = wayPoint.getLatitude() - airplane.getPosition().getLatitude();
            double y = wayPoint.getLongitude() - airplane.getPosition().getLongitude();
            double hypotenuse = Math.sqrt(x * x + y * y);
            if (airplane.getPosition().getLatitude()
                    + (speed * x / hypotenuse * 3.6 / 111) > wayPoint.getLatitude()
                    || airplane.getPosition().getLongitude()
                    + (speed * y / hypotenuse * 3.6 / 111) > wayPoint.getLongitude()) {
                airplane.getPosition().setLatitude(wayPoint.getLatitude());
                airplane.getPosition().setLongitude(wayPoint.getLongitude());
            }
            airplane.getPosition().setLatitude(airplane
                    .getPosition().getLatitude() + (speed * x / hypotenuse * 3.6 / 111));
            airplane.getPosition().setLongitude(airplane
                    .getPosition().getLongitude() + (speed * y / hypotenuse * 3.6 / 111));
        }

        if (airplane.getPosition().getLatitude() > wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() < wayPoint.getLongitude()) {
            double x = airplane.getPosition().getLatitude() - wayPoint.getLatitude();
            double y = wayPoint.getLongitude() - airplane.getPosition().getLongitude();
            double hypotenuse = Math.sqrt(x * x + y * y);
            if (airplane.getPosition().getLatitude()
                    - (speed * x / hypotenuse * 3.6 / 111) < wayPoint.getLatitude()
                    || airplane.getPosition().getLongitude()
                    + (speed * y / hypotenuse * 3.6 / 111) > wayPoint.getLongitude()) {
                airplane.getPosition().setLatitude(wayPoint.getLatitude());
                airplane.getPosition().setLongitude(wayPoint.getLongitude());
            }
            airplane.getPosition().setLatitude(airplane.getPosition()
                    .getLatitude() - (speed * x / hypotenuse * 3.6 / 111));
            airplane.getPosition().setLongitude(airplane.getPosition().getLongitude()
                    + (speed * y / hypotenuse * 3.6 / 111));

        }
        if (airplane.getPosition().getLatitude() > wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() > wayPoint.getLongitude()) {
            double x = airplane.getPosition().getLatitude() - wayPoint.getLatitude();
            double y = airplane.getPosition().getLongitude() - wayPoint.getLongitude();
            double hypotenuse = Math.sqrt(x * x + y * y);
            if (airplane.getPosition().getLatitude()
                    - (speed * x / hypotenuse * 3.6 / 111) < wayPoint.getLatitude()
                    || airplane.getPosition().getLongitude()
                    - (speed * y / hypotenuse * 3.6 / 111) > wayPoint.getLongitude()) {
                airplane.getPosition().setLatitude(wayPoint.getLatitude());
                airplane.getPosition().setLongitude(wayPoint.getLongitude());
            }
            airplane.getPosition()
                    .setLatitude(airplane.getPosition().getLatitude()
                            - (speed * x / hypotenuse * 3.6 / 111));
            airplane.getPosition()
                    .setLongitude(airplane.getPosition().getLongitude()
                            - (speed * y / hypotenuse * 3.6 / 111));

        }

        if (airplane.getPosition().getLatitude() < wayPoint.getLatitude()
                && airplane.getPosition().getLongitude() > wayPoint.getLongitude()) {
            double x = wayPoint.getLatitude() - airplane.getPosition().getLatitude();
            double y = airplane.getPosition().getLongitude() - wayPoint.getLongitude();
            double hypotenuse = Math.sqrt(x * x + y * y);
            if (airplane.getPosition()
                    .getLatitude() + (speed * x / hypotenuse * 3.6 / 111) < wayPoint.getLatitude()
                    || airplane.getPosition()
                    .getLongitude() - (speed * y / hypotenuse * 3.6 / 111)
                    > wayPoint.getLongitude()) {
                airplane.getPosition().setLatitude(wayPoint.getLatitude());
                airplane.getPosition().setLongitude(wayPoint.getLongitude());
            }
            airplane.getPosition().setLatitude(airplane
                    .getPosition().getLatitude() + (speed * x / hypotenuse * 3.6 / 111));
            airplane.getPosition().setLongitude(airplane
                    .getPosition().getLongitude() - (speed * y / hypotenuse * 3.6 / 111));

        }
    }

    public TemporaryPoint createPoint(Airplane airplane) {
        TemporaryPoint temporaryPoint = new TemporaryPoint(airplane.getPosition().getHeight(),
                airplane.getPosition().getSpeed(), airplane.getPosition().getLatitude(),
                    airplane.getPosition().getLongitude(), airplane.getPosition().getCourse());
        return temporaryPoint;
    }
}
