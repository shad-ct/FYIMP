// Write a Java program to create two or more threads by implementing the Runnable interface. Each thread should perform a separate task. Explain why implementing Runnable can be preferable to extending the Thread class in certain situations.
public class RunnableDemo {
    static class Task1 implements Runnable {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task1: " + i);
            }
        }
    }
    static class Task2 implements Runnable {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task2: Hello " + i);
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        t1.start();
        t2.start();
        System.out.println("Runnable allows multiple inheritance and shared task logic.");
    }
}
