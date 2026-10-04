// Develop a Java program that simulates a ticket booking system. Create multiple threads representing customers attempting to book tickets from the same limited ticket pool. Use synchronization to ensure that two customers cannot book the same ticket. Display the booking details and remaining number of tickets after each transaction.
public class TicketBooking {
    static class TicketCounter {
        int tickets = 5;
        synchronized void book(String customer) {
            if (tickets > 0) {
                System.out.println(customer + " booked ticket " + tickets);
                tickets--;
                System.out.println("Remaining tickets: " + tickets);
            } else {
                System.out.println(customer + " could not book. Sold out.");
            }
        }
    }
    static class Customer extends Thread {
        TicketCounter counter;
        Customer(TicketCounter c, String name) {
            super(name);
            counter = c;
        }
        public void run() {
            counter.book(getName());
        }
    }
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();
        Customer c1 = new Customer(counter, "Customer1");
        Customer c2 = new Customer(counter, "Customer2");
        Customer c3 = new Customer(counter, "Customer3");
        Customer c4 = new Customer(counter, "Customer4");
        Customer c5 = new Customer(counter, "Customer5");
        Customer c6 = new Customer(counter, "Customer6");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
    }
}
