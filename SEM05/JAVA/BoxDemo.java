/*
 * Question:
 * Create a class `Box` with overloaded constructors for initializing a box with no dimensions, one dimension, and three dimensions. Also create overloaded methods `volume()` to calculate the volume based on the available dimensions.
 */

class Box {
    double length;
    double breadth;
    double height;

    Box() {
        length = 0;
        breadth = 0;
        height = 0;
    }

    Box(double side) {
        length = side;
        breadth = side;
        height = side;
    }

    Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    double volume() {
        return length * breadth * height;
    }

    double volume(double side) {
        return side * side * side;
    }

    double volume(double length, double breadth, double height) {
        return length * breadth * height;
    }
}

public class BoxDemo {
    public static void main(String[] args) {

        Box b1 = new Box();
        Box b2 = new Box(5);
        Box b3 = new Box(10, 5, 2);

        System.out.println("Box 1 volume: " + b1.volume());
        System.out.println("Box 2 volume: " + b2.volume());
        System.out.println("Box 3 volume: " + b3.volume());

        System.out.println("Cube volume: " + b2.volume(4));

        System.out.println("Custom volume: "
                           + b3.volume(10, 5, 2));
    }
}
