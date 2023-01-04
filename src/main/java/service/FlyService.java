package service;

import java.util.ArrayList;
import java.util.List;
import models.Airplane;
import models.AirplaneCharacteristics;
import models.Flight;
import models.TemporaryPoint;
import models.WayPoint;

public class FlyService {
    private AirplaneService airplaneService = new AirplaneService();

    public Flight planeCalculate(AirplaneCharacteristics characteristics,
                                 List<WayPoint> wayPoints, Airplane airplane) {
        Flight flight = new Flight();
        flight.setWayPoints(wayPoints);
        List<WayPoint> wayPointsCopy = createCopyOfWayPoints(wayPoints);
        flight.setPassedPoints(new ArrayList<TemporaryPoint>());
        while (wayPointsCopy.size() != 0) {
            flyCheck(characteristics, wayPointsCopy, airplane, flight);
        }
        return flight;
    }

    public List<TemporaryPoint> flyCheck(AirplaneCharacteristics characteristics,
                                         List<WayPoint> wayPoints,
                                         Airplane airplane, Flight flight) {
        maxSpeedCheck(characteristics, wayPoints);
        ArrayList<TemporaryPoint> temporaryPoints = new ArrayList<>();
        if (wayPoints.get(0).getHeight() != airplane.getPosition().getHeight()
                || wayPoints.get(0).getSpeed() != airplane.getPosition().getSpeed()
                || wayPoints.get(0).getLatitude() != airplane.getPosition().getLatitude()
                || wayPoints.get(0).getLongitude() != airplane.getPosition().getLongitude()) {
            airplaneService.rotate(airplane, wayPoints.get(0), characteristics, flight);
            airplaneService.changeHeight(airplane, wayPoints.get(0), characteristics);
            airplaneService.changeSpeed(airplane,wayPoints.get(0),characteristics);
            airplaneService.move(airplane, wayPoints.get(0), characteristics);
            TemporaryPoint point = airplaneService.createPoint(airplane);
            flight.getPassedPoints().add(point);
            System.out.println("height " + airplane.getPosition().getHeight()
                    + ", speed " + airplane.getPosition().getSpeed()
                    + ", latitude " + airplane.getPosition().getLatitude() + ", longitude "
                    + airplane.getPosition().getLongitude() + ", course "
                    + airplane.getPosition().getCourse());
        } else {
            System.out.println("You go to point " + wayPoints.get(0));
            wayPoints.remove(0);

        }
        return temporaryPoints;
    }

    private void maxSpeedCheck(AirplaneCharacteristics characteristics, List<WayPoint> wayPoints) {
        for (WayPoint point : wayPoints) {
            if (point.getSpeed() > characteristics.getMaxSpeed()) {
                throw new RuntimeException("Selected speed " + point.getSpeed()
                        + " bigger that possible " + characteristics.getMaxSpeed());
            }
        }
    }

    private List<WayPoint> createCopyOfWayPoints(List<WayPoint> wayPoints) {
        List<WayPoint> wayPointsCopy = new ArrayList<>();
        for (WayPoint wayPoint : wayPoints) {
            wayPointsCopy.add(wayPoint);
        }
        return wayPointsCopy;
    }
}
