package ParkingApp.Util;

public class ConfigData {
    private int[] minmaxFields;
    private int eventField;
    private int lostField;

    public ConfigData(int[] minmaxFields, int eventField, int lostField) {
        this.minmaxFields = minmaxFields;
        this.eventField = eventField;
        this.lostField = lostField;
    }

    public int[] getMinmaxFields() {
        return minmaxFields;
    }

    public void setMinmaxFields(int[] minmaxFields) {
        this.minmaxFields = minmaxFields;
    }

    public int getEventField() {
        return eventField;
    }

    public void setEventField(int eventField) {
        this.eventField = eventField;
    }

    public int getLostField() {
        return lostField;
    }

    public void setLostField(int lostField) {
        this.lostField = lostField;
    }
}
