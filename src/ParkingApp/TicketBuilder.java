package ParkingApp;

public enum TicketBuilder {
    TICKET_BUILDER;


    private int lastTicketId = 0;
    TicketBuilder(){}



    public Ticket getTicket (TicketType ticketType){
        lastTicketId++;
        switch (ticketType){
            case MINMAX: return new MinMaxTicket(lastTicketId, TimeRandomizer.TIME_RANDOMIZER.getMorningTime());
            case EVENT: return new EventTicket(lastTicketId, TimeRandomizer.TIME_RANDOMIZER.getMorningTime());
            case LOST: return new LostTicket(lastTicketId, TimeRandomizer.TIME_RANDOMIZER.getMorningTime());
            default: return null;
        }
    }
    public void setLastTicketId(int i){
        this.lastTicketId = i;
    }


    public int getLastTicketId() {
        return lastTicketId;
    }
}
