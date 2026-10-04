// Write a Java program to store the details of a student such as roll number, name, and marks in a file using DataOutputStream. Then, read the same data from the file using DataInputStream and display the student details.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class DataStreamDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));
            dos.writeInt(roll);
            dos.writeUTF(name);
            dos.writeDouble(marks);
            dos.close();
            DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));
            System.out.println("Roll No: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("Marks: " + dis.readDouble());
            dis.close();
        } catch (IOException e) {
            System.out.println("File error.");
        }
        sc.close();
    }
}
