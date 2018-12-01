package ParkingApp;

import java.util.Date;

public interface Ticket {
    TicketType getType();
    Date getInTime();
    Date getOutTime();
    int getTicketID();
    int getPrice();
    void setOutTime(Date date);
    void setPrice(int ticketPrice);
}

class MinMaxTicket implements Ticket{

    private TicketType type = TicketType.MINMAX;
    private int ticketID;
    private Date inTime;
    private Date outTime;
    private int price;

    MinMaxTicket(int ticketID, Date inTime) {
        this.ticketID = ticketID;
        this.inTime = inTime;
    }

    @Override
    public int getPrice() { return price; }

    @Override
    public TicketType getType() {
        return type;
    }

    @Override
    public Date getInTime() {
        return inTime;
    }

    public void setPrice(int price) {this.price = price;}

    public void setType(TicketType type) {
        this.type = type;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}

class EventTicket implements Ticket{
    private TicketType type = TicketType.EVENT;
    private int ticketID;
    private Date inTime;
    private Date outTime;
    private int price;

    EventTicket(int ticketID, Date inTime) {
        this.ticketID = ticketID;
        this.inTime = inTime;
    }

    @Override
    public int getPrice() { return price; }

    @Override
    public TicketType getType() {
        return type;
    }

    @Override
    public Date getInTime() {
        return inTime;
    }

    public void setPrice(int price) {this.price = price;}

    public void setType(TicketType type) {
        this.type = type;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}

class LostTicket implements Ticket {
    private TicketType type = TicketType.LOST;
    private int ticketID;
    private Date inTime;
    private Date outTime;
    private int price;

    LostTicket(int ticketID, Date inTime) {
        this.ticketID = ticketID;
        this.inTime = inTime;
    }

    @Override
    public int getPrice() { return price; }

    @Override
    public TicketType getType() {
        return type;
    }

    @Override
    public Date getInTime() {
        return inTime;
    }

    public void setPrice(int price) {this.price = price;}

    public void setType(TicketType type) {
        this.type = type;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}


