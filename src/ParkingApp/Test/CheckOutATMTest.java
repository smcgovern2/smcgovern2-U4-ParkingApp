package ParkingApp.Test;

import ParkingApp.CheckOutATM;
import ParkingApp.Ticket;

import java.util.Date;

import static org.junit.Assert.*;

public class CheckOutATMTest {

    CheckOutATM checkOutATM;
    @org.junit.Before
    public void setUp() throws Exception {
        checkOutATM = new CheckOutATM();
    }

    @org.junit.Test
    public void checkoutTicket() {
        Ticket ticket = new Ticket(123, new Date(), null, false);
        checkOutATM.checkoutTicket(ticket, new Date(), true);
        assertFalse(ticket.getOutTime() == null);
        assertTrue(ticket.isLost());
    }

}