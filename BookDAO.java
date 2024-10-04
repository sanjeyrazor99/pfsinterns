

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook(Book book) {
        book.setBookId(nextId++);
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == book.getBookId()) {
                books.set(i, book);
                return;
            }
        }
    }

    public void deleteBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
    }
}
