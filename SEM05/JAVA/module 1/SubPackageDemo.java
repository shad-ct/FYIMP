// Create a package structure college.department. Define a class ITStudent inside the department sub-package with a method to display student information. Write another Java program to import and use this class.
import college.department.ITStudent;
public class SubPackageDemo {
    public static void main(String[] args) {
        ITStudent s = new ITStudent();
        s.display();
    }
}
