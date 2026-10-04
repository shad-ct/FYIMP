// Create a class Demo with a method to display a message. Create several objects of the class and make some objects eligible for garbage collection by assigning null to their references. Request garbage collection using System.gc() and observe the behavior.
public class GarbageCollectionDemo {
    static class Demo {
        String name;
        Demo(String n) {
            name = n;
        }
        void display() {
            System.out.println("Demo object: " + name);
        }
        protected void finalize() {
            System.out.println("Collected: " + name);
        }
    }
    public static void main(String[] args) {
        Demo d1 = new Demo("One");
        Demo d2 = new Demo("Two");
        Demo d3 = new Demo("Three");
        d1.display();
        d2.display();
        d3.display();
        d1 = null;
        d2 = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println("End of program.");
    }
}
