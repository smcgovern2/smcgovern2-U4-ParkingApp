package ParkingApp.PricingModeSubclass;

import ParkingApp.PricingMode;

public class MinMaxPricing implements PricingMode {
    private int minHours;
    private int minFee;
    private int hourlyFee;
    private int maxFee;

    public MinMaxPricing(int minHours, int minFee, int hourlyFee, int maxFee) {
        this.minHours = minHours;
        this.minFee = minFee;
        this.hourlyFee = hourlyFee;
        this.maxFee = maxFee;
    }

    /**
     * generic getter
     * @return Hours before hourly fee begins
     */
    public int getMinHours() {
        return minHours;
    }
    /**
     * generic setter
     * @param minHours desired value
     */
    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }
    /**
     * generic getter
     * @return Minimum price for ticket
     */
    public int getMinFee() {
        return minFee;
    }
    /**
     * generic setter
     * @param minFee desired value
     */
    public void setMinFee(int minFee) {
        this.minFee = minFee;
    }
    /**
     * generic getter
     * @return Hourly fee after min hours has been reached
     */
    public int getHourlyFee() {
        return hourlyFee;
    }
    /**
     * generic setter
     * @param hourlyFee desired value
     */
    public void setHourlyFee(int hourlyFee) {
        this.hourlyFee = hourlyFee;
    }
    /**
     * generic getter
     * @return Max fee for ticket
     */
    public int getMaxFee() {
        return maxFee;
    }
    /**
     * generic setter
     * @param maxFee desired value
     */
    public void setMaxFee(int maxFee) {
        this.maxFee = maxFee;
    }

    /**
     * Calculates ticket price
     * @param hours hours parked
     * @return ticket price
     */
    @Override
    public int getTicketPrice(int hours) {
        if (hours <= this.minHours){
            return this.minFee;
        } else {
            int tempFee = this.minFee + (this.hourlyFee*(hours-this.minHours));
            if (tempFee >= this.maxFee){
                return this.maxFee;
            } else {
                return tempFee;
            }
        }
    }
}
