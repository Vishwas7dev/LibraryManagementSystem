package src.oop;

public class TestException {

    // Method that uses your custom InvalidBookException
    public static void validateBook(String title) throws InvalidBookException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidBookException("Book title cannot be empty!");
        }
        System.out.println("Valid book: " + title);
    }

    public static void main(String[] args) {
        try {
            validateBook("");   // This will throw InvalidBookException
        } catch (InvalidBookException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
