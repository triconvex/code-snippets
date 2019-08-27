package thejava.codecoverage;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoimTest {

    @Test
    public void isEnrollmentFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;
        assertFalse(moim.isEnrollmentFull());
    }

}