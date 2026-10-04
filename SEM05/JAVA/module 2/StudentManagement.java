// Create a class Student with name, rollNo, and mark. Implement default and parameterized constructors, a method display() to display student details, and overloaded methods calculateGrade() for different types of marks. Create multiple student objects and demonstrate garbage collection by making some objects eligible for garbage collection.
public class StudentManagement {
    static class Student {
        String name;
        int rollNo;
        double mark;
        Student() {
            name = "Unknown";
            rollNo = 0;
            mark = 0;
        }
        Student(String n, int r, double m) {
            name = n;
            rollNo = r;
            mark = m;
        }
        void display() {
            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Mark: " + mark);
        }
        String calculateGrade() {
            return calculateGrade(mark);
        }
        String calculateGrade(double m) {
            if (m >= 90) return "A";
            if (m >= 75) return "B";
            if (m >= 60) return "C";
            if (m >= 40) return "D";
            return "F";
        }
        String calculateGrade(int m) {
            return calculateGrade((double) m);
        }
        protected void finalize() {
            System.out.println("Collected student: " + name);
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("Amit", 1, 85);
        Student s2 = new Student("Ravi", 2, 72);
        s1.display();
        System.out.println("Grade: " + s1.calculateGrade());
        s2.display();
        System.out.println("Grade: " + s2.calculateGrade(90));
        s1 = null;
        System.gc();
        System.out.println("End of program.");
    }
}
