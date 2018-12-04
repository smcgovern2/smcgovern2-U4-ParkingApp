package ParkingApp.Test;

import ParkingApp.PricingModeSubclass.*;
import ParkingApp.PricingMode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PricingModeTest {

    PricingMode minMaxPricing;
    PricingMode eventPricing;
    PricingMode lostPricing;

    @Before
    public void setUp() throws Exception {
        minMaxPricing = new MinMaxPricing(3,5,1,15);
        eventPricing = new EventPricing(20);
        lostPricing = new LostPricing(25);

    }

    @Test
    public void getTicketPrice() {
        assertEquals(minMaxPricing.getTicketPrice(6), 8);
        assertEquals(eventPricing.getTicketPrice(6),20);
        assertEquals(lostPricing.getTicketPrice(6), 25);
    }
}