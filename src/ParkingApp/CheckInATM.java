package ParkingApp;
import java.util.Date;

/**
 * Class to check vehicles into garage
 * @author Sean McGovern
 * @version 1.0.0
 */
public class CheckInATM {

    /**
     * Creates a new ticket
     * @param ticketID numeric id of the ticket to be created
     * @param inTime time of tickets creation
     * @return Ticket with assigned id and inTime, null outTime, and false isLost
     */
    public Ticket createTicket(int ticketID, Date inTime){
        Ticket ticket = new Ticket(ticketID, inTime);
        return ticket;
    }

}

