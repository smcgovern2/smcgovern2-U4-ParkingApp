package ParkingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * Class to facilitate user input to garage
 * @author Sean McGovern
 * @Version 1.0.0
 */
public class UserInterface {

    private Garage garage;

    private int lastTicketId;

    public UserInterface(Garage garage) {
        this.garage = garage;
        this.lastTicketId = garage.getLastTicketID();
    }

    /**
     * Iterates through a menu and responds to user input gathered from console
     */
    public void loopMenu() {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        boolean isLiveTicket = false;
        while (input != "3") {
            showHeader();
            if (isLiveTicket) {
                showCheckOut();
            } else {
                showCheckIn();
            }
            try {
                input = inStream.readLine();
            } catch (IOException e) {
                System.out.println("Error encountered:" + e);
            }
            this.lastTicketId = garage.getLastTicketID();
            try {
                switch (input) {
                    case "1":
                        if (isLiveTicket) {
                            garage.checkOutVehicle(lastTicketId, false);
                            isLiveTicket = false;
                        } else {
                            garage.checkInVehicle();
                            isLiveTicket = true;
                        }
                        break;
                    case "2":
                        if (isLiveTicket) {
                            garage.checkOutVehicle(lastTicketId, true);
                            isLiveTicket = false;
                        } else {
                            System.out.println("Invalid Selection");
                        }
                        break;
                    case "3":
                        garage.closeGarage();
                        break;
                    default:
                        System.out.println("Invalid Selection");

                }
            } catch (ParseException e) {
                System.out.println("Unable to randomize date");
            }
        }
    }

    /**
     * displays a header in console
     */
    public void showHeader() {
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
    }

    /**
     * displays checkin menu in console
     */
    public void showCheckIn() {
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.print("=>");
    }

    /**
     * Display checkout menu in console
     */
    public void showCheckOut() {
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.println("3 - Close Garage");
        System.out.print("=>");
    }

    /**
     * gets garage assigned to UI
     * @return garage object
     */
    public Garage getGarage() {
        return garage;
    }

    /**
     * assigns a garrage to UI
     * @param garage garrage to assign
     */
    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    /**
     * Gets last ticket id as numeric
     * @return last ticket id
     */
    public int getLastTicketId() {
        return lastTicketId;
    }

    /**
     * sets last ticket id
     * @param lastTicketId new id
     */
    public void setLastTicketId(int lastTicketId) {
        this.lastTicketId = lastTicketId;
    }
}

