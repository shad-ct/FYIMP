// Write a Java program to copy the contents of one file into another using BufferedInputStream and BufferedOutputStream.
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileCopy {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("source.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("destination.txt"));
            int ch;
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }
            bis.close();
            bos.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("File error.");
        }
    }
}
