package ParkingApp.Test;

import ParkingApp.Garage;
import ParkingApp.UserInterface;

import java.text.ParseException;

import static org.junit.Assert.*;

public class UserInterfaceTest {
    Garage garage = new Garage();
    UserInterface userInterface = new UserInterface(garage);

    public UserInterfaceTest() throws ParseException {
    }

    @org.junit.Test
    public void getGarage() {
        assertTrue(userInterface.getGarage().equals(garage));
    }

    @org.junit.Test
    public void getLastTicketId() {
        assertTrue(userInterface.getLastTicketId() == garage.getLastTicketID());
    }
}