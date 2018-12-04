package ParkingApp.PricingModeSubclass;

import ParkingApp.PricingMode;

/**
 * Fee calculator for events
 * @author Sean McGovern
 * @version 2.0.0
 */

public class EventPricing implements PricingMode {
    private int eventFee;

    public EventPricing(int eventFee) {
        this.eventFee = eventFee;
    }

    /**
     * generic getter
     * @return event fee
     */
    public int getEventFee() {
        return eventFee;
    }

    /**
     * generic setter
     * @param eventFee
     */
    public void setEventFee(int eventFee) {
        this.eventFee = eventFee;
    }

    /**
     * Calculates ticket price
     * @param hours hours parked
     * @return ticket price
     */
    @Override
    public int getTicketPrice(int hours) {
        return this.eventFee;
    }
}
