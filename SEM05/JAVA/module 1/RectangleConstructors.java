// Create a class Rectangle with overloaded constructors to initialize a rectangle with default values, length and breadth, and a square using a single value. Write a method to calculate and display the area.
public class RectangleConstructors {
    static class Rectangle {
        double length;
        double breadth;
        Rectangle() {
            length = 1;
            breadth = 1;
        }
        Rectangle(double l, double b) {
            length = l;
            breadth = b;
        }
        Rectangle(double side) {
            length = side;
            breadth = side;
        }
        void displayArea() {
            System.out.println("Area: " + (length * breadth));
        }
    }
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4, 6);
        Rectangle r3 = new Rectangle(5);
        System.out.print("Default rectangle ");
        r1.displayArea();
        System.out.print("Rectangle (4x6) ");
        r2.displayArea();
        System.out.print("Square (5x5) ");
        r3.displayArea();
    }
}
