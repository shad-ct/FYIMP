class BankAccount {
    private int balance = 1000;

    void withdrawWithoutSync(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal.");
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient balance");
        }
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal.");
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient balance");
        }
    }

    int getBalance() {
        return balance;
    }
}

class BankCustomer extends Thread {
    BankAccount account;

    BankCustomer(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        account.withdraw(700);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        BankCustomer c1 = new BankCustomer(account, "Customer 1");
        BankCustomer c2 = new BankCustomer(account, "Customer 2");
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Final Balance = " + account.getBalance());
    }
}
