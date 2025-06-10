package src.ui;

import src.dao.StudentDAO;
import src.model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField, courseField, yearField, deleteIdField;
    private JTextArea outputArea;

    public StudentUI() {
        setTitle("Student Management");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Course:"));
        courseField = new JTextField(20);
        add(courseField);

        add(new JLabel("Year:"));
        yearField = new JTextField(20);
        add(yearField);

        JButton addButton = new JButton("Add Student");
        add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String course = courseField.getText();
            String year = yearField.getText();
            Student s = new Student(name, course, year);
            StudentDAO.insertStudent(s);
            showAllStudents();
        });

        JButton viewButton = new JButton("View All Students");
        add(viewButton);

        viewButton.addActionListener(e -> showAllStudents());

        add(new JLabel("Delete Student ID:"));
        deleteIdField = new JTextField(5);
        add(deleteIdField);

        JButton deleteButton = new JButton("Delete Student");
        add(deleteButton);

        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(deleteIdField.getText());
                StudentDAO.deleteStudent(id);
                showAllStudents();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid ID");
            }
        });

        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));
    }

    private void showAllStudents() {
        List<Student> students = StudentDAO.getAllStudents();
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append("ID: ").append(s.getId()).append(" | Name: ").append(s.getName())
              .append(" | Course: ").append(s.getCourse())
              .append(" | Year: ").append(s.getYear()).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentUI ui = new StudentUI();
            ui.setVisible(true);
        });
    }
}

