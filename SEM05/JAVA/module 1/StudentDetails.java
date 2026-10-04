// Create a class Student with data members name, rollNo, and mark. Create an object of the class, assign values, and display the student details.
public class StudentDetails {
    static class Student {
        String name;
        int rollNo;
        float mark;
        void display() {
            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Mark: " + mark);
        }
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Rahul";
        s.rollNo = 1;
        s.mark = 85.5f;
        s.display();
    }
}
