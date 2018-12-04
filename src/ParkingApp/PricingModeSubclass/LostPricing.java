package ParkingApp.PricingModeSubclass;

import ParkingApp.PricingMode;

public class LostPricing implements PricingMode {
    private int lostFee;

    public LostPricing(int lostFee) {
        this.lostFee = lostFee;
    }

    /**
     * generic getter
     * @return lost ticket fee
     */
    public int getLostFee() {
        return lostFee;
    }

    /**
     * generic setter
     * @param lostFee
     */
    public void setLostFee(int lostFee) {
        this.lostFee = lostFee;
    }

    /**
     * Calculates ticket price
     * @param hours hours parked
     * @return ticket price
     */
    @Override
    public int getTicketPrice(int hours) {
        return this.lostFee;
    }
}
