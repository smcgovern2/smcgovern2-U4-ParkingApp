package ParkingApp;

import ParkingApp.TicketSubclass.EventTicket;
import ParkingApp.TicketSubclass.LostTicket;
import ParkingApp.TicketSubclass.MinMaxTicket;

/**
 * Factory to produce tickets, accessed as enum singleton
 * @author Sean McGovern
 * @version 2.0.0
 */
public enum TicketBuilder {
    TICKET_BUILDER;


    private int lastTicketID = 0;
    TicketBuilder(){}

    /**
     * Method to build a new ticket
     * @param ticketType Initial type of ticket
     * @return new ticket object;
     */
    public Ticket getNewTicket(TicketType ticketType){
        lastTicketID++;
        switch (ticketType){
            case MINMAX: return new MinMaxTicket(lastTicketID, TimeRandomizer.TIME_RANDOMIZER.getMorningTime());
            case EVENT: return new EventTicket(lastTicketID, TimeRandomizer.TIME_RANDOMIZER.getMorningTime());
            case LOST: return new LostTicket(lastTicketID, TimeRandomizer.TIME_RANDOMIZER.getMorningTime());
            default: return null;
        }
    }

    /**
     * Set id of most recent ticket;
     * @param i new id
     */
    public void setLastTicketID(int i){
        this.lastTicketID = i;
    }


    /**
     * Get id of most recent ticket
     * @return ticket id
     */
    public int getLastTicketID() {
        return lastTicketID;
    }
}
