package ParkingApp;

import java.text.ParseException;

/**
 * Startup class for parking app
 * @author Sean McGovern
 * @Version 1.0.0
 */

public class Main {
    public static void main(String[] args) {
        try {
            Garage garage = new Garage();
            UserInterface ui = new UserInterface(garage);
            ui.loopMenu();
        } catch (ParseException e) {
            System.out.println("Unable to initialize garage");
        }
    }
}
