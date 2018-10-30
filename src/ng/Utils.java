package ng;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // method for prompting user input
    public static String getUserInput(String message) {
        System.out.println(message);
        try {
            return reader.readLine().toLowerCase();
        } catch(IOException e) {
            return "invalid argument!";
        }
    }
}