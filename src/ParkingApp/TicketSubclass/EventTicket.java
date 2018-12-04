package ParkingApp.TicketSubclass;

import ParkingApp.Ticket;
import ParkingApp.TicketType;

import java.util.Date;

/**
 * Ticket for special event
 * @author Sean McGovern
 * @version 2.0.0
 */
public class EventTicket implements Ticket {
    private TicketType type = TicketType.EVENT;
    private int ticketID;
    private Date inTime;
    private Date outTime;
    private int price;

    public EventTicket(int ticketID, Date inTime) {
        this.ticketID = ticketID;
        this.inTime = inTime;
    }

    /**
     * generic getter
     * @return price
     */
    @Override
    public int getPrice() { return price; }

    /**
     * generic getter
     * @return Ticket type
     */
    @Override
    public TicketType getType() {
        return type;
    }

    /**
     * generic getter
     * @return in time
     */
    @Override
    public Date getInTime() {
        return inTime;
    }
    /**
     * generic setter
     * @param price desired value
     */
    public void setPrice(int price) {this.price = price;}

    /**
     * generic setter
     * @param type desired value
     */
    public void setType(TicketType type) {
        this.type = type;
    }
    /**
     * generic getter
     * @return ticket id
     */
    public int getTicketID() {
        return ticketID;
    }
    /**
     * generic setter
     * @param ticketID desired value
     */
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    /**
     * generic setter
     * @param inTime desired value
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
    /**
     * generic getter
     * @return out time
     */
    public Date getOutTime() {
        return outTime;
    }
    /**
     * generic setter
     * @param outTime desired value
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}
