// Develop a Java program for a simple employee record system. Accept employee ID, name, and salary from the user and store the details in a file using DataOutputStream. Read and display all stored employee details using DataInputStream. Use appropriate exception handling and stream-closing mechanisms.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class EmployeeRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("employee.dat", true));
            dos.writeInt(id);
            dos.writeUTF(name);
            dos.writeDouble(salary);
            dos.close();
            DataInputStream dis = new DataInputStream(new FileInputStream("employee.dat"));
            System.out.println("Employee records:");
            while (true) {
                try {
                    System.out.println("ID: " + dis.readInt());
                    System.out.println("Name: " + dis.readUTF());
                    System.out.println("Salary: " + dis.readDouble());
                } catch (EOFException e) {
                    break;
                }
            }
            dis.close();
        } catch (IOException e) {
            System.out.println("File error.");
        }
        sc.close();
    }
}
