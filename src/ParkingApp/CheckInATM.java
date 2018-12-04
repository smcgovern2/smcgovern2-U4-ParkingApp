package ParkingApp;
/**
 * Class to check vehicles into garage
 * @author Sean McGovern
 * @version 2.0.0
 */
public class CheckInATM {

    private Garage garage;

    CheckInATM(Garage garage) {
        this.garage = garage;
    }

    /**Method to add new ticket to garage
     * @param type type of ticket to add
     */
    public void checkInTicket(TicketType type){
        Ticket ticket = TicketBuilder.TICKET_BUILDER.getNewTicket(type);
        if (ticket != null) {
            this.garage.getTicketMap().put(ticket.getTicketID(), ticket);
        } else {
            System.out.println("Null ticket");
            System.exit(10);
        }
    }


}

