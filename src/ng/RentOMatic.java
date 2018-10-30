package ng;

import java.util.ArrayList;
import java.util.Arrays;

public class RentOMatic {
    private Boolean running = true;
    private ArrayList<Vehicle> stock = new ArrayList<>();
    private ArrayList<Vehicle> rented = new ArrayList<>();
    private ArrayList<String> vehicleTypes = new ArrayList<>();

    public static void main(String[] args) {
        RentOMatic rental = new RentOMatic();
        rental.vehicleTypes.addAll(Arrays.asList("Motor boat","Speed boat","Canoe","Jet ski"));
        rental.stock.add(new MotorBoat());
        rental.stock.add(new SpeedBoat());
        rental.stock.add(new Canoe());
        rental.run();
    }

    // method that runs the application. it receives commands and delegates to proper methods.
    private void run() {
        String message = "Welcome to Rent-O-Matic! How can we help you? Type \'commands\' for a complete list of commands.";
        while(running) {
            String userInput = Utils.getUserInput(message);

            switch(userInput) {
                case "help":
                    System.out.println("Type \'commands\' for a complete list of commands.");
                    message = "What do you want to do?";
                    break;

                case "commands":
                    message = showCommands();
                    break;

                case "list":
                    message = showVehicles();
                    break;

                case "vehicle info":
                    message = getVehicleInfo();
                    break;

                case "rent":
                    message = rent();
                    break;

                case "quit":
                case "exit":
                    message = quit();
                    break;

                default:
                    System.out.println("Unknown command! Type \'commands\' for a complete list of commands.");
                    message = "What do you want to do?";
                    break;
            }
        }
    }

    // method that prints a list of all useful commands to the console
    private String showCommands() {
        System.out.println("##################################################################################");
        System.out.println("List of commands:");

        System.out.println("\'quit/exit\':   stop and quit.");
        System.out.println("##################################################################################");
        return "What do you want to do?";
    }

    private String showVehicles() {
        System.out.println("##################################################################################");
        System.out.println("List of vehicle types:");

        for(String type : vehicleTypes ) {
            System.out.println(type);
        }

        System.out.println("##################################################################################");
        return "";
    }

    private String getVehicleInfo() {
        String userInput = Utils.getUserInput("What type of vehicle would you like to know more about?");
        switch(userInput) {
            case "motor boat":
            case "Motor boat":
                System.out.println(MotorBoat.getVehicleInfo());
                break;

            case "speed boat":
            case "Speed boat":
            case "speedboat":
            case "Speedboat":
                System.out.println(SpeedBoat.getVehicleInfo());
                break;

            case "canoe":
            case "Canoe":
                System.out.println(Canoe.getVehicleInfo());
                break;

            case "jet ski":
            case "Jet ski":
                System.out.println(Canoe.getVehicleInfo());
                break;

            default:
                System.out.println("Sorry, we don't have this type of vehicle!");
                break;
        }
        return "What do you want to do?";
    }

    private String rent() {
        String message = "";
        String userInput = Utils.getUserInput("What type of vehicle would you like to rent?");
        switch(userInput) {
            case "motor boat":
            case "Motor boat":
                message = rent("Motor boat");
                break;

            case "speed boat":
            case "Speed boat":
            case "speedboat":
            case "Speedboat":
                message = rent("Speed boat");
                break;

            case "canoe":
            case "Canoe":
                message = rent("Canoe");
                break;

            case "jet ski":
            case "Jet ski":
                message = rent("Jet ski");
                break;

            default:
                System.out.println("Sorry, we don't have this type of vehicle!");
                break;
        }
        return message;
    }

    private String rent(String vehicleType) {
        Vehicle chosen = null;
        for(Vehicle vehicle : stock) {
            if(vehicle.vehicleType.equals(vehicleType)) {
                String name = Utils.getUserInput("What is your name?");
                vehicle.setRenterName(name);
                chosen = vehicle;
                rented.add(vehicle);
            } else {
                return "This type of vehicle is out of stock!";
            }
        }

        if(chosen != null)
            stock.remove(chosen);

        pay(chosen.price);

        return "Welcome to Rent-O-Matic! How can we help you? Type \'commands\' for a complete list of commands.";

    }

    private void pay(int price) {
        int money = Integer.parseInt(Utils.getUserInput("Please insert " + price));
        if(price - money == 0) {
            System.out.println("thanks!");
        } else {
            System.out.println("sotty, not enough!");
        }
    }

    private String quit() {
        String userInput = Utils.getUserInput("Are you sure you want to quit? \'y\'/\'n\'");
        if(userInput.equals("yes") || userInput.equals("y")) {
            running = false;
            return "Ok, bye!";
        } else {
            System.out.println("Okay, don't quit.");
            return "What do you want to do?";
        }
    }
}
