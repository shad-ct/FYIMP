/*
 * Question:
 * Create a class `Employee` with data members `name`, `id`, and `salary`. Create a method `display()` to display employee details. Create three employee objects and display their information.
 */

class Employee {
    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.name = "Arun";
        e1.id = 101;
        e1.salary = 30000;

        Employee e2 = new Employee();
        e2.name = "Rahul";
        e2.id = 102;
        e2.salary = 35000;

        Employee e3 = new Employee();
        e3.name = "Anu";
        e3.id = 103;
        e3.salary = 40000;

        e1.display();
        e2.display();
        e3.display();
    }
}
