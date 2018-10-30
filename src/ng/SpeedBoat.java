package ng;

public class SpeedBoat extends Vehicle {
    public final String vehicleType = "Speed boat";
    private String renterName;
    private static int price = 90;

    public static String getVehicleInfo() {
        return "A boat with two outboard motors that can go 30 knots. It costs " + price + " euros a day.";
    }

    public String getRenterName() {
        return this.renterName;
    }

    public void setRenterName(String name) {
        this.renterName = name;
    }
}
