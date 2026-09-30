class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Number thread interrupted.");
            }
        }
    }
}

class CharacterThread extends Thread {
    public void run() {
        for (char ch = 'A'; ch <= 'E'; ch++) {
            System.out.println("Character: " + ch);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Character thread interrupted.");
            }
        }
    }
}

class MessageThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Message: Hello Java");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Message thread interrupted.");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        CharacterThread t2 = new CharacterThread();
        MessageThread t3 = new MessageThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
