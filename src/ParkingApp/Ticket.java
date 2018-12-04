package ParkingApp;

import java.util.Date;
/**
 * Interface for tickets
 * @author Sean McGovern
 * @version 2.0.0
 */
public interface Ticket {
    TicketType getType();
    Date getInTime();
    Date getOutTime();
    int getTicketID();
    int getPrice();
    void setOutTime(Date date);
    void setPrice(int ticketPrice);
}


