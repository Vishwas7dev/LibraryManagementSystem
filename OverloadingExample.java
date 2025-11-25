package src.oop;

public class OverloadingExample {

    // Overloaded method 1
    public void addBook(String title) {
        System.out.println("Adding book with title only: " + title);
    }

    // Overloaded method 2
    public void addBook(String title, String author) {
        System.out.println("Adding book with title and author: " + title + " - " + author);
    }

    // Overloaded method 3
    public void addBook(String title, String author, int year) {
        System.out.println("Adding full book details: " + title + ", " + author + ", " + year);
    }

    public static void main(String[] args) {
        OverloadingExample obj = new OverloadingExample();
        obj.addBook("Python");
        obj.addBook("Java", "James Gosling");
        obj.addBook("C++", "Bjarne Stroustrup", 1998);
    }
}
