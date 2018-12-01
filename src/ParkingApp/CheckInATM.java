package ParkingApp;
import java.util.Date;

/**
 * Class to check vehicles into garage
 * @author Sean McGovern
 * @version 1.0.0
 */
class CheckInATM {

    private Garage garage;

    CheckInATM(Garage garage) {
        this.garage = garage;
    }

    void createTicket(TicketType type){
        Ticket ticket = TicketBuilder.TICKET_BUILDER.getTicket(type);
        if (ticket != null) {
            this.garage.getTicketMap().put(ticket.getTicketID(), ticket);
        } else {
            System.out.println("Null ticket");
            System.exit(10);
        }
    }

}

