package ParkingApp;

/**
 * ENUMS for prices in parking app
 * @author Sean McGovern
 * @Version 1.0.0
 */
public enum PRICES {
    BASE(5), HOURLY(1), LOST(25);
    private int dollarAmount;

    PRICES(int i) {
        this.dollarAmount = i;
    }

    /**
     * gets the dollar amount of a key
     * @return value of key
     */
    public int getDollarAmount() {
        return dollarAmount;
    }

    /**
     * sets the dollar amount of a key
     * @param dollarAmount new dollar amount
     */
    public void setDollarAmount(int dollarAmount) {
        this.dollarAmount = dollarAmount;
    }
}
