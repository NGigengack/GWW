package ng;

public class JetSki extends Vehicle {
    public final String vehicleType = "Jet ski";
    private String renterName;
    private static int price = 80;

    public static String getVehicleInfo() {
        return "A jet ski for up to 2 persons. It costs + " + price + " euros a day.";
    }

    public String getRenterName() {
        return this.renterName;
    }

    public void setRenterName(String name) {
        this.renterName = name;
    }
}
