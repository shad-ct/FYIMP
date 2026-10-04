// Create a package named college containing a class Student with a method to display student details. Write another Java program outside the package to import the college package and access the Student class.
package college;
public class Student {
    String name = "Ravi";
    int rollNo = 5;
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}
