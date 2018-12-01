package ParkingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * Class to facilitate user input to garage
 * @author Sean McGovern
 * @version 1.0.0
 */
public class UserInterface {

    private Garage garage;


    UserInterface(Garage garage) {
        this.garage = garage;
    }

    /**
     * Iterates through a menu and responds to user input gathered from console
     */
    void loopMenu() {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        boolean isLiveTicket = false;
        while (!input.equals("3")) {
            showHeader();
            if (isLiveTicket) {
                showCheckOutMenu();
            } else {
                showCheckInMenu();
            }
            try {
                input = inStream.readLine();
            } catch (IOException e) {
                System.out.println("Error encountered:" + e);
            }

            switch (input) {
                case "1":
                    if (isLiveTicket) {
                        garage.checkOutVehicle(TicketBuilder.TICKET_BUILDER.getLastTicketId());
                        isLiveTicket = false;
                    } else {
                        garage.checkInVehicle(TicketType.MINMAX);
                        isLiveTicket = true;
                    }
                    break;
                case "2":
                    if (isLiveTicket) {
                        garage.getCheckOutATM().loseTicket(TicketBuilder.TICKET_BUILDER.getLastTicketId());
                        garage.checkOutVehicle(TicketBuilder.TICKET_BUILDER.getLastTicketId());
                        isLiveTicket = false;
                    } else {
                        garage.checkInVehicle(TicketType.EVENT);
                        isLiveTicket = true;
                    }
                    break;
                case "3":
                    if (isLiveTicket) {
                        System.out.println("Invalid input");
                    } else {
                        garage.closeGarage();
                    }
                    break;
                default:
                    System.out.println("Invalid Selection");

                }
        }
    }

    /**
     * displays a header in console
     */
    private void showHeader() {
        System.out.println("BEST VALUE PARKING GARAGE");
        System.out.println("=========================");
    }

    /**
     * displays checkin menu in console
     */
    private void showCheckInMenu() {
        System.out.println("1 - Check/In");
        System.out.println("2 - Special Event");
        System.out.println("3 - Close Garage");
        System.out.print("=>");
    }

    /**
     * Display checkout menu in console
     */
    private void showCheckOutMenu() {
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        //System.out.println("3 - Close Garage");
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
}

