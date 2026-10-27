package ugv.bus;

public class IntercityRoute extends Route {
    private static final double INTERCITY_TAX = 50.0;

    public IntercityRoute(String routeName, String time, String startLocation, String endLocation, double distance, double unitCost) {
        super(routeName, time, startLocation, endLocation, distance, unitCost);
    }

    @Override
    public double calculateTotalFare() {
        return (distance * unitCost) + INTERCITY_TAX;
    }
}