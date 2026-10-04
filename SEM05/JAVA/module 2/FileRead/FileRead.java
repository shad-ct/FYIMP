// Write a Java program to read the contents of a text file named input.txt using FileInputStream and display the contents on the console. Handle possible exceptions appropriately and ensure that the stream is closed after reading.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FileRead {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("input.txt");
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}
