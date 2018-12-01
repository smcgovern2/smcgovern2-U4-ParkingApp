package ParkingApp;

public interface PricingMode {
    int getTicketPrice(int hours);
}

class MinMaxPricing implements PricingMode {
    private int minHours;
    private int minFee;
    private int hourlyFee;
    private int maxFee;

    MinMaxPricing(int minHours, int minFee, int hourlyFee, int maxFee) {
        this.minHours = minHours;
        this.minFee = minFee;
        this.hourlyFee = hourlyFee;
        this.maxFee = maxFee;
    }

    public int getMinHours() {
        return minHours;
    }

    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }

    public int getMinFee() {
        return minFee;
    }

    public void setMinFee(int minFee) {
        this.minFee = minFee;
    }

    public int getHourlyFee() {
        return hourlyFee;
    }

    public void setHourlyFee(int hourlyFee) {
        this.hourlyFee = hourlyFee;
    }

    public int getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(int maxFee) {
        this.maxFee = maxFee;
    }

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

class EventPricing implements PricingMode{
    private int eventFee;

    EventPricing(int eventFee) {
        this.eventFee = eventFee;
    }

    public int getEventFee() {
        return eventFee;
    }

    public void setEventFee(int eventFee) {
        this.eventFee = eventFee;
    }

    @Override
    public int getTicketPrice(int hours) {
        return this.eventFee;
    }
}

class LostPricing implements PricingMode{
    private int lostFee;

    LostPricing(int lostFee) {
        this.lostFee = lostFee;
    }

    public int getLostFee() {
        return lostFee;
    }

    public void setLostFee(int lostFee) {
        this.lostFee = lostFee;
    }

    @Override
    public int getTicketPrice(int hours) {
        return this.lostFee;
    }
}