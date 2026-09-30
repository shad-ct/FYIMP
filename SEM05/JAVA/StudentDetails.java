/*
 * Question:
 * Create a class `Student` with data members `name`, `rollNo`, and `mark`. Create an object of the class, assign values, and display the student details.
 */

class Student {
    String name;
    int rollNo;
    double mark;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Mark: " + mark);
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Student s = new Student();

        s.name = "Adel";
        s.rollNo = 101;
        s.mark = 85.5;

        s.display();
    }
}
