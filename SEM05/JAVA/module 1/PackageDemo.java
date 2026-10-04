// Create a package named college containing a class Student with a method to display student details. Write another Java program outside the package to import the college package and access the Student class.
import college.Student;
public class PackageDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
