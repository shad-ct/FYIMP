/*
 * Question:
 * Create a class `Rectangle` with overloaded constructors to initialize a rectangle with default values, length and breadth, and a square using a single value. Write a method to calculate and display the area.
 */

class Rectangle {
    int length;
    int breadth;

    Rectangle() {
        length = 1;
        breadth = 1;
    }

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    Rectangle(int side) {
        length = side;
        breadth = side;
    }

    void displayArea() {
        System.out.println("Area = " + (length * breadth));
    }
}

public class RectangleDemo {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10, 5);
        Rectangle r3 = new Rectangle(7);

        System.out.println("Default rectangle:");
        r1.displayArea();

        System.out.println("Rectangle:");
        r2.displayArea();

        System.out.println("Square:");
        r3.displayArea();
    }
}
