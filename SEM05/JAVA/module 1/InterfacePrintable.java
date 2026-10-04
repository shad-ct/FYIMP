// Define an interface Printable with a method print(). Create classes Student and Teacher that implement the interface. Write a program to display the details of a student and a teacher using the print() method.
public class InterfacePrintable {
    interface Printable {
        void print();
    }
    static class Student implements Printable {
        String name = "Amit";
        int rollNo = 10;
        public void print() {
            System.out.println("Student Name: " + name);
            System.out.println("Roll No: " + rollNo);
        }
    }
    static class Teacher implements Printable {
        String name = "Mrs. Sharma";
        String subject = "Java";
        public void print() {
            System.out.println("Teacher Name: " + name);
            System.out.println("Subject: " + subject);
        }
    }
    public static void main(String[] args) {
        Printable s = new Student();
        Printable t = new Teacher();
        s.print();
        t.print();
    }
}
