package ParkingApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Class to randomize checkin and checkout times
 * @author Sean McGovern
 * @Version 1.0.0
 */
public class TimeRandomizer {

    /**
     * Get a random time at the nearest hour value in a range
     * @param startTime beginning of range
     * @param hours number of hours in range
     * @return random time at hour mark
     */
    public Date getRandomTime(Date startTime, int hours) {
        Random r = new Random();
        int randHours = r.nextInt(hours);
        long randHoursAsMillis = TimeUnit.HOURS.toMillis(randHours);
        return new Date(startTime.getTime() + randHoursAsMillis);
    }

    /**
     * gets random time between 07:00 and 12:00
     * @return randomized time in morning
     * @throws ParseException when unable to parse startTime
     */
    public Date getMorningTime() throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        String startTime = "07:00:00";
        return getRandomTime(sd.parse(startTime), 5);
    }

    /**
     * gets random time between 13:00 and 23:00
     * @return randomized time in evening
     * @throws ParseException when unable to parse startTime
     */
    public Date getEveningTime() throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        String startTime = "13:00:00";
        return getRandomTime(sd.parse(startTime), 10);
    }


}
