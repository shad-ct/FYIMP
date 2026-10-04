// Write a Java program that accepts a string from the user and writes it into a file named output.txt using FileOutputStream. If the file already exists, append the new content without deleting the existing data.
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class FileWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write: ");
        String text = sc.nextLine();
        try {
            FileOutputStream fos = new FileOutputStream("output.txt", true);
            fos.write((text + "\n").getBytes());
            fos.close();
            System.out.println("Written to output.txt.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
        sc.close();
    }
}
