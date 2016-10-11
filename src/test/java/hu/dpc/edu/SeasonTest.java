package hu.dpc.edu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vrg on 11/10/16.
 */
public class SeasonTest {
    @Test
    public void toStringShouldReturnWithDisplayName() throws Exception {
        assertEquals(Season.SPRING.getDisplayName(), Season.SPRING.toString());
    }

    @Test
    public void testSwitch() throws Exception {
        Season s = Season.values()[(int) (Math.random() * Season.values().length)];
        switch (s.ordinal()) {
            case 3:
                System.out.println("Tel");
                break;
            case 2:
                System.out.println("Nyar");
                break;
            default:
                System.out.println("Mas");
        }
    }

}