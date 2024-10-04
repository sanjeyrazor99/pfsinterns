
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI {
    private JFrame frame;
    private JTextField titleField, authorField, publisherField, yearField;
    private JTextField borrowerNameField, borrowerEmailField, borrowerPhoneField;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;
    private BookDAO bookDAO;
    private BorrowerDAO borrowerDAO;
    private TransactionDAO transactionDAO;

    public LibraryGUI() {
        bookDAO = new BookDAO();
        borrowerDAO = new BorrowerDAO();
        transactionDAO = new TransactionDAO();
        frame = new JFrame("Library Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Book Panel
        JPanel bookPanel = new JPanel(new BorderLayout());

        JPanel bookInputPanel = new JPanel(new GridLayout(5, 2));
        bookInputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        bookInputPanel.add(titleField);

        bookInputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        bookInputPanel.add(authorField);

        bookInputPanel.add(new JLabel("Publisher:"));
        publisherField = new JTextField();
        bookInputPanel.add(publisherField);

        bookInputPanel.add(new JLabel("Year:"));
        yearField = new JTextField();
        bookInputPanel.add(yearField);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        bookInputPanel.add(addBookButton);

        bookPanel.add(bookInputPanel, BorderLayout.NORTH);

        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        bookPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Books", bookPanel);

        // Borrower Panel
        JPanel borrowerPanel = new JPanel(new GridLayout(4, 2));
        borrowerPanel.add(new JLabel("Name:"));
        borrowerNameField = new JTextField();
        borrowerPanel.add(borrowerNameField);

        borrowerPanel.add(new JLabel("Email:"));
        borrowerEmailField = new JTextField();
        borrowerPanel.add(borrowerEmailField);

        borrowerPanel.add(new JLabel("Phone:"));
        borrowerPhoneField = new JTextField();
        borrowerPanel.add(borrowerPhoneField);

        JButton addBorrowerButton = new JButton("Add Borrower");
        addBorrowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBorrower();
            }
        });
        borrowerPanel.add(addBorrowerButton);

        tabbedPane.addTab("Borrowers", borrowerPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String publisher = publisherField.getText();
        int year = Integer.parseInt(yearField.getText());

        Book book = new Book(0, title, author, publisher, year);
        bookDAO.addBook(book);
        bookListModel.addElement(title + " by " + author);
        JOptionPane.showMessageDialog(frame, "Book added successfully!");
    }

    private void addBorrower() {
        String name = borrowerNameField.getText();
        String email = borrowerEmailField.getText();
        String phone = borrowerPhoneField.getText();

        Borrower borrower = new Borrower(0, name, email, phone);
        borrowerDAO.addBorrower(borrower);
        JOptionPane.showMessageDialog(frame, "Borrower added successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryGUI();
            }
        });
    }
}
