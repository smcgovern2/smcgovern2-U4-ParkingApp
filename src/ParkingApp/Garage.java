package ParkingApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to simulate a parking garage
 * @author Sean McGovern
 * @Version 1.0.0
 */

public class Garage {


    private CheckInATM checkInATM;
    private CheckOutATM checkOutATM;
    private TreeMap<Integer, Ticket> ticketMap;
    private TimeRandomizer timeRandomizer;

    private int lastTicketID;


    public Garage() throws ParseException {
        FileInput inFile = new FileInput("Ledger.csv");
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.lastTicketID = 0;
        this.ticketMap = new TreeMap<Integer, Ticket>();
        while ((line = inFile.fileReadLine()) != null) {
            String[] fields = line.split(",");
            Ticket ticket = new Ticket(Integer.parseInt(fields[0]), sdf.parse(fields[1]), (!(fields[2].equals("null")) ? sdf.parse(fields[2]) : null), Boolean.getBoolean(fields[3]));
            ticketMap.put(Integer.parseInt(fields[0]), ticket);
            this.lastTicketID = Integer.parseInt(fields[0]);
        }
        inFile.fileClose();

        this.checkInATM = new CheckInATM();
        this.checkOutATM = new CheckOutATM();
        this.timeRandomizer = new TimeRandomizer();
    }

    /**
     * Generates/adds a new vehicle/ticket to ticketmap
     * @throws ParseException date format TimeRandomizer cannot parse date from string
     */
    public void checkInVehicle() throws ParseException {
        this.lastTicketID += 1;
        Ticket ticket = checkInATM.createTicket(this.lastTicketID, timeRandomizer.getMorningTime());
        ticketMap.put(ticket.getTicketID(), ticket);
    }

    /**
     * Checks a vehicle out of garage
     * @param id id of vehicle/ticket to check out
     * @param isLost whether or not the ticket has been misplaced
     * @throws ParseException Date in TimeRandomizer cannot be parsed
     */
    public void checkOutVehicle(int id, boolean isLost) throws ParseException {
        Ticket ticket = checkOutATM.checkoutTicket(ticketMap.get(id), timeRandomizer.getEveningTime(), isLost);
        ticketMap.put(id, ticket);
    }
    /**
     * Closes garage and ends program
     */
    public void closeGarage() {
        checkOutATM.displayEODInfo(ticketMap);
        FileOutput outFile = new FileOutput("Ledger.csv");
        for (Map.Entry<Integer, Ticket> entry : ticketMap.entrySet()) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Ticket value = entry.getValue();
            Integer key = entry.getKey();
            outFile.fileWrite(key.toString() + "," + sdf.format(value.getInTime()) + "," + ((value.getOutTime() != null) ? sdf.format(value.getOutTime()) : "null") + "," + Boolean.toString(value.isLost()));
        }
        outFile.fileClose();
        System.out.println("System will now terminate");
        System.exit(0);
    }

    /**
     * get the checkinATM
     * @return the checkin atm
     */
    public CheckInATM getCheckInATM() {
        return checkInATM;
    }

    /**
     * set a new checkin atm
     * @param checkInATM checkinatm to be set
     */
    public void setCheckInATM(CheckInATM checkInATM) {
        this.checkInATM = checkInATM;
    }

    /**
     * get the checkout atm
     * @return the checkout atm
     */
    public CheckOutATM getCheckOutATM() {
        return checkOutATM;
    }

    /**
     * set a new checkoutatm;
     * @param checkOutATM the new checkout atm
     */
    public void setCheckOutATM(CheckOutATM checkOutATM) {
        this.checkOutATM = checkOutATM;
    }

    /**
     * get ticket map
     * @return ticket map
     */

    public TreeMap<Integer, Ticket> getTicketMap() {
        return ticketMap;
    }

    /**
     * set new ticketMap
     * @param ticketMap new ticket map
     */

    public void setTicketMap(TreeMap<Integer, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    /**
     * get time randomizer
     * @return time randomizer
     */
    public TimeRandomizer getTimeRandomizer() {
        return timeRandomizer;
    }

    /**
     * set new time randomizer
     * @param timeRandomizer new time randomizer
     */
    public void setTimeRandomizer(TimeRandomizer timeRandomizer) {
        this.timeRandomizer = timeRandomizer;
    }

    /**
     * Gets the id of the most recent ticket
     * @return the most recent ticket
     */
    public int getLastTicketID() {
        return lastTicketID;
    }

    /**
     * sets numeric id for most recent ticket
     * @param lastTicketID new id
     */

    public void setLastTicketID(int lastTicketID) {
        this.lastTicketID = lastTicketID;
    }
}
