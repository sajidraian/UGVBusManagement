package ugv.bus;

public class CityRoute extends Route {
    public CityRoute(String routeName, String time, String startLocation, String endLocation, double distance, double unitCost) {
        super(routeName, time, startLocation, endLocation, distance, unitCost);
    }

    @Override
    public double calculateTotalFare() {
        return distance * unitCost;
    }
}