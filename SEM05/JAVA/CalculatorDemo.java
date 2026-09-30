/*
 * Question:
 * Create a class `Calculator` with overloaded `add()` methods to perform addition of two integers, three integers, and two double values. Call all the overloaded methods using appropriate objects.
 */

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println("Addition of two integers: "
                           + c.add(10, 20));

        System.out.println("Addition of three integers: "
                           + c.add(10, 20, 30));

        System.out.println("Addition of two doubles: "
                           + c.add(10.5, 20.5));
    }
}
