package ParkingApp.Test;

import ParkingApp.CheckInATM;
import ParkingApp.Garage;

import static org.junit.Assert.*;

public class GarageTest {

    Garage garage;
    @org.junit.Before
    public void setUp() throws Exception {
        garage = new Garage();
    }
//    Unsure how to test these
//    @org.junit.Test
//    public void getCheckInATM() {
//    }
//
//    @org.junit.Test
//    public void getCheckOutATM() {
//    }
//
//    @org.junit.Test
//    public void getTicketMap() {
//    }
//
//    @org.junit.Test
//    public void getTimeRandomizer() {
//    }

    @org.junit.Test
    public void getLastTicketID() {
        garage.setLastTicketID(4);
        assertFalse(garage.getLastTicketID() == 7);
        assertTrue(garage.getLastTicketID() == 4);
    }
}