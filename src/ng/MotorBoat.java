package ng;

public class MotorBoat extends Vehicle {
    public final String vehicleType = "Motor boat";
    private String renterName;
    public static final int price = 50;

    public static String getVehicleInfo() {
        return "A boat with an outboard motor that can go 15 knots. It costs " + price + " euros a day.";
    }

    public String getRenterName() {
        return this.renterName;
    }

    public void setRenterName(String name) {
        this.renterName = name;
    }
}
