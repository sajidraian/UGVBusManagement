package ugv.bus;

public class ShuttleRoute extends Route {
    public ShuttleRoute(String routeName, String time, String startLocation, String endLocation, double distance, double unitCost) {
        super(routeName, time, startLocation, endLocation, distance, unitCost);
    }

    @Override
    public double calculateTotalFare() {
        return 20.0;
    }
}