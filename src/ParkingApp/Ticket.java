package ParkingApp;

import java.util.Date;

/**
 * Class to simulate a ticket for a parking garage
 * @author Sean McGovern
 * @Version 1.0.0
 */
public class Ticket {
    private int ticketID;
    private Date inTime;
    private Date outTime;
    private boolean isLost;

    public Ticket(int ticketID, Date inTime, Date outTime, boolean isLost) {
        this.ticketID = ticketID;
        this.inTime = inTime;
        this.outTime = outTime;
        this.isLost = isLost;
    }

    public Ticket(int ticketID, Date inTime) {
        this.ticketID = ticketID;
        this.inTime = inTime;
        this.outTime = null;
        this.isLost = false;
    }

    /**
     * Get numeric id of ticket
     * @return ticket id
     */
    public int getTicketID() {
        return ticketID;
    }

    /**
     * set new id for ticket
     * @param ticketID new id
     */
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    /**
     * get the time a ticket was checked in
     * @return in time
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * Sets the intime of the ticket
     * @param inTime new in time
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * get the time a ticket is checked out.
     * @return out time
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * set new out time on ticket
     * @param outTime new out time
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * check if ticket was lost
     * @return whether the ticket was lost as bool
     */

    public boolean isLost() {
        return isLost;
    }

    /**
     * assign the status of a ticket to lost/not lost
     * @param lost true:lost false:not lost
     */
    public void setLost(boolean lost) {
        isLost = lost;
    }
}
