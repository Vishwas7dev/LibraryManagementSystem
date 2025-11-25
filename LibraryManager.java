package src.oop;

public class LibraryManager implements LibraryActions {

    @Override
    public void addBook(String title) {
        System.out.println("Adding book: " + title);
    }

    @Override
    public void removeBook(String title) {
        System.out.println("Removing book: " + title);
    }

    @Override
    public void searchBook(String title) {
        System.out.println("Searching for book: " + title);
    }

    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();

        lm.addBook("Java Programming");
        lm.removeBook("Data Structures");
        lm.searchBook("Python Basics");
    }
}

