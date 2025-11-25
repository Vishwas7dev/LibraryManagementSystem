package src.oop;

public class EBook extends Book {
    private double fileSize;

    public EBook(String title, String author, double fileSize) {
        super(title, author);   // calling parent constructor
        this.fileSize = fileSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("File Size: " + fileSize + " MB");
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("Java Programming", "James Gosling", 5.6);
        ebook.displayInfo();
    }
}

