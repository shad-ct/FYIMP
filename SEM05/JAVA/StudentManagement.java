/*
 * Question:
 * Create a class `Student` with `name`, `rollNo`, and `mark`. Implement default and parameterized constructors, a method `display()` to display student details, and overloaded methods `calculateGrade()` for different types of marks. Create multiple student objects and demonstrate garbage collection by making some objects eligible for garbage collection.
 *
 * The sheet doesn't specify the exact grade scale or which mark types should be used, so the following uses `int` and `double` with a conventional A–F scale.
 */

class Student {

    String name;
    int rollNo;
    double mark;

    Student() {
        name = "Unknown";
        rollNo = 0;
        mark = 0;
    }

    Student(String name, int rollNo, double mark) {
        this.name = name;
        this.rollNo = rollNo;
        this.mark = mark;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Mark: " + mark);
        System.out.println("Grade: " + calculateGrade(mark));
        System.out.println();
    }

    char calculateGrade(int mark) {
        if (mark >= 90)
            return 'A';
        else if (mark >= 80)
            return 'B';
        else if (mark >= 70)
            return 'C';
        else if (mark >= 60)
            return 'D';
        else
            return 'F';
    }

    char calculateGrade(double mark) {
        if (mark >= 90)
            return 'A';
        else if (mark >= 80)
            return 'B';
        else if (mark >= 70)
            return 'C';
        else if (mark >= 60)
            return 'D';
        else
            return 'F';
    }
}

public class StudentManagement {

    public static void main(String[] args) {

        Student s1 = new Student();

        Student s2 = new Student("Arun", 101, 85);
        Student s3 = new Student("Anu", 102, 92);
        Student s4 = new Student("Rahul", 103, 67);

        s1.display();
        s2.display();
        s3.display();
        s4.display();

        s1 = null;
        s4 = null;

        System.gc();

        System.out.println("Garbage collection requested.");
    }
}
