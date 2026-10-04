// Create a package structure college.department. Define a class ITStudent inside the department sub-package with a method to display student information. Write another Java program to import and use this class.
package college.department;
public class ITStudent {
    String name = "Sneha";
    int rollNo = 12;
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: IT");
    }
}
