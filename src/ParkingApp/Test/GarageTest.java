package ParkingApp.Test;

import ParkingApp.Garage;
import ParkingApp.TicketType;
import ParkingApp.Util.ConfigData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GarageTest {

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
    public void checkInVehicle() {
        garage.checkInVehicle(TicketType.MINMAX);
        assertEquals(garage.getTicketMap().size(), 1);
    }

    @Test
    public void checkOutVehicle() {
        garage.checkInVehicle(TicketType.MINMAX);
        garage.checkOutVehicle(1);
        assertNotNull(garage.getTicketMap().get(1).getOutTime());
    }
}