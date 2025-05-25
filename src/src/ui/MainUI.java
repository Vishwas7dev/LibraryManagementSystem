package src.ui;

import src.dao.BookDAO;
import src.model.Book;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainUI extends JFrame {
    private static final long serialVersionUID = 1L; // ✅ Add this line

    private JTextField titleField, authorField, isbnField;
    private JTextArea bookListArea;
    private BookDAO bookDAO;

    public MainUI() {
        bookDAO = new BookDAO();

        setTitle("Library Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        titleField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();
        JButton addButton = new JButton("Add Book");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("ISBN:"));
        inputPanel.add(isbnField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        bookListArea = new JTextArea();
        bookListArea.setEditable(false);

        addButton.addActionListener(e -> {
            Book book = new Book(0, titleField.getText(), authorField.getText(), isbnField.getText());
            bookDAO.addBook(book);
            refreshBookList();
        });

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(bookListArea), BorderLayout.CENTER);

        refreshBookList();
        setVisible(true);
    }

    private void refreshBookList() {
        List<Book> books = bookDAO.getAllBooks();
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b.getTitle()).append(" - ").append(b.getAuthor()).append(" - ").append(b.getIsbn()).append("\n");
        }
        bookListArea.setText(sb.toString());
    }
}

  

