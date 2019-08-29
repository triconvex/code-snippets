package 더자바_코드를조작하는다양한방법.codecoverage;

public class Moim {

    int maxNumberOfAttendees;

    int numberOfEnrollment;

    public boolean isEnrollmentFull() {
        if(maxNumberOfAttendees == 0) {
            return false;
        }

        if(numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }

}
