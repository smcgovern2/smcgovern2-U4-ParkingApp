package ParkingApp.Test;

import ParkingApp.Ticket;

import java.util.Date;

import static org.junit.Assert.*;

public class TicketTest {

    Ticket ticket;
    @org.junit.Before
    public void setUp(){
        ticket = new Ticket(123, new Date(0), new Date(0), false);
    }
    @org.junit.Test
    public void getTicketID() {
        assertFalse(ticket.getTicketID()==100);
        assertTrue(ticket.getTicketID() == 123);
    }

    @org.junit.Test
    public void getInTime() {
        assertTrue(ticket.getInTime().equals(new Date(0)));
        assertFalse(ticket.getInTime().equals(new Date(60000)));
    }

    @org.junit.Test
    public void getOutTime() {
        assertTrue(ticket.getOutTime().equals(new Date(0)));
        assertFalse(ticket.getOutTime().equals(new Date(60000)));
    }

    @org.junit.Test
    public void isLost() {
        assertFalse(ticket.isLost());
        assertTrue(!ticket.isLost());
    }
}