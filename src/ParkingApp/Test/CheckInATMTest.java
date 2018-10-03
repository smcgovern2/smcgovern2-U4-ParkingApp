package ParkingApp.Test;

import ParkingApp.CheckInATM;
import ParkingApp.Ticket;

import java.util.Date;

import static org.junit.Assert.*;

public class CheckInATMTest {

    CheckInATM checkInATM;
    @org.junit.Before
    public void setUp() throws Exception {
        checkInATM = new CheckInATM();
    }
    @org.junit.Test
    public void createTicket() {
        Ticket ticket = checkInATM.createTicket(123, new Date(5,13,1996));
        assertTrue(ticket.getTicketID() == 123);
        assertFalse(ticket.getTicketID() == 312);
    }
}