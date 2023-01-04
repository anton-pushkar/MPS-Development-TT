package service;

import models.Airplane;
import models.WayPoint;

public class WaySelectService {
    public void select(Airplane airplane, WayPoint wayPoint) {
        if (wayPoint.getLatitude() > airplane.getPosition().getLatitude()
                && wayPoint.getLongitude() > airplane.getPosition().getLongitude()) {
            //rotate.45
        }
        if (wayPoint.getLatitude() < airplane.getPosition().getLatitude()
                && wayPoint.getLongitude() > airplane.getPosition().getLongitude()) {
            // rotate -45
        }
        if (wayPoint.getLatitude() < airplane.getPosition().getLatitude()
                && wayPoint.getLongitude() < airplane.getPosition().getLongitude()) {
            //rotate -135
        }
        if (wayPoint.getLatitude() > airplane.getPosition().getLatitude()
                && wayPoint.getLongitude() > airplane.getPosition().getLongitude()) {
            // rotate 135
        }
    }
}
