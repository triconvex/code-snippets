package example;

import java.time.LocalDateTime;

public class TicketCounter {

    private int availableSeats = 3;

    public synchronized void bookTicket(String userName, int numberOfTickets) {
        if (availableSeats >= numberOfTickets && numberOfTickets > 0) {
            System.out.println("Hi, " + userName + " : " + numberOfTickets + " Seats booked Successfully!");
            availableSeats -= numberOfTickets;
        } else {
            System.out.println("Hi, " + userName + " : Seats Not Available");
        }

        System.out.println(LocalDateTime.now());
    }

}
