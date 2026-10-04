// Write a Java program to create an abstract class Vehicle containing an abstract method start() and a concrete method display(). Create subclasses Car and Bike and implement the start() method in each subclass.
public class AbstractVehicle {
    static abstract class Vehicle {
        abstract void start();
        void display() {
            System.out.println("This is a vehicle.");
        }
    }
    static class Car extends Vehicle {
        void start() {
            System.out.println("Car starts with a key.");
        }
    }
    static class Bike extends Vehicle {
        void start() {
            System.out.println("Bike starts with a kick.");
        }
    }
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        v1.display();
        v1.start();
        v2.display();
        v2.start();
    }
}
