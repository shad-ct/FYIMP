/*
 * Question:
 * Create a class `Demo` with a method to display a message. Create several objects of the class and make some objects eligible for garbage collection by assigning `null` to their references. Request garbage collection using `System.gc()` and observe the behavior.
 */

class Demo {

    void display() {
        System.out.println("Hello from Demo object");
    }
}

public class GarbageCollectionDemo {
    public static void main(String[] args) {

        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Demo d3 = new Demo();

        d1.display();
        d2.display();
        d3.display();

        d1 = null;
        d2 = null;

        System.gc();

        System.out.println("Garbage collection requested.");
    }
}
