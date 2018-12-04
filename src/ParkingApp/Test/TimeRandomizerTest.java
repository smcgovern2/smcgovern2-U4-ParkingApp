package ParkingApp.Test;

import ParkingApp.TimeRandomizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TimeRandomizerTest {


    @Test
    public void getRandomTime() {
        assertEquals(TimeRandomizer.TIME_RANDOMIZER.getRandomTime(TimeRandomizer.TIME_RANDOMIZER.getMorningTime(), 6).getClass() , new Date().getClass());
    }

    @Test
    public void getMorningTime() {
        assertTrue(TimeRandomizer.TIME_RANDOMIZER.getMorningTime().getClass() == new Date().getClass());
    }

    @Test
    public void getEveningTime() {
        assertTrue(TimeRandomizer.TIME_RANDOMIZER.getMorningTime().getClass() == new Date().getClass());
    }
}