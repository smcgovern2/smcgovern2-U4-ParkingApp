package ParkingApp;

import ParkingApp.TicketSubclass.LostTicket;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to check vehicles out of garage
 * @author Sean McGovern
 * @version 2.0.0
 */

public class CheckOutATM {
    private Garage garage;

    CheckOutATM(Garage garage) {
        this.garage = garage;
    }

    /**
     * Method to set a checked in ticket to checked out
     * @param ticket Ticket to check out
     */

    public void checkoutTicket(Ticket ticket) {
        ticket.setOutTime(TimeRandomizer.TIME_RANDOMIZER.getEveningTime());
        calculateTicketPrice(ticket);
        this.garage.getTicketMap().put(ticket.getTicketID(), ticket);
        printReceipt(ticket);
    }


    /**
     * Method to get number of hours a ticket was checked in
     * @param ticket Ticket to query
     * @return number of hours checked in
     */
    private int getTicketHours(Ticket ticket){
        long timeParked = ticket.getOutTime().getTime() - ticket.getInTime().getTime();
        return (int) (timeParked / 3600000);
    }

    /**
     * method to calculate price of ticket and assign to ticket object
     * @param ticket ticket to be run
     */

    public void calculateTicketPrice(Ticket ticket){
        int hours = getTicketHours(ticket);
        PricingMode pricingMode;
        pricingMode = this.garage.getPriceMap().get(ticket.getType());
        ticket.setPrice(pricingMode.getTicketPrice(hours));
    }

    /**
     * Method to replace a ticket in the garage with a lost one
     * @param id id of ticket to lose
     */

    public void loseTicket(int id){
        Ticket oldTicket = this.garage.getTicketMap().get(id);
        Ticket newTicket = new LostTicket(oldTicket.getTicketID(),oldTicket.getInTime());
        this.garage.getTicketMap().put(oldTicket.getTicketID(), newTicket);
    }



    /**
     * Prints ticket information to console, dependent on ticket type
     * @param ticket the ticket to be printed
     */

    private void printReceipt(Ticket ticket) {
        System.out.printf("Receipt for vehicle id %03d \n\n", ticket.getTicketID());
        switch (ticket.getType()) {
            case MINMAX:
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                System.out.println(getTicketHours(ticket) + " hours parked: " + sdf.format(ticket.getInTime()) + " - " + sdf.format(ticket.getOutTime()));
                System.out.printf("$%s.00\n", Integer.toString(ticket.getPrice()));
                break;
            case EVENT:
                System.out.println("Special Event");
                System.out.printf("$%s.00\n", Integer.toString(ticket.getPrice()));
                break;
            case LOST:
                System.out.println("Lost Ticket");
                System.out.printf("$%s.00\n", Integer.toString(ticket.getPrice()));
                break;
            default:
                System.out.println("Unable to print receipt at this time");

        }
    }

    /**
     * Prints aggregate data from ticketMap on total money collected from all sources and tickets unaccounted for
     * @param ticketMap treemap of tickets to be handled
     */
    public void displayEODInfo(TreeMap<Integer, Ticket> ticketMap) {
        int collectionCount = 0;
        int collectedDollars = 0;
        int lostCount = 0;
        int lostDollars = 0;
        int eventCount = 0;
        int eventDollars = 0;
        int remainingVehicles = 0;
        for (Map.Entry<Integer, Ticket> entry : ticketMap.entrySet()) {
            Ticket ticket = entry.getValue();
            if (ticket.getOutTime() == null) {
                remainingVehicles++;
            } else if (ticket.getType().equals(TicketType.LOST)) {
                lostDollars += ticket.getPrice();
                lostCount++;
            } else if (ticket.getType().equals(TicketType.EVENT)) {
                eventDollars += ticket.getPrice();
                eventCount++;
            } else if (ticket.getType().equals(TicketType.MINMAX)){
                collectedDollars += ticket.getPrice();
                collectionCount++;
            }

        }
        System.out.println("Activity to Date\n");
        System.out.printf("$%s.00 was collected from %d Check Ins\n", Integer.toString(collectedDollars), collectionCount);
        System.out.printf("$%s.00 was collected from %d Special Events\n", Integer.toString(eventDollars), eventCount);
        System.out.printf("$%s.00 was collected from %d Lost Tickets\n", Integer.toString(lostDollars), lostCount);
        System.out.printf("%d vehicle(s) have not yet checked out\n\n", remainingVehicles);
        System.out.printf("$%s.00 was collected Overall\n", Integer.toString(collectedDollars + eventDollars + lostDollars));

    }

}
