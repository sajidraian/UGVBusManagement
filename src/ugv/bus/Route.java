package ugv.bus;

public abstract class Route {
    protected String routeName;
    protected String time;
    protected String startLocation;
    protected String endLocation;
    protected double distance;
    protected double unitCost;

    public Route(String routeName, String time, String startLocation, String endLocation, double distance, double unitCost) {
        this.routeName = routeName;
        this.time = time;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.unitCost = unitCost;
    }

    public abstract double calculateTotalFare();

    public String getRouteName() { return routeName; }
    public String getTime() { return time; }
    public String getStartLocation() { return startLocation; }
    public String getEndLocation() { return endLocation; }
    public double getDistance() { return distance; }
    public double getUnitCost() { return unitCost; }
}