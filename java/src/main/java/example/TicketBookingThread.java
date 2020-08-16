package example;

public class TicketBookingThread extends Thread {

    private TicketCounter ticketCounter;
    private String passengerName;
    private int numberOfTicketsToBuy;

    public TicketBookingThread(TicketCounter ticketCounter, String passengerName, int numberOfTicketsToBuy) {
        this.ticketCounter = ticketCounter;
        this.passengerName = passengerName;
        this.numberOfTicketsToBuy = numberOfTicketsToBuy;
    }

    @Override
    public void run() {
        ticketCounter.bookTicket(passengerName, numberOfTicketsToBuy);
    }

}
