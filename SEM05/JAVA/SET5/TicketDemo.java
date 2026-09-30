class TicketBooking {
    private int tickets;

    TicketBooking(int tickets) {
        this.tickets = tickets;
    }

    synchronized void bookTicket(String customerName, int numberOfTickets) {
        System.out.println(customerName + " wants to book " + numberOfTickets + " ticket(s).");
        if (tickets >= numberOfTickets) {
            System.out.println(customerName + " is booking tickets...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
            tickets = tickets - numberOfTickets;
            System.out.println(customerName + " successfully booked " + numberOfTickets + " ticket(s).");
            System.out.println("Remaining tickets = " + tickets);
        } else {
            System.out.println(customerName + " - Booking failed. Not enough tickets.");
            System.out.println("Remaining tickets = " + tickets);
        }
        System.out.println();
    }
}

class TicketCustomer extends Thread {
    TicketBooking booking;
    int numberOfTickets;

    TicketCustomer(TicketBooking booking, String name, int numberOfTickets) {
        super(name);
        this.booking = booking;
        this.numberOfTickets = numberOfTickets;
    }

    public void run() {
        booking.bookTicket(getName(), numberOfTickets);
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking(5);
        TicketCustomer c1 = new TicketCustomer(booking, "Customer 1", 2);
        TicketCustomer c2 = new TicketCustomer(booking, "Customer 2", 2);
        TicketCustomer c3 = new TicketCustomer(booking, "Customer 3", 2);
        c1.start();
        c2.start();
        c3.start();
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("All booking attempts completed.");
    }
}
