package ParkingApp.Test;

import ParkingApp.Garage;
import ParkingApp.TicketType;
import ParkingApp.Util.ConfigData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckOutATMTest {

    Garage garage;

    @Before
    public void setUp() throws Exception {
        garage = new Garage(new ConfigData(new int[]{3,5,1,15}, 20, 25, "Test.csv"));
    }

    @After
    public void tearDown() throws Exception {
        garage = null;
    }

    @Test
    public void checkoutTicket() {
        garage.getCheckInATM().checkInTicket(TicketType.MINMAX);
        assertNull(garage.getTicketMap().get(1).getOutTime());
        garage.getCheckOutATM().checkoutTicket(garage.getTicketMap().get(1));
        assertNotNull(garage.getTicketMap().get(1).getOutTime());
    }

    @Test
    public void loseTicket() {
        garage.getCheckInATM().checkInTicket(TicketType.MINMAX);
        garage.getCheckOutATM().loseTicket(1);
        assertEquals(TicketType.LOST, garage.getTicketMap().get(1).getType());
    }
}