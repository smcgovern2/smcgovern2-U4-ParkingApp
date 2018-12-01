package ParkingApp;

import ParkingApp.Util.ConfigData;

import java.text.ParseException;

/**
 * Startup class for parking app
 * @author Sean McGovern
 * @version 1.0.0
 */

public class Main {
    public static void main(String[] args) {
        //CONFIG

        //STANDARD TICKET
        //Hours within minimum fee
        int minHours = 3;
        //Minimum fee in dollars
        int minFee = 5;
        //Price per hour in dollars
        int hourlyFee = 1;
        //Maximum fee in dollars
        int maxFee = 15;

        //EVENT TICKET
        //Flat event Fee in dollars
        int eventFee = 20;

        //LOST TICKET
        //Flat lost ticket fee in dollars
        int lostFee = 25;

        ConfigData config = new ConfigData(new int[]{minHours,minFee,hourlyFee,maxFee}, eventFee, lostFee);

        Garage garage = new Garage(config);
        UserInterface ui = new UserInterface(garage);
        ui.loopMenu();
    }
}
