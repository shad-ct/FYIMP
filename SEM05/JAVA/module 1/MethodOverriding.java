// Write a Java program to create a superclass Animal with a method sound(). Create subclasses Dog and Cat that override the sound() method. Display the appropriate sound for each animal.
public class MethodOverriding {
    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound.");
        }
    }
    static class Dog extends Animal {
        void sound() {
            System.out.println("Dog barks.");
        }
    }
    static class Cat extends Animal {
        void sound() {
            System.out.println("Cat meows.");
        }
    }
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        a1.sound();
        a2.sound();
    }
}
