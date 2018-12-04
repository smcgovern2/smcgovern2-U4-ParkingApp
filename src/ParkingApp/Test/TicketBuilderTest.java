package ParkingApp.Test;

import ParkingApp.Ticket;
import ParkingApp.TicketBuilder;
import ParkingApp.TicketSubclass.MinMaxTicket;
import ParkingApp.TicketType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketBuilderTest {

    @Test
    public void getTicket() {
        Ticket ticket = TicketBuilder.TICKET_BUILDER.getTicket(TicketType.MINMAX);
        assertNotNull(ticket);
        assertEquals(ticket.getType(), TicketType.MINMAX);
    }
}