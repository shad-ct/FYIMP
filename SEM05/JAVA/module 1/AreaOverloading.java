// Create a class Area with overloaded methods calculateArea() to find the area of a square, rectangle, and circle. Demonstrate method overloading using appropriate parameters.
public class AreaOverloading {
    static class Area {
        double calculateArea(double side) {
            return side * side;
        }
        double calculateArea(double length, double breadth) {
            return length * breadth;
        }
        double calculateArea(float radius) {
            return 3.14159 * radius * radius;
        }
    }
    public static void main(String[] args) {
        Area a = new Area();
        System.out.println("Area of square: " + a.calculateArea(5.0));
        System.out.println("Area of rectangle: " + a.calculateArea(4.0, 6.0));
        System.out.println("Area of circle: " + a.calculateArea(3.0f));
    }
}
