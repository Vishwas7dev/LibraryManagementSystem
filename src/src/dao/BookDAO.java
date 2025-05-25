package src.dao;

import src.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;

    public BookDAO() {
        try {
            // Register the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Create connection to the SQLite DB (stored in 'database/library.db')
            conn = DriverManager.getConnection("jdbc:sqlite:database/library.db");

            // Create books table if it doesn't exist
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "title TEXT, " +
                    "author TEXT, " +
                    "isbn TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        try {
            String sql = "INSERT INTO books (title, author, isbn) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("isbn")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
