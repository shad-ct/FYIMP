/*
 * Question:
 * Create a class `Book` with data members `title`, `author`, and `price`. Define both a default constructor and a parameterized constructor. Create objects using both constructors and display their details.
 */

class Book {
    String title;
    String author;
    double price;

    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println();
    }
}

public class BookDemo {
    public static void main(String[] args) {

        Book b1 = new Book();

        Book b2 = new Book(
            "The Alchemist",
            "Paulo Coelho",
            450
        );

        b1.display();
        b2.display();
    }
}
