// Create a class Book with data members title, author, and price. Define both a default constructor and a parameterized constructor. Create objects using both constructors and display their details.
public class BookConstructors {
    static class Book {
        String title;
        String author;
        double price;
        Book() {
            title = "Unknown";
            author = "Unknown";
            price = 0.0;
        }
        Book(String t, String a, double p) {
            title = t;
            author = a;
            price = p;
        }
        void display() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: " + price);
        }
    }
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Programming", "James Gosling", 499.50);
        System.out.println("Book 1 details:");
        b1.display();
        System.out.println("Book 2 details:");
        b2.display();
    }
}
