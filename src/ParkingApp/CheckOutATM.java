package ParkingApp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to check vehicles out of garage
 * @author Sean McGovern
 * @version 1.0.0
 */

public class CheckOutATM {

    /**
     * Modifies outTime and isLost values of existing ticket
     * @param ticket ticket to be modified
     * @param outTime time of tickets check out
     * @param isLost whether the ticket has been lost
     * @return ticket with updated attributes
     */
    public Ticket checkoutTicket(Ticket ticket, Date outTime, boolean isLost) {
        Ticket newTicket = new Ticket(ticket.getTicketID(), ticket.getInTime(), ticket.getOutTime(), ticket.isLost());
        newTicket.setOutTime(outTime);
        newTicket.setLost(isLost);
        printReceipt(newTicket);
        return newTicket;
    }

    /**
     * Prints ticket id and price to console
     * @param ticket the ticket to be printed
     */

    public void printReceipt(Ticket ticket) {
        System.out.printf("Receipt for vehicle id %03d \n\n ", ticket.getTicketID());
        if (ticket.isLost()) {
            System.out.println("Lost Ticket");
            System.out.printf("$%s.00\n", Integer.toString(PRICES.LOST.getDollarAmount()));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            long timeParked = ticket.getOutTime().getTime() - ticket.getInTime().getTime();
            int hoursParked = (int) (timeParked / 3600000);
            System.out.println(hoursParked + " hours parked: " + sdf.format(ticket.getInTime()) + " - " + sdf.format(ticket.getOutTime()));
            System.out.printf("$%s.00\n", Integer.toString(PRICES.BASE.getDollarAmount() + (PRICES.HOURLY.getDollarAmount() * hoursParked)));
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
        int remainingVehicles = 0;
        for (Map.Entry<Integer, Ticket> entry : ticketMap.entrySet()) {
            Ticket ticket = entry.getValue();
            if (ticket.getOutTime() == null) {
                remainingVehicles++;
            } else if (ticket.isLost()) {
                lostCount++;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                long timeParked = ticket.getOutTime().getTime() - ticket.getInTime().getTime();
                int hoursParked = (int) (timeParked / 3600000);
                int ticketDollars = PRICES.BASE.getDollarAmount() + (PRICES.HOURLY.getDollarAmount() * hoursParked);
                collectedDollars += ticketDollars;
                collectionCount++;
            }

        }
        int lostDollars = lostCount * PRICES.LOST.getDollarAmount();
        System.out.println("Activity to Date\n");
        System.out.printf("$%s.00 was collected from %d Check Ins\n", Integer.toString(collectedDollars), collectionCount);
        System.out.printf("$%s.00 was collected from %d lost tickets\n", Integer.toString(lostDollars), lostCount);
        System.out.printf("%d vehicle(s) have not yet checked out\n", remainingVehicles);
    }

}
