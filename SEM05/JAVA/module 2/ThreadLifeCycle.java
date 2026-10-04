// Write a Java program that demonstrates the different stages of a thread's life cycle. Create a thread, start it, make it sleep for a specified period, and allow it to complete. Explain the transition between the New, Runnable, Running, Waiting/Timed Waiting, and Terminated states.
public class ThreadLifeCycle {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread is running.");
                Thread.sleep(1000);
                System.out.println("Thread woke up and continues.");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        });
        System.out.println("State after creation (New): " + t.getState());
        t.start();
        System.out.println("State after start (Runnable): " + t.getState());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("State during sleep (Timed Waiting): " + t.getState());
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("State after completion (Terminated): " + t.getState());
    }
}
