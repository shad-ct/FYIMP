// Write a Java program in which multiple threads access and update a shared bank account balance. Demonstrate the problem that can occur when multiple threads modify the balance simultaneously. Then use the synchronized keyword to ensure that the balance is updated correctly.
public class BankSynchronization {
    static class BankAccount {
        int balance = 1000;
        synchronized void deposit(int amount) {
            balance = balance + amount;
            System.out.println("Deposited " + amount + ", Balance: " + balance);
        }
        synchronized void withdraw(int amount) {
            balance = balance - amount;
            System.out.println("Withdrew " + amount + ", Balance: " + balance);
        }
    }
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                acc.deposit(100);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                acc.withdraw(100);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println("Final Balance: " + acc.balance);
    }
}
