package ParkingApp;

import ParkingApp.PricingModeSubclass.EventPricing;
import ParkingApp.PricingModeSubclass.LostPricing;
import ParkingApp.PricingModeSubclass.MinMaxPricing;
import ParkingApp.TicketSubclass.EventTicket;
import ParkingApp.TicketSubclass.LostTicket;
import ParkingApp.TicketSubclass.MinMaxTicket;
import ParkingApp.Util.ConfigData;
import ParkingApp.Util.FileInput;
import ParkingApp.Util.FileOutput;

import java.text.SimpleDateFormat;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to simulate a parking garage
 * @author Sean McGovern
 * @version 2.0.0
 */

public class Garage {


    private CheckInATM checkInATM;
    private CheckOutATM checkOutATM;
    private TreeMap<Integer, Ticket> ticketMap;
    private EnumMap<TicketType, PricingMode> priceMap = new EnumMap<>(TicketType.class);
    private String fileName;




    public Garage(ConfigData config) throws NumberFormatException {
        this.fileName = config.getFileName();
        FileInput inFile = new FileInput(this.fileName);
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int lastTicketID = 0;
        this.ticketMap = new TreeMap<>();
        TicketType ticketType;
        try {
            while ((line = inFile.fileReadLine()) != null) {
                String[] fields = line.split(",");
                String ticketTypeString = fields[3];
                try {
                    ticketType = TicketType.valueOf(ticketTypeString);
                } catch (EnumConstantNotPresentException e) {
                    System.out.println("Unable to read from file");
                    break;
                }

                Ticket ticket;
                switch (ticketType) {
                    case MINMAX:
                        ticket = new MinMaxTicket(Integer.parseInt(fields[0]), sdf.parse(fields[1]));
                        ticket.setOutTime(!(fields[2].equals("null")) ? sdf.parse(fields[2]) : null);
                        break;
                    case EVENT:
                        ticket = new EventTicket(Integer.parseInt(fields[0]), sdf.parse(fields[1]));
                        ticket.setOutTime(!(fields[2].equals("null")) ? sdf.parse(fields[2]) : null);
                        break;
                    case LOST:
                        ticket = new LostTicket(Integer.parseInt(fields[0]), sdf.parse(fields[1]));
                        ticket.setOutTime(!(fields[2].equals("null")) ? sdf.parse(fields[2]) : null);
                        break;
                    default:
                        throw new Exception("Error on import");
                }
                ticketMap.put(Integer.parseInt(fields[0]), ticket);
                lastTicketID = Integer.parseInt(fields[0]);
            }
            inFile.fileClose();
        } catch (Exception e) {
            System.out.println("Failed to initialize garage");
            System.exit(10);
        }

        TicketBuilder.TICKET_BUILDER.setLastTicketID(lastTicketID);
        this.checkInATM = new CheckInATM(this);
        this.checkOutATM = new CheckOutATM(this);
        priceMap.put(TicketType.MINMAX, new MinMaxPricing(config.getMinMaxFields()[0], config.getMinMaxFields()[1], config.getMinMaxFields()[2], config.getMinMaxFields()[3]));
        priceMap.put(TicketType.EVENT, new EventPricing(config.getEventField()));
        priceMap.put(TicketType.LOST, new LostPricing(config.getLostField()));
    }


    /**
     * Process new vehicle entering garage;
     * @param type initial ticket type for vehicle
     */
    public void checkInVehicle(TicketType type){
        checkInATM.checkInTicket(type);

    }

    /**
     * Process ticket of vehicle exiting garage
     * @param id id of vehicles ticket
     */
    public void checkOutVehicle(int id){
        checkOutATM.checkoutTicket(ticketMap.get(id));
    }
    /**
     * Writes to ledger, Closes garage and ends program
     */
    public void closeGarage() {
        checkOutATM.displayEODInfo(ticketMap);
        FileOutput outFile = new FileOutput(this.fileName);
        for (Map.Entry<Integer, Ticket> entry : ticketMap.entrySet()) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Ticket value = entry.getValue();
            Integer key = entry.getKey();
            outFile.fileWrite(key.toString() + "," + sdf.format(value.getInTime()) + "," + ((value.getOutTime() != null) ? sdf.format(value.getOutTime()) : "null") + "," + value.getType());
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
     * get the enummap of pricingmodes
     * @return enummap of pricingmodes
     */
    public EnumMap<TicketType, PricingMode> getPriceMap() {
        return priceMap;
    }
}
