import models.Airplane;
import models.AirplaneCharacteristics;
import models.Flight;
import models.TemporaryPoint;
import models.WayPoint;
import service.FlyService;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final FlyService flyService = new FlyService();
    public static void main(String[] args) {
        List<WayPoint> wayPoints = new ArrayList<>();
        WayPoint point1 = new WayPoint(15, 10, 5, 3);
        WayPoint point2 = new WayPoint(25, 23, 2, 4);
        WayPoint point3 = new WayPoint(17, 14, 6, 8.53);
        wayPoints.add(point1);
        wayPoints.add(point2);
        wayPoints.add(point3);

        AirplaneCharacteristics characteristics = new AirplaneCharacteristics(35, 7.5, 4,9  );
        Airplane airplane = new Airplane(characteristics, new TemporaryPoint(0, 0, 0, 0));
        Flight flight = flyService.planeCalculate(characteristics, wayPoints, airplane);
        System.out.println(flight);
    }
}
