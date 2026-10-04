// Write a Java program to create three threads by extending the Thread class. Each thread should perform a different task, such as printing numbers, displaying characters, and displaying a message. Execute all three threads concurrently and observe their execution order.
public class ThreadClassDemo {
    static class NumberThread extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number: " + i);
            }
        }
    }
    static class CharThread extends Thread {
        public void run() {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Character: " + c);
            }
        }
    }
    static class MessageThread extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello from thread");
            }
        }
    }
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        CharThread t2 = new CharThread();
        MessageThread t3 = new MessageThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
