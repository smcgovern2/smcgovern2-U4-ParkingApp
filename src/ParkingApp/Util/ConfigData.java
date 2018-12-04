package ParkingApp.Util;

/**
 * Class to hold config info for a parking garage
 * @author Sean McGovern
 * @version 2.0.0
 *
 */

public class ConfigData {
    private int[] minmaxFields;
    private int eventField;
    private int lostField;
    private String fileName;

    public ConfigData(int[] minmaxFields, int eventField, int lostField, String fileName) {
        this.minmaxFields = minmaxFields;
        this.eventField = eventField;
        this.lostField = lostField;
        this.fileName = fileName;
    }


    /**
     * generic get method
     * @return minmax fields
     */
    public int[] getMinmaxFields() {
        return minmaxFields;
    }

    /**
     * generic setter
     * @param minmaxFields desired value
     */
    public void setMinmaxFields(int[] minmaxFields) {
        this.minmaxFields = minmaxFields;
    }

    /**
     * generic get method
     * @return event field
     */
    public int getEventField() {
        return eventField;
    }

    /**
     * generic setter
     * @param eventField desired setter
     */
    public void setEventField(int eventField) {
        this.eventField = eventField;
    }

    /**
     * generic get method
     * @return lost field
     */
    public int getLostField() {
        return lostField;
    }

    /**
     * generic setter
     * @param lostField desired value
     */
    public void setLostField(int lostField) {
        this.lostField = lostField;
    }

    /**
     * generic get method
     * @return file name
     */
    public String getFileName() { return fileName; }
}
