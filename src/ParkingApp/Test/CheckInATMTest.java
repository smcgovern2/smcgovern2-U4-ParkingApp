package ParkingApp.Test;

import ParkingApp.Garage;
import ParkingApp.TicketType;
import ParkingApp.Util.ConfigData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckInATMTest {

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
    public void createTicket() {
        garage.getCheckInATM().createTicket(TicketType.MINMAX);
        assertNotNull(garage.getTicketMap().get(1));
        assertTrue(garage.getTicketMap().get(1).getType().equals(TicketType.MINMAX) );

    }
}