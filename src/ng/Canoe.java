package ng;

public class Canoe extends Vehicle {
    public final String vehicleType = "Canoe";
    private String renterName;
    private static int price = 25;

    public static String getVehicleInfo() {
        return "A canadian canoe with 2 paddles. It costs " + price + " euros a day.";
    }

    public String getRenterName() {
        return this.renterName;
    }

    public void setRenterName(String name) {
        this.renterName = name;
    }
}
